package ALGORITMO;

import MODELO.Registro;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Motor algorítmico principal del Árbol de Decisión (Modelo de Inducción CART).
 * Genera la estructura jerárquica de forma recursiva minimizando la impureza de Gini.
 */
public class ArbolDecision {
    private Nodo raiz;
    private final int maxDepth;
    private final int minSamplesSplit;

    public ArbolDecision(int maxDepth, int minSamplesSplit) {
        this.maxDepth = maxDepth;
        this.minSamplesSplit = minSamplesSplit;
    }

    /** Entrena el modelo basándose en un conjunto de datos inicial (Fase de Ajuste). */
    public void fit(List<Registro> datos) {
        this.raiz = construirArbol(datos, 0);
    }

    // Algoritmo Inductivo Recursivo Top-Down
    private Nodo construirArbol(List<Registro> datos, int profundidadActual) {
        int numMuestras = datos.size();

        // --- CRITERIOS DE PARADA (Pre-Pruning) ---
        if (profundidadActual >= maxDepth || numMuestras < minSamplesSplit) {
            return new Nodo(calcularClaseMayoritaria(datos));
        }

        // Nodo Puro: Si la impureza de Gini llega a 0, detenemos la ramificación
        if (EvaluadorCorte.calcularGini(datos) == 0.0) {
            return new Nodo(calcularClaseMayoritaria(datos));
        }

        // --- SELECCIÓN MATEMÁTICA DEL MEJOR CORTE ---
        Corte mejorCorte = buscarMejorCorte(datos);

        // Si el beneficio del corte es nulo o negativo, se convierte en Hoja
        if (mejorCorte == null || mejorCorte.getGanancia() <= 0.0) {
            return new Nodo(calcularClaseMayoritaria(datos));
        }

        // --- CONSTRUCCIÓN RECURSIVA BINARIA ---
        Nodo hijoIzquierdo = construirArbol(mejorCorte.getDatosIzquierda(), profundidadActual + 1);
        Nodo hijoDerecho = construirArbol(mejorCorte.getDatosDerecha(), profundidadActual + 1);

        return new Nodo(
            mejorCorte.getAtributo(), mejorCorte.isNumerico(),
            mejorCorte.getValorCategorico(), mejorCorte.getUmbralNumerico(),
            hijoIzquierdo, hijoDerecho
        );
    }

    private int calcularClaseMayoritaria(List<Registro> datos) {
        int c0 = 0, c1 = 0;
        for (Registro r : datos) {
            if (r.getVolvioAComprar() == 1) c1++;
            else c0++;
        }
        return (c1 >= c0) ? 1 : 0;
    }

