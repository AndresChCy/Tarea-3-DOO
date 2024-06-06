package Vistas;

import Modelo.Comprador;

import javax.swing.*;
import java.awt.*;

public class PanelMano extends JPanel {
    private Comprador comprador;
    private JLabel Mano;
    public PanelMano(Comprador comprador) {
        this.comprador = comprador;
        Mano = new JLabel();
        this.add(Mano);
        this.setBackground(Color.BLACK); //Solo para probar
        this.setOpaque(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            ImageIcon i = SintetizadorVisual.ObtenerImagen(comprador.getMano()[0]);
            Mano.setIcon(i);
        } catch (Exception e) {
            Mano.setIcon(null);
        }
    }
}