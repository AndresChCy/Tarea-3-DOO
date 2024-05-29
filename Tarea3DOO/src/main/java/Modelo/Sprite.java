package Modelo;

/**
 * Subclase de Bebida que representa una Sprite.
 */
class Sprite extends Bebida {
    /**
     * Método constructor de Sprite que permite asignarle un número de serie.
     * @param NumSerie Número que representa la serie del producto.
     */
    public Sprite(int NumSerie) {
        super(NumSerie);
    }

    /**
     * Método que es para representarse a sí mismo al consumirse.
     * @return String que dice que corresponde a una Sprite.
     */
    public String consumirlo(){
        return "Sprite";
    }
}
