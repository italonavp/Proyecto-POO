package ALGORITMO;

import MODELO.Registro;
import java.util.List;

/**
 * Estructura contenedora que encapsula las propiedades de una división binaria óptima.
 */
public class Corte {
    private final String atributo;
    private final boolean numerico;
    private final String valorCategorico;
    private final double umbralNumerico;
    private final double ganancia;
    private final List<Registro> datosIzquierda;
    private final List<Registro> datosDerecha;

    public Corte(String atributo, boolean numerico, String valorCategorico, double umbralNumerico, 
                 double ganancia, List<Registro> datosIzquierda, List<Registro> datosDerecha) {
        this.atributo = atributo;
        this.numerico = numerico;
        this.valorCategorico = valorCategorico;
        this.umbralNumerico = umbralNumerico;
        this.ganancia = ganancia;
        this.datosIzquierda = datosIzquierda;
        this.datosDerecha = datosDerecha;
    }

    // Métodos accesores leídos por el constructor de nodos en el Árbol
    public String getAtributo() { return atributo; }
    public boolean isNumerico() { return numerico; }
    public String getValorCategorico() { return valorCategorico; }
    public double getUmbralNumerico() { return umbralNumerico; }
    public double getGanancia() { return ganancia; }
    public List<Registro> getDatosIzquierda() { return datosIzquierda; }
    public List<Registro> getDatosDerecha() { return datosDerecha; }
}