package Vistas;

import Modelo.*;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * Una clase de metodos estaticos para factorizar el proceso de crear el entorno grafico
 */
public class SintetizadorVisual {
    /**
     * Metodo estatico que asimila tus objetos a una imagen de tus recursos
     * @param o el objeto al cual queremos obtener su imagen
     * @return ImageIcon de la imagen del objeto
     */
    public static ImageIcon ObtenerIcono(Object o) {
        String aux =null ;
        if (o instanceof Moneda100) {
            aux = "/Moneda100.png";
        } else if (o instanceof Moneda500) {
            aux = "/Moneda500.png";
        } else if (o instanceof Moneda1000) {
            aux = "/Moneda1000.png";
        } else if (o instanceof Moneda1500) {
            aux = "/Moneda1500.png";
        } else if (o instanceof Snicker) {
            aux = "/Snickers.png";
        } else if (o instanceof Sprite) {
            aux = "/Sprite.png";
        } else if (o instanceof Super8) {
            aux = "/Super8.png";
        } else if (o instanceof CocaCola) {
            aux = "/CocaCola.png";
        } else if (o instanceof Fanta) {
            aux = "/Fanta.png";
        }
        try {
            ImageIcon imagen= new ImageIcon(SintetizadorVisual.class.getResource(aux));
            return imagen;
        }catch (NullPointerException e){return null; }

    }

    /**
     * Metodo para obtener la eleccion de un producto en base a un orden (util para fors)
     * @param i parametro que se asimila a la eleccion de un producto
     * @return La eleccion del producto
     */
    public static CaracteristicasProducto ObtenerEleccion(int i){
        switch(i){
            case 0:
                return CaracteristicasProducto.FANTA;
            case 1:
                return CaracteristicasProducto.SPRITE;

            case 2:
                return CaracteristicasProducto.COCACOLA;

            case 3:
                return CaracteristicasProducto.SNICKERS;

            case 4:
                return CaracteristicasProducto.SUPER8;

        }
        return null;
    }

    /**
     * metodo para verificar que queden productos y generar un aviso
     * @param producto producto a verificar
     * @param expendedor expendedor sobre el que se trabaja
     * @return un String con la informacion que se requiere
     */
    public static String verificarProducto(CaracteristicasProducto producto, Expendedor expendedor) {
        if (expendedor.getCantidadProductos(producto.ordinal()) > 0) {
            return "Precio:\n$" + producto.getPrecio();
        } else {
            return "No queda " + producto.name();
        }
    }


}
