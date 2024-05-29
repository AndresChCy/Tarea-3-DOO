package Modelo;

/**
 * Excepcion especifica, es arrojada cuando se identifica que no hay más productos en el deposito.
 */
public class NoHayProductoException extends Exception {
    /** Constructor que hereda los datos de la clase Exception. */
    public NoHayProductoException(String mensajeError){
        super(mensajeError);
    }
}
