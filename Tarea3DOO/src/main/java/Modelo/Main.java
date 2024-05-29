package Modelo;

public class Main {
    public static void main(String[] args) {
        Moneda m = new Moneda500(1);
        Deposito deposito = new Deposito();
        Expendedor exp = new Expendedor(2);
        Comprador juan;

        // Prueba de compra con dinero justo, luego con dinero de sobra, y luego cuando no queda más producto
        try {
            juan = new Comprador(m, CaracteristicasProducto.COCACOLA, exp);
            System.out.println(juan.queConsumiste() + " " + juan.cuantoVuelto());
            m = new Moneda1000(2);
            juan = new Comprador(m, CaracteristicasProducto.SUPER8, exp);
            System.out.println(juan.queConsumiste() + " " + juan.cuantoVuelto());
            m = new Moneda1000(3);
            juan = new Comprador(m, CaracteristicasProducto.FANTA, exp);
            System.out.println(juan.queConsumiste() + " " + juan.cuantoVuelto());
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.out.println(e.getMessage());
        }

        // Intento de comprar sin monedas
        try {
            m = null;
            juan = new Comprador(m, CaracteristicasProducto.SUPER8, exp);
            System.out.println(juan.queConsumiste() + " " + juan.cuantoVuelto());
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.out.println(e.getMessage());
        }

        // Intento de comprar con una moneda de menor valor
        try {
            m = new Moneda100(5);
            juan = new Comprador(m, CaracteristicasProducto.SPRITE, exp);
            System.out.println(juan.queConsumiste() + " " + juan.cuantoVuelto());
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.out.println(e.getMessage());
        }
    }
}