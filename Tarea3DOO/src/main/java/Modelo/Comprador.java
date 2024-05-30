package Modelo;

/**
 * Clase que representa un comprador.
 */
public class Comprador {
    private String sonido;
    private int vuelto;

    /**
     * Constructor de la clase que realiza una compra en un expendedor con moneda y producto especificado.
     * @param m                             Moneda que utiliza el comprador para comprar.
     * @param CualProducto                  Tipo de producto que el comprador desea comprar.
     * @param exp                           Expendedor que el comprador utilizará para comprar.
     * @throws PagoIncorrectoException      Excepción para cuando el pago no es valido.
     * @throws PagoInsuficienteException    Excepción para cuando el pago es insuficiente.
     * @throws NoHayProductoException       Excepción para cuando no hay tipo del producto buscado.
     */
    public Comprador(Moneda m, CaracteristicasProducto CualProducto, Expendedor exp) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        vuelto = 0;
        sonido = null;
        exp.comprarProducto(m, CualProducto);
        Producto producto = exp.getProducto();
        sonido = producto.consumirlo();
        Moneda m2 = exp.getVuelto();
        while(m2 != null){
            vuelto = vuelto + m2.getValor();
            m2 = exp.getVuelto();
        }
    }

    /**
     * Método para obtener el vuelto de la compra.
     * @return  Int que representa el vuelto.
     */
    public int cuantoVuelto(){
        return vuelto;
    }

    /**
     * Método para obtener el tipo de producto que consumió el comprador.
     * @return  String que representa el nombre del producto.
     */
    public String queConsumiste(){
        return sonido;
    }
}
