package Markov;

import java.util.*;

public class MarkovChain {

    // Matriz de transiciones: Producto A -> Producto B -> cantidad de veces
    private Map<String, Map<String, Integer>> conteoTransiciones;
    // Matriz de probabilidades calculadas
    private Map<String, Map<String, Double>> matrizProbabilidades;

    public MarkovChain() {
        this.conteoTransiciones = new HashMap<>();
        this.matrizProbabilidades = new HashMap<>();
    }

    /**
     * Registra una transición: "después de A, se compró B"
     */
    public void agregarTransicion(String productoActual, String productoSiguiente) {
        conteoTransiciones
                .computeIfAbsent(productoActual, k -> new HashMap<>())
                .merge(productoSiguiente, 1, Integer::sum);
    }

    /**
     * Calcula las probabilidades a partir de los conteos
     */
    public void calcularProbabilidades() {
        matrizProbabilidades.clear();

        for (Map.Entry<String, Map<String, Integer>> entrada : conteoTransiciones.entrySet()) {
            String productoOrigen = entrada.getKey();
            Map<String, Integer> destinos = entrada.getValue();

            // Total de transiciones desde este producto
            int total = destinos.values().stream().mapToInt(Integer::intValue).sum();

            Map<String, Double> probabilidades = new LinkedHashMap<>();
            destinos.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(e -> probabilidades.put(e.getKey(), (double) e.getValue() / total));

            matrizProbabilidades.put(productoOrigen, probabilidades);
        }
    }

    /**
     * Obtiene las top N recomendaciones para un producto dado
     */
    public List<String[]> obtenerRecomendaciones(String productoActual, int topN) {
        List<String[]> resultado = new ArrayList<>();
        Map<String, Double> probs = matrizProbabilidades.get(productoActual);

        if (probs == null) {
            return resultado;
        }

        probs.entrySet().stream()
                .limit(topN)
                .forEach(e -> resultado.add(new String[]{
            e.getKey(),
            String.format("%.1f%%", e.getValue() * 100)
        }));

        return resultado;
    }

    public Map<String, Map<String, Double>> getMatrizProbabilidades() {
        return matrizProbabilidades;
    }
}
