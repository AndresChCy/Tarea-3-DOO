package Vistas;

import Modelo.*;

public class LogicaBotones {
    private Expendedor expendedor;
    public LogicaBotones(Expendedor expendedor) {
        this.expendedor = expendedor;
    }
    public String verificarProducto(CaracteristicasProducto producto) {
        if (expendedor.getCantidadProductos(producto.ordinal()) > 0) {
            return "Precio:\n$" + producto.getPrecio();
        } else {
            return "No queda " + producto.name();
        }
    }
}