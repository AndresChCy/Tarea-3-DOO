package Modelo;

/**
 * Excepcion especifica, es arrojada cuando se identifica que no hay más productos en el deposito.
 */
public class PagoInsuficienteException extends Exception {
    /** Constructor que hereda los datos de la clase Exception. */
    public PagoInsuficienteException(String mensajeError){
        super(mensajeError);
    }
}
