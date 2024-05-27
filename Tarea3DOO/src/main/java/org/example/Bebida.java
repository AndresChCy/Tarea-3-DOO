package org.example;

/**
 * Subclase abstracta de producto, representa un tipo de bebida.
 */
abstract class Bebida extends Producto {
    /**
     * Método constructor de Bebida que permite asignarle un número de serie.
     * @param NumSerie Número que representa la serie del objeto.
     */
    public Bebida(int NumSerie) {
        super(NumSerie);
    }
}
