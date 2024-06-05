package Vistas;
import javax.swing.*;
import java.awt.*;

import Modelo.Comprador ;
import Modelo.Moneda1500;

import java.awt.Graphics;

public class PanelComprador extends JPanel {
    private Comprador comprador;
    JPanel Usuario;
    JLabel Comprador;
    PanelBolsillo Bolsillo;
    JLabel Mano;

    public PanelComprador(Comprador comprador) {
        this.comprador = comprador;
        this.setBackground(Color.green);
        this.setBounds(350, 0, 350, 560);
        this.setLayout(new BorderLayout());
        Comprador = new JLabel(new ImageIcon(getClass().getResource("/Comprador.png")));
        Bolsillo = new PanelBolsillo(comprador,this);
        Usuario = new PanelUsuario(comprador, Bolsillo);
        Usuario.setPreferredSize(new Dimension(0,150));
        Mano = new JLabel();

        this.add(Comprador, BorderLayout.CENTER);
        this.add(Usuario,BorderLayout.SOUTH);
        this.add(Bolsillo,BorderLayout.EAST );
        this.add(Mano,BorderLayout.WEST);
        


}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try{
            ImageIcon i = SintetizadorVisual.ObtenerImagen(comprador.getMano()[0]);
            Mano.setIcon(i);
        }catch (Exception e){}

    }
}