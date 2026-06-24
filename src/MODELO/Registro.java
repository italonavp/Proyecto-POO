package MODELO;

/*
 * Representa una fila de datos consolidada (vínculo Cliente-Categoría).
 * Actúa como la unidad de análisis para el entrenamiento y predicción del árbol.
 */
public class Registro {
    
    // Características o Atributos (Features)
    private final String idCliente;
    private final String paisCliente;           
    private final String nombreCategoria;       
    private final double montoTotalGastado;     
    private final int cantidadProductosComprados;
    
    // Variable Objetivo (Target): 1 = Recompra, 0 = Compra única
    private final int volvioAComprar; 

    // Constructor unificado para la Capa de Datos (DAO)
    public Registro(String idCliente, String paisCliente, String nombreCategoria, 
                    double montoTotalGastado, int cantidadProductosComprados, int volvioAComprar) {
        this.idCliente = idCliente;
        this.paisCliente = paisCliente;
        this.nombreCategoria = nombreCategoria;
        this.montoTotalGastado = montoTotalGastado;
        this.cantidadProductosComprados = cantidadProductosComprados;
        this.volvioAComprar = volvioAComprar;
    }

    // Métodos Accesores (Getters) utilizados por el Árbol de Decisión y la UI
    public String getIdCliente() { return idCliente; }
    public String getPaisCliente() { return paisCliente; }
    public String getNombreCategoria() { return nombreCategoria; }
    public double getMontoTotalGastado() { return montoTotalGastado; }
    public int getCantidadProductosComprados() { return cantidadProductosComprados; }
    public int getVolvioAComprar() { return volvioAComprar; }
}