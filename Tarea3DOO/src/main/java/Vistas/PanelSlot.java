package Vistas;


import Modelo.Moneda;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelSlot extends JPanel {
    private BufferedImage ImagenFondo;
    private Moneda contiene;
    private JLabel moneda;
    public PanelSlot(){
        super();
        try {
            this.ImagenFondo = ImageIO.read(getClass().getResource("/SlotBolsillo.png"));
        } catch (IOException ex) {
            // Manejar cualquier error de carga de imágenes
            System.out.println("Error al cargar imágenes: " + ex.getMessage());
        }
        moneda = new JLabel();
        contiene = null;
        this.add(moneda);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(ImagenFondo,0,0,this);
        this.HacerMoneda();

    }
    public void HacerMoneda(){
        try{
           // ImageIcon i = new ImageIcon(getClass().getResource(DibujadorDeObjetos.ObtenerImagen(contiene)));
            ImageIcon i = SintetizadorVisual.ObtenerImagen(contiene);
            moneda.setIcon(i);
        } catch(NullPointerException e){}
    }
    public void setContiene(Moneda m){
        this.contiene = m;
    }

}
