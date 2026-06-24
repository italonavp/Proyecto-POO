package ALGORITMO;

/**
 * Representa un componente (unidad estructural) del Árbol de Decisión.
 * Puede comportarse como un Nodo de Decisión (bifurcación) o como un Nodo Hoja (resultado).
 */
public class Nodo {
    
    // Estado del Nodo
    private final boolean esHoja;
    private int clasePredicha; // Solo válido si esHoja es true (0 o 1)

    // Atributos de Decisión (Estrategia de división binaria)
    private String atributoCorte; 
    private boolean esAtributoNumerico;
    
    // Criterios de evaluación para el umbral
    private String valorCategoricoCorte; 
    private double umbralNumericoCorte;  

    // Punteros de la estructura jerárquica
    private Nodo hijoIzquierdo;
    private Nodo hijoDerecho;

    /**
     * Constructor para Nodo HOJA (Punto terminal que dicta la predicción final).
     */
    public Nodo(int clasePredicha) {
        this.esHoja = true;
        this.clasePredicha = clasePredicha;
    }

    /**
     * Constructor para Nodo de DECISIÓN (Punto de evaluación que bifurca el flujo).
     */
    public Nodo(String atributoCorte, boolean esAtributoNumerico, String valorCategoricoCorte, 
                double umbralNumericoCorte, Nodo hijoIzquierdo, Nodo hijoDerecho) {
        this.esHoja = false;
        this.atributoCorte = atributoCorte;
        this.esAtributoNumerico = esAtributoNumerico;
        this.valorCategoricoCorte = valorCategoricoCorte;
        this.umbralNumericoCorte = umbralNumericoCorte;
        this.hijoIzquierdo = hijoIzquierdo;
        this.hijoDerecho = hijoDerecho;
    }

    // Métodos de acceso para el algoritmo de recorrido recursivo (Inferencia)
    public boolean isHoja() { return esHoja; }
    public int getClasePredicha() { return clasePredicha; }
    public String getAtributoCorte() { return atributoCorte; }
    public boolean isEsAtributoNumerico() { return esAtributoNumerico; }
    public String getValorCategoricoCorte() { return valorCategoricoCorte; }
    public double getUmbralNumericoCorte() { return umbralNumericoCorte; }
    public Nodo getHijoIzquierdo() { return hijoIzquierdo; }
    public Nodo getHijoDerecho() { return hijoDerecho; }
}