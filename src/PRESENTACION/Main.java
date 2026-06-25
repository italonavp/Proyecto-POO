package PRESENTACION;

import DATOS.ClienteCategoriaDAO;
import ALGORITMO.ArbolDecision;
import MODELO.Registro;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Orquestador principal del Sistema Predictivo Northwind.
 * Controla el flujo completo: Extracción, Split de Datos, Entrenamiento, Validación y Despliegue de la UI.
 */
public class Main {

    public static ReporteGrafico generarDashboard() {
        System.out.println("=== INICIANDO SISTEMA PREDICTIVO NORTHWIND ===");
        
        // 1. OBTENCIÓN DE DATOS (Capa de Datos)
        ClienteCategoriaDAO dao = new ClienteCategoriaDAO();
        List<Registro> todosLosDatos = dao.obtenerDatosParaArbol();
        
        if (todosLosDatos.isEmpty()) {
            System.err.println("❌ No hay datos para procesar. Abortando ejecución.");
            return null;
        }

        // Aleatorización para garantizar un split insesgado y homogéneo
        Collections.shuffle(todosLosDatos);

        // 2. CONSTRUCCIÓN DE DATASETS: Entrenamiento (70%) y Prueba (30%)
        int limiteEntrenamiento = (int) (todosLosDatos.size() * 0.7);
        
        List<Registro> datosEntrenamiento = new ArrayList<>(todosLosDatos.subList(0, limiteEntrenamiento));
        List<Registro> datosPrueba = new ArrayList<>(todosLosDatos.subList(limiteEntrenamiento, todosLosDatos.size()));

        System.out.println("📝 Registros para Entrenamiento: " + datosEntrenamiento.size());
        System.out.println("📝 Registros para Prueba: " + datosPrueba.size());

        // 3. INDUCCIÓN DEL ÁRBOL (Capa de Algoritmos)
        System.out.println("\n🌳 Entrenando el Árbol de Decisión desde cero (Hiperparámetros: MaxDepth=5, MinSamplesSplit=10)...");
        ArbolDecision miArbol = new ArbolDecision(5, 10);
        miArbol.fit(datosEntrenamiento);
        System.out.println("Campana_Mkt_Total✅ Estructura del árbol generada en memoria RAM.");

        // 4. EVALUACIÓN Y MATRIZ DE CONFUSIÓN (Hold-Out Validation)
        System.out.println("\n🧪 Evaluando capacidad de generalización con datos de prueba...");
        int vPositivos = 0;  // Real: 1, Predicho: 1 (True Positives)
        int fPositivos = 0;  // Real: 0, Predicho: 1 (False Positives)
        int vNegativos = 0;  // Real: 0, Predicho: 0 (True Negatives)
        int fNegativos = 0;  // Real: 1, Predicho: 0 (False Negatives)

        for (Registro r : datosPrueba) {
            int prediccion = miArbol.predict(r);
            int real = r.getVolvioAComprar();

            if (prediccion == 1 && real == 1) vPositivos++;
            else if (prediccion == 1 && real == 0) fPositivos++;
            else if (prediccion == 0 && real == 0) vNegativos++;
            else if (prediccion == 0 && real == 1) fNegativos++;
        }

        // 5. CÁLCULO DE MÉTRICAS ANALÍTICAS
        int totalesEvaluados = datosPrueba.size();
        int aciertos = vPositivos + vNegativos;
        double accuracyCalculado = ((double) aciertos / totalesEvaluados) * 100;

        // Impresión de la evaluación del clasificador
        System.out.println("\n=============================================");
        System.out.println("            RESULTADOS DEL MODELO            ");
        System.out.println("=============================================");
        System.out.printf("🎯 Precisión General (Accuracy): %.2f%%\n", accuracyCalculado);
        System.out.println("---------------------------------------------");
        System.out.println("📊 MATRIZ DE CONFUSIÓN:");
        System.out.println("                     Predicho: NO   Predicho: SÍ");
        System.out.println("Real: NO volvió      |      " + vNegativos + "      |      " + fPositivos);
        System.out.println("Real: SÍ volvió      |      " + fNegativos + "      |      " + vPositivos);
        System.out.println("=============================================");
        
        // Transferencia de estados calculados hacia hilos de la UI (EDT Swing)
        final int vnGrafico = vNegativos;
        final int fpGrafico = fPositivos;
        final int fnGrafico = fNegativos;
        final int vpGrafico = vPositivos;
        final double accGrafico = accuracyCalculado;
        
        ReporteGrafico ventana = new ReporteGrafico(
            vnGrafico, fpGrafico, fnGrafico, vpGrafico, accGrafico, todosLosDatos, miArbol
        );
        
        
        
        // 6. LOG DE DESPLIEGUE COMERCIAL (Estrategia de Business Intelligence)
        int totalCampana = 0;
        for (Registro r : todosLosDatos) {
            if (miArbol.predict(r) == 1) {
                totalCampana++;
            }
        }
        
        
        System.out.println("\n DESPLIEGUE COMERCIAL DE OPERACIONES:");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Total de perfiles identificados para campaña de Marketing: " + totalCampana);
        System.out.println("Nota: El reporte detallado por cliente y país ha sido trasladado al Dashboard interactivo.");
        System.out.println("=============================================================================\n");
        return ventana;
    }
}