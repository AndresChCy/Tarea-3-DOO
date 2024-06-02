package Modelo;

public class Main {
    public static void main(String[] args) {
        Moneda m = new Moneda500(1);
        Expendedor exp = new Expendedor(2);
        Deposito deposito = new Deposito();
        Comprador juan;

        // Prueba de compra con dinero justo, luego con dinero de sobra, y luego cuando no queda más producto
        try {
            juan = new Comprador();
            juan.SetMonedaMano(m);
            juan.Comprar(CaracteristicasProducto.FANTA, exp);
            juan.ConsumirDeLaMano();
            System.out.println(juan.queConsumiste() + " " + juan.cuantoVuelto());

            m = new Moneda1000(2);
            juan = new Comprador();
            juan.SetMonedaMano(m);
            juan.Comprar(CaracteristicasProducto.FANTA, exp);
            juan.ConsumirDeLaMano();
            System.out.println(juan.queConsumiste() + " " + juan.cuantoVuelto());

            m = new Moneda1000(3);
            juan = new Comprador();
            juan.SetMonedaMano(m);
            juan.Comprar(CaracteristicasProducto.FANTA, exp);
            juan.ConsumirDeLaMano();
            System.out.println(juan.queConsumiste() + " " + juan.cuantoVuelto());


        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}