package org.example;

class Comprador {
    private String sonido;
    private int vuelto;


    public Comprador(Moneda m, int CualProducto, Expendedor exp) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        vuelto = 0;
        sonido = null;
        Producto producto = exp.comprarProducto(m, CualProducto);
        sonido = producto.consumirlo();
        Moneda m2 = exp.getVuelto();
        while(m2 != null){
            vuelto = vuelto + m2.getValor();
            m2 = exp.getVuelto();
        }
    }

    public int cuantoVuelto(){
        return vuelto;
    }

    public String queConsumiste(){
        return sonido;
    }
}