    // Escaneo de hiperplanos de corte para maximizar la Ganancia de Información
    private Corte buscarMejorCorte(List<Registro> datos) {
        Corte mejorCorte = null;
        double mejorGanancia = -1.0;

        // 1. VARIABLE NUMÉRICA CONTINUA: montoTotalGastado
        List<Double> montos = new ArrayList<>();
        for (Registro r : datos) {
            if (!montos.contains(r.getMontoTotalGastado())) montos.add(r.getMontoTotalGastado());
        }
        Collections.sort(montos);

        for (int i = 0; i < montos.size() - 1; i++) {
            double umbral = (montos.get(i) + montos.get(i + 1)) / 2.0; // Punto medio
            List<Registro> izq = new ArrayList<>();
            List<Registro> der = new ArrayList<>();

            for (Registro r : datos) {
                if (r.getMontoTotalGastado() <= umbral) izq.add(r);
                else der.add(r);
            }

            if (!izq.isEmpty() && !der.isEmpty()) {
                double ganancia = EvaluadorCorte.calcularGanancia(datos, izq, der);
                if (ganancia > mejorGanancia) {
                    mejorGanancia = ganancia;
                    mejorCorte = new Corte("montoTotalGastado", true, null, umbral, ganancia, izq, der);
                }
            }
        }

        // 2. VARIABLE NUMÉRICA DISCRETA: cantidadProductosComprados
        List<Integer> cantidades = new ArrayList<>();
        for (Registro r : datos) {
            if (!cantidades.contains(r.getCantidadProductosComprados())) cantidades.add(r.getCantidadProductosComprados());
        }
        Collections.sort(cantidades);

        for (int i = 0; i < cantidades.size() - 1; i++) {
            double umbral = (cantidades.get(i) + cantidades.get(i + 1)) / 2.0;
            List<Registro> izq = new ArrayList<>();
            List<Registro> der = new ArrayList<>();

            for (Registro r : datos) {
                if (r.getCantidadProductosComprados() <= umbral) izq.add(r);
                else der.add(r);
            }

            if (!izq.isEmpty() && !der.isEmpty()) {
                double ganancia = EvaluadorCorte.calcularGanancia(datos, izq, der);
                if (ganancia > mejorGanancia) {
                    mejorGanancia = ganancia;
                    mejorCorte = new Corte("cantidadProductosComprados", true, null, umbral, ganancia, izq, der);
                }
            }
        }

        // 3. VARIABLE CATEGÓRICA: paisCliente
        List<String> paises = new ArrayList<>();
        for (Registro r : datos) {
            if (!paises.contains(r.getPaisCliente())) paises.add(r.getPaisCliente());
        }

        for (String pais : paises) {
            List<Registro> izq = new ArrayList<>();
            List<Registro> der = new ArrayList<>();

            for (Registro r : datos) {
                if (r.getPaisCliente().equals(pais)) izq.add(r);
                else der.add(r);
            }

            if (!izq.isEmpty() && !der.isEmpty()) {
                double ganancia = EvaluadorCorte.calcularGanancia(datos, izq, der);
                if (ganancia > mejorGanancia) {
                    mejorGanancia = ganancia;
                    mejorCorte = new Corte("paisCliente", false, pais, 0.0, ganancia, izq, der);
                }
            }
        }

        // 4. VARIABLE CATEGÓRICA: nombreCategoria
        List<String> categorias = new ArrayList<>();
        for (Registro r : datos) {
            if (!categorias.contains(r.getNombreCategoria())) categorias.add(r.getNombreCategoria());
        }

        for (String cat : categorias) {
            List<Registro> izq = new ArrayList<>();
            List<Registro> der = new ArrayList<>();

            for (Registro r : datos) {
                if (r.getNombreCategoria().equals(cat)) izq.add(r);
                else der.add(r);
            }

            if (!izq.isEmpty() && !der.isEmpty()) {
                double ganancia = EvaluadorCorte.calcularGanancia(datos, izq, der);
                if (ganancia > mejorGanancia) {
                    mejorGanancia = ganancia;
                    mejorCorte = new Corte("nombreCategoria", false, cat, 0.0, ganancia, izq, der);
                }
            }
        }

        return mejorCorte;
    }

    /** Clasifica un nuevo registro de forma deductiva instantánea en O(log N). */
    public int predict(Registro nuevo) {
        if (this.raiz == null) {
            throw new IllegalStateException("El árbol debe entrenarse con fit() antes de predecir.");
        }
        return evaluarRegistroEnNodo(this.raiz, nuevo);
    }

    // Inferencia por descenso recursivo en la estructura jerárquica
    private int evaluarRegistroEnNodo(Nodo nodo, Registro nuevo) {
        if (nodo.isHoja()) {
            return nodo.getClasePredicha();
        }

        boolean irIzquierda = false;

        if (nodo.isEsAtributoNumerico()) {
            double valorRegistro = nodo.getAtributoCorte().equals("montoTotalGastado") 
                ? nuevo.getMontoTotalGastado() : nuevo.getCantidadProductosComprados();
                
            if (valorRegistro <= nodo.getUmbralNumericoCorte()) irIzquierda = true;
        } else {
            String valorRegistroStr = nodo.getAtributoCorte().equals("paisCliente") 
                ? nuevo.getPaisCliente() : nuevo.getNombreCategoria();
                
            if (valorRegistroStr.equals(nodo.getValorCategoricoCorte())) irIzquierda = true;
        }

        return irIzquierda 
            ? evaluarRegistroEnNodo(nodo.getHijoIzquierdo(), nuevo) 
            : evaluarRegistroEnNodo(nodo.getHijoDerecho(), nuevo);
    }
}