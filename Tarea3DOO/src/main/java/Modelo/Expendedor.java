package Modelo;
import java.util.ArrayList;

/**
 * Un expendedor al que le puedes comprar productos usando monedas.
 */
public class Expendedor {
    /** Creamos una lista de depositos, un deposito para monedas, un deposito unico y un deposito especial*/
    private ArrayList<Producto>[] depositos;
    private Deposito<Moneda> DepositoVuelto;
    private Deposito<Moneda> DepositoMonedasUnico;
    private Producto DepositoEspecial;

    /** Metodo constructor que rellena sus depositos para productos de forma magica */
    public Expendedor(int NumProductos) {
        DepositoVuelto = new Deposito<>();
        depositos = new ArrayList[CaracteristicasProducto.values().length];
        for (CaracteristicasProducto Producto : CaracteristicasProducto.values()) {
            depositos[Producto.ordinal()] = new ArrayList<>();
            for ( int i=0 ; i<NumProductos ; i++ ) {
                depositos[Producto.ordinal()].add(Producto.createProducto(i));
            }
        }
    }

    /**
     * Realiza la compra de un producto utilizando una moneda dada y especificaciones del producto.
     * @param m                           La moneda utilizada para la compra.
     * @param cualProducto                Enumeración del producto que se desea comprar.
     * @throws PagoIncorrectoException    Si la moneda pasada como parámetro es nula.
     * @throws NoHayProductoException     Si las características del producto son nulas o el producto deseado no está disponible.
     * @throws PagoInsuficienteException  Si la moneda pasada como parámetro no tiene un valor suficiente para comprar el producto.
     */
    public void comprarProducto(Moneda m, CaracteristicasProducto cualProducto) throws PagoIncorrectoException,NoHayProductoException,PagoInsuficienteException{
        if (m==null) {
            throw new PagoIncorrectoException("Pago Insuficiente.");
        }

        if ( cualProducto == null ) {
            DepositoVuelto.addObject(m);
            throw new NoHayProductoException("No tenemos este producto.");
        }

        int j = cualProducto.ordinal();
        if (m.getValor()<cualProducto.getPrecio()) {
            DepositoVuelto.addObject(m);
            throw new PagoInsuficienteException("Pago Insuficiente.");
        }

        if (depositos[cualProducto.ordinal()].isEmpty()) {
            DepositoVuelto.addObject(m);
            throw new NoHayProductoException("Lo sentimos, no hay stock de este producto en este momento.");
        }

        DepositoMonedasUnico.addObject(m);
        for (int i = 0; i < m.compareTo(cualProducto.getPrecio()); i += 100) {
            DepositoVuelto.addObject(new Moneda100(10+i));
        }
        m = null;

        DepositoEspecial = (depositos[j].remove(depositos[j].size()-1));
    }

    /** Método get que sirve para retirar el dinero dentro del monedero. */
    public Moneda getVuelto(){
        return DepositoVuelto.getObject();
    }

    /** Método get que sirve para retirar el producto del deposito especial. */
    public Producto getProducto() {
        if (DepositoEspecial!=null ) {
            return DepositoEspecial;
        } else {
            return null;
        }
    }
    /** Método para obtener los depósitos de productos */
    public ArrayList<Producto>[] getDepositos() {
        return depositos;
    }

    /** Método para obtener la cantidad de productos en un depósito específico */
    public int getCantidadProductos(int index) {
        if (index >= 0 && index < depositos.length) {
            return depositos[index].size();
        }
        return 0;
    }

    /** Método para obtener un producto específico sin removerlo */
    public Producto getProducto(int index, int position) {
        if (index >= 0 && index < depositos.length) {
            if (position >= 0 && position < depositos[index].size()) {
                return depositos[index].get(position);
            }
        }
        return null;
    }
}
