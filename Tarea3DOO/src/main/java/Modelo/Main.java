package Modelo;

public class Main {
    public static void main(String[] args) {
        Moneda m = new Moneda500();
        Expendedor exp = new Expendedor(2);
        Comprador juan;
        System.out.println(m.getSerie().toString() +" "+ m.getValor());

        // Prueba de compra con dinero justo, luego con dinero de sobra, y luego cuando no queda más producto
        try {
            juan = new Comprador(m, 1, exp);
            System.out.println(juan.queConsumiste() + " " + juan.cuantoVuelto());
            m = new Moneda1000();
            juan = new Comprador(m, 1, exp);
            System.out.println(juan.queConsumiste() + " " + juan.cuantoVuelto());
            m = new Moneda500();
            juan = new Comprador(m, 1, exp);
            System.out.println(juan.queConsumiste() + " " + juan.cuantoVuelto());
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.out.println(e.getMessage());
        }

        // Intento de comprar un producto que no existe
        try {
            m = new Moneda500();
            juan = new Comprador(m, 10, exp);
            System.out.println(juan.queConsumiste() + " " + juan.cuantoVuelto());
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.out.println(e.getMessage());
        }

        // Intento de comprar sin monedas
        try {
            m = null;
            juan = new Comprador(m, 2, exp);
            System.out.println(juan.queConsumiste() + " " + juan.cuantoVuelto());
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.out.println(e.getMessage());
        }

        // Intento de comprar con una moneda de menor valor
        try {
            m = new Moneda100();
            juan = new Comprador(m, 3, exp);
            System.out.println(juan.queConsumiste() + " " + juan.cuantoVuelto());
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.out.println(e.getMessage());
        }
    }
}