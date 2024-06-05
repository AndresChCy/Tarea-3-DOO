package Vistas;

import Modelo.*;

import javax.swing.*;

public class SintetizadorVisual {

    public static ImageIcon ObtenerImagen(Object o) {
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
        } else if (o instanceof Sprite) {
        } else if (o instanceof Super8) {
        } else if (o instanceof CocaCola) {
        } else if (o instanceof Fanta) {
        }
        ImageIcon imagen= new ImageIcon(SintetizadorVisual.class.getResource(aux));
        return imagen;
    }
    public static CaracteristicasProducto ObtenerEleccion(int i){
        switch(i){
            case 1:
                return CaracteristicasProducto.FANTA;
            case 2:
                return CaracteristicasProducto.SPRITE;

            case 3:
                return CaracteristicasProducto.COCACOLA;

            case 4:
                return CaracteristicasProducto.SNICKERS;

            case 5:
                return CaracteristicasProducto.SUPER8;

        }
        return null;
    }

}
