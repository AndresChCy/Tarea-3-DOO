package Modelo;
import java.util.ArrayList;

/**
 * Un expendedor al que le puedes comprar productos usando monedas.
 */
class Expendedor {
    /** Creamos una lista de depositos, un deposito para monedas, un deposito unico y un deposito especial*/
    private ArrayList<Producto>[] depositos;
    private ArrayList<Moneda> DepositoPago;
    private Deposito<Moneda> DepositoVuelto;
    private Deposito<Moneda> DepositoMonedasUnico;
    private Producto DepositoEspecial;

    /** Metodo constructor que rellena sus depositos para productos de forma magica */
    public Expendedor(int NumProductos) {
        DepositoMonedasUnico = new Deposito<>();
        DepositoVuelto = new Deposito<>();
        DepositoPago = new ArrayList<>();
        depositos = new ArrayList[CaracteristicasProducto.values().length];
        for (CaracteristicasProducto Producto : CaracteristicasProducto.values()) {
            depositos[Producto.ordinal()] = new ArrayList<>();
            for ( int i=0 ; i<NumProductos ; i++ ) {
                depositos[Producto.ordinal()].add(Producto.createProducto(i));
            }
        }
    }

    /**
     * Método para pagar al expendedor.
     * @param m     Moneda que se añade al deposito.
     */
    public void Pagar(Moneda m) {
        DepositoPago.add(m);
    }

    /**
     * Realiza la compra de un producto utilizando una moneda dada y especificaciones del producto.
     * @param cualProducto                Enumeración del producto que se desea comprar.
     * @throws PagoIncorrectoException    Si la moneda pasada como parámetro es nula.
     * @throws NoHayProductoException     Si las características del producto son nulas o el producto deseado no está disponible.
     * @throws PagoInsuficienteException  Si la moneda pasada como parámetro no tiene un valor suficiente para comprar el producto.
     */
    public void comprarProducto(CaracteristicasProducto cualProducto) throws PagoIncorrectoException,NoHayProductoException,PagoInsuficienteException{
        if (DepositoPago.isEmpty()) {
            throw new PagoIncorrectoException("No se ha ingresado dinero al deposito.");
        }

        if ( cualProducto == null ) {
            for (int i=0 ; i<DepositoPago.size() ; i++ ) {
                Moneda m = DepositoPago.get(i);
                DepositoVuelto.addObject(m);
            }
            for (int i=0 ; i<DepositoPago.size() ; i++ ) {
                DepositoPago.remove(i);
            }
            throw new NoHayProductoException("No tenemos este producto.");
        }

        int ValorTotal = 0;
        for (int i=0 ; i<DepositoPago.size() ; i++ ) {
            ValorTotal += DepositoPago.get(i).getValor();
        }

        if (ValorTotal<cualProducto.getPrecio()) {
            for (int i=0 ; i<DepositoPago.size() ; i++ ) {
                Moneda m = DepositoPago.get(i);
                DepositoVuelto.addObject(m);
            }
            for (int i=0 ; i<DepositoPago.size() ; i++ ) {
                DepositoPago.remove(i);
            }
            throw new PagoInsuficienteException("Pago Insuficiente.");
        }

        if (depositos[cualProducto.ordinal()].isEmpty()) {
            for (int i=0 ; i<DepositoPago.size() ; i++ ) {
                Moneda m = DepositoPago.get(i);
                DepositoVuelto.addObject(m);
            }
            for (int i=0 ; i<DepositoPago.size() ; i++ ) {
                DepositoPago.remove(i);
            }
            throw new NoHayProductoException("Lo sentimos, no hay stock de este producto en este momento.");
        }

        for (int i=0 ; i<DepositoPago.size() ; i++ ) {
            Moneda n = DepositoPago.get(i);
            DepositoMonedasUnico.addObject(n);
        }

        for (int i=0; i<ValorTotal-(cualProducto.getPrecio()); i+=100) {
            DepositoVuelto.addObject(new Moneda100(10+i));
        }

        int j = cualProducto.ordinal();
        DepositoEspecial = (depositos[j].remove(depositos[j].size()-1));

        for (int i=0 ; i<DepositoPago.size() ; i++ ) {
            DepositoPago.remove(i);
        }
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
}
