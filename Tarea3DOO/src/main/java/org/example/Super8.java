package org.example;

/**
 * Subclase de Dulce que representa un Super8.
 */
class Super8 extends Dulce {
    /**
     * Método constructor de Super8 que permite asignarle un número de serie.
     * @param NumSerie Número que representa la serie del producto.
     */
    public Super8(int NumSerie) {
        super(NumSerie);
    }

    /**
     * Método que es para representarse a sí mismo al consumirse.
     * @return String que dice que corresponde a un Super 8.
     */
    public String consumirlo() {
        return "Super 8";
    }
}

