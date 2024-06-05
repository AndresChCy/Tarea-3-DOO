package Vistas;


import Modelo.Comprador;
import Modelo.Moneda;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelSlot extends JPanel {
    private BufferedImage ImagenFondo;
    private Moneda contiene;
    private JLabel moneda;
    private Comprador comprador;
    private int numSlot;
    public PanelSlot(Comprador comprador,int i,PanelComprador panel){
        numSlot = i;
        this.comprador = comprador;
        try {
            this.ImagenFondo = ImageIO.read(getClass().getResource("/SlotBolsillo.png"));
        } catch (IOException ex) {
            // Manejar cualquier error de carga de imágenes
            System.out.println("Error al cargar imágenes: " + ex.getMessage());
        }
        moneda = new JLabel();
        moneda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Comprador comprador1 = comprador;
                try{
                    comprador1.getMonedaBolsillo(i);
                    panel.repaint();
                    repaint();
                }catch (Exception ex){}
            }
        });
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
            repaint();
        } catch(NullPointerException e){
            moneda.setIcon(null);
        }
    }
    public void setContiene(Moneda m){
        this.contiene = m;

    }

}
