package ALGORITMO;

import MODELO.Registro;
import java.util.List;

/**
 * Motor matemático de soporte. 
 * Implementa las fórmulas del algoritmo CART para evaluar la calidad de las divisiones.
 */
public class EvaluadorCorte {

    /**
     * Calcula la Impureza de Gini para un conjunto de registros.
     * Fórmula: $Gini(D) = 1 - \sum (p_i)^2$
     * Rango: 0.0 (Pureza absoluta) a 0.5 (Máxima incertidumbre binaria).
     */
    public static double calcularGini(List<Registro> datos) {
        if (datos == null || datos.isEmpty()) {
            return 0.0;
        }

        int total = datos.size();
        int cuentaClase0 = 0; // Target = 0 (Compra única)
        int cuentaClase1 = 0; // Target = 1 (Recompra)

        for (Registro r : datos) {
            if (r.getVolvioAComprar() == 1) {
                cuentaClase1++;
            } else {
                cuentaClase0++;
            }
        }

        // Proporciones de probabilidad estadística
        double p0 = (double) cuentaClase0 / total;
        double p1 = (double) cuentaClase1 / total;

        // Retorna la impureza remanente
        return 1.0 - ((p0 * p0) + (p1 * p1));
    }

    /**
     * Calcula la Ganancia de Información mediante la reducción del Índice de Gini.
     * Fórmula: Ganancia = Gini(Padre) - [∑ (Muestras_Hijo / Muestras_Padre) * Gini(Hijo)]
     */
    public static double calcularGanancia(List<Registro> padre, List<Registro> izquierda, List<Registro> derecha) {
        double giniPadre = calcularGini(padre);
        
        // Ponderación de pesos basada en la proporción de muestras que caen en cada rama
        double pesoIzquierda = (double) izquierda.size() / padre.size();
        double pesoDerecha = (double) derecha.size() / padre.size();
        
        double giniHijosPonderado = (pesoIzquierda * calcularGini(izquierda)) + (pesoDerecha * calcularGini(derecha));
        
        // La ganancia es el beneficio neto de pureza obtenido tras la división
        return giniPadre - giniHijosPonderado;
    }
}