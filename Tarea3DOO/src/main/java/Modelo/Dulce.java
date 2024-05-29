package Modelo;

/**
 * Subclase abstracta de producto, representa un tipo de dulce.
 */
abstract class Dulce extends Producto {
    /**
     * Método constructor de Dulce que permite asignarle un número de serie.
     * @param NumSerie Número que representa la serie del objeto.
     */
    public Dulce(int NumSerie) {
        super(NumSerie);
    }
}
