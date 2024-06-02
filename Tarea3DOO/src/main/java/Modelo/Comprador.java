package Modelo;
import java.lang.reflect.Array;

/**
 * Clase que representa un comprador.
 */
class Comprador {
    private Object[] Mano;
    private String sonido;
    private int vuelto;

    /**
     * Constructor de la clase que instancia la mano.
     */
    public Comprador() {
        Mano = new Object[1];
    }

    /**
     * Método set que establece la moneda en la mano.
     * @param m             Moneda que utilizará el comprador.
     * @throws Exception    Excepción para cuando no se trata de una moneda.
     */
    public void SetMonedaMano(Moneda m) throws Exception {
        if ( Mano[0]!=null ) {
            throw new Exception("Ya tienes una moneda en la mano.");
        } else {
            Mano[0] = m;
        }
    }

    /**
     * Método que sirve para comprar un producto de un expendedor.
     * @param CualProducto                  Tipo de producto que se intenta comprar.
     * @param exp                           Expendedor del cual se quiere comprar.
     * @throws Exception                    Excepción para cuando se intenta comprar con un objeto de la mano que no es una moneda.
     * @throws PagoIncorrectoException      Excepción para cuando se hace un pago incorrecto.
     * @throws PagoInsuficienteException    Excepción para cuando se hace un pago insuficiente.
     * @throws NoHayProductoException       Excepción para cuando no hay productos.
     */
    public void Comprar(CaracteristicasProducto CualProducto, Expendedor exp) throws Exception, PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        vuelto = 0;
        Moneda m;

        try {
            m = (Moneda) Mano[0];
            Mano[0] = null;
        } catch ( Exception e) {
            throw new Exception("Error, ha intentado comprar con algo que no es una moneda.");
        }

        exp.comprarProducto(m, CualProducto);
        Mano[0] = exp.getProducto();


        Moneda m2 = exp.getVuelto();
        while(m2 != null){
            vuelto = vuelto + m2.getValor();
            m2 = exp.getVuelto();
        }
    }

    /**
     * Método que sirve para consumir el producto que se encuentra en la mano.
     * @throws Exception    Excepción para cuando se intenta consumir algo que no es un producto.
     */
    public void ConsumirDeLaMano() throws Exception {
        sonido = null;
        try {
            sonido = ((Producto) Mano[0]).consumirlo();
            Mano[0] = null;
        } catch (Exception e) {
            throw new Exception("Error, no puede consumir algo que no es un producto.");
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
