package Vistas;

import Modelo.Comprador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class PanelMano extends JPanel {
    private Comprador comprador;
    private JLabel Mano;
    public PanelMano(Comprador comprador) {
        this.comprador = comprador;
        Mano = new JLabel();
        Mano.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                try {
                    repaint();

                }catch (NullPointerException ex){}
            }
        });
        this.setBackground(Color.BLACK); //Solo para probar
        this.setOpaque(false);
        this.add(Mano);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            actualizarIcono(this,SintetizadorVisual.ObtenerIcono(comprador.getMano()[0]).getImage());
        } catch (NullPointerException e) {
            Mano.setIcon(null);
        }
    }
    private void actualizarIcono(PanelMano boton, Image imagen) {
        if (imagen != null) {
            int anchoBoton = boton.getWidth();
            int altoBoton = boton.getHeight();
            if (anchoBoton > 0 && altoBoton > 0) {
                // Escalar la imagen para que se ajuste al tamaño del botón
                Image img = imagen.getScaledInstance(anchoBoton, altoBoton, Image.SCALE_SMOOTH);
                Mano.setIcon(new ImageIcon(img));
            }
        }
    }
}