package org.example;

/**
 * Excepcion especifica, es arrojada cuando se identifica que la moneda es nula.
 */
public class PagoIncorrectoException extends Exception {
    /** Constructor que hereda los datos de la clase Exception. */
    public PagoIncorrectoException(String mensajeError){
        super(mensajeError);
    }
}
