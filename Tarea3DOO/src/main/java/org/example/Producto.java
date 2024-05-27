package org.example;

/**
 * Super-Superclase que conforma a todos los productos del programa.
 */
abstract class Producto {
    /** Int para almacenar el número de serie del producto */
    private int serie;

    /**
     * Método constructor que sirve para asignarle la serie al producto.
     * @param NumSerie Número que representa el número de la serie.
     */
    public Producto(int NumSerie) {
        serie = NumSerie;
    }

    /** Método abstracto que tendrá uso por las extensiones(sub-subclases) para representarse. */
    public abstract String consumirlo();

    /**
     * Método getter que sirve para obtener el número de serie del producto.
     * @return Número de serie del producto.
     */
    public int getSerie() {
        return serie;
    }
}
