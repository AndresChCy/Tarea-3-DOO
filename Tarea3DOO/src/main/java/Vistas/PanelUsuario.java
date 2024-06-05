package Vistas;

import Modelo.Comprador;
import Modelo.CreaMonedas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.management.MemoryNotificationInfo;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;

public class PanelUsuario extends JPanel {
    private Comprador comprador;
    private PanelBolsillo bolsillo;

    public PanelUsuario(Comprador comprador,PanelBolsillo bolsillo){
        this.comprador = comprador;
        this.bolsillo = bolsillo;
        setBackground(Color.blue);
        this.setLayout(new BorderLayout());
        this.add(new JButton("Consumir"),BorderLayout.WEST);
        JPanel Monedas = new JPanel();
        Monedas.setBackground(Color.white);
        Monedas.setLayout(new BorderLayout(20,20));
        Monedas.add(new JLabel("Dar moneda"),BorderLayout.NORTH);
        JPanel AuxMon = new JPanel();
        AuxMon.setLayout(new GridLayout(2,2));
        AuxMon.setBackground(Color.white);
        BotonesMoneda(AuxMon);
        Monedas.add(AuxMon,BorderLayout.CENTER);
        this.add(Monedas,BorderLayout.CENTER);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

    }

    public void BotonesMoneda(JPanel panel){
        for(CreaMonedas m : CreaMonedas.values()){
            JLabel iconoM = new JLabel(SintetizadorVisual.ObtenerImagen(m.crearMoneda(0)));
            iconoM.addMouseListener(new GeneraMoneda(m));
            panel.add(iconoM);
        }
    }
    private class GeneraMoneda implements MouseListener{
        private static int contador = 1;
        private CreaMonedas generador;
        public GeneraMoneda(CreaMonedas m){
            this.generador = m;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            comprador.addMonedaBolsillo(generador.crearMoneda(contador));
            contador++;
            bolsillo.repaint();

        }
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }

}
