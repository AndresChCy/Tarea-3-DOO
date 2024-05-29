package Modelo;

/**
 * Subclase de Bebida que representa una CocaCola.
 */
class CocaCola extends Bebida {
    /**
     * Método constructor de CocaCola que permite asignarle un número de serie.
     * @param numSerie Número que representa la serie del producto.
     */
    public CocaCola(int numSerie) {
        super(numSerie);
    }

    /**
     * Método que es para representarse a sí mismo al consumirse.
     * @return String que dice que corresponde a una CocaCola.
     */
    public String consumirlo(){
        return "CocaCola";
    }
}