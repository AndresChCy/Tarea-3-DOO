package org.example;

/**
 * Subclase de Dulce que representa un Snicker.
 */
class Snicker extends Dulce {
    /**
     * Método constructor de Snicker que permite asignarle un número de serie.
     * @param NumSerie Número que representa la serie del producto.
     */
    public Snicker(int NumSerie) {
        super(NumSerie);
    }

    /**
     * Método que es para representarse a sí mismo al consumirse.
     * @return String que dice que corresponde a un Snicker.
     */
    public String consumirlo(){
        return "Snicker";
    }
}
