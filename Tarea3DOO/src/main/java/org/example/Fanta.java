package org.example;

/**
 * Subclase de Bebida que representa una Fanta.
 */
class Fanta extends Bebida {
    /**
     * Método constructor de Fanta que permite asignarle un número de serie.
     * @param numSerie Número que representa la serie del producto.
     */
    public Fanta(int numSerie) {
        super(numSerie);
    }

    /**
     * Método que es para representarse a sí mismo al consumirse.
     * @return String que dice que corresponde a una Fanta.
     */
    public String consumirlo(){
        return "Fanta";
    }
}
