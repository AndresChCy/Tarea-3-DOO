package Modelo;
import java.util.ArrayList;

/**
 * Clase que representa un comprador.
 */
public class Comprador {
    private Object[] Mano;
    private ArrayList<Moneda> Bolsillo;
    private String sonido;
    private int vuelto;

    /**
     * Constructor de la clase que instancia todas las variables.
     */
    public Comprador() {
        Mano = new Object[1];
        Bolsillo = new ArrayList<>();
        sonido = null;
        vuelto = 0;
    }

    /**
     * Método add que añade monedas al bolsillo,
     * @param m     Moneda que se desea meter al bolsillo.
     */
    public void addMonedaBolsillo(Moneda m) {
        if ( Bolsillo.size()<10 ) {
            Bolsillo.add(m);
        } else {
            System.out.println("No se puede seleccionar más monedas.");
        }
    }

    /**
     * Método get que saca una moneda del bolsillo.
     * @param numero        Posición de la moneda que se busca.
     * @throws Exception    Excepción de SetMonedaMano.
     */
    public void getMonedaBolsillo(int numero) throws Exception {
        if ( numero<10 && numero>=0 ) {
            SetMonedaMano(Bolsillo.get(numero));
            Bolsillo.remove(numero);
        } else {
            System.out.println("No se puede escoger un posición que no existe.");
        }
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
        exp.comprarProducto(CualProducto);
        Mano[0] = exp.getProducto();

        Moneda m2 = exp.getVuelto();
        while(m2 != null){
            vuelto = vuelto + m2.getValor();
            m2 = exp.getVuelto();
        }
    }

    /**
     * Método para que el comprador pague.
     * @param exp           Expendedor al que se le va a pagar.
     * @throws Exception    Excepción cuando no se paga con una moneda.
     */
    public void Pagar(Expendedor exp) throws Exception {
        try {
            exp.Pagar((Moneda) Mano[0]);
        } catch ( Exception e) {
            throw new Exception("No tienes una moneda en la mano.");
        }
    }

    /**
     * Método que sirve para consumir el producto que se encuentra en la mano.
     * @throws Exception    Excepción para cuando se intenta consumir algo que no es un producto.
     */
    public void ConsumirDeLaMano() throws Exception {
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
