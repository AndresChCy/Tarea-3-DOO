package Vistas;

import javax.swing.*;
import java.awt.*;
import java.lang.management.MemoryNotificationInfo;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;

public class PanelUsuario extends JPanel {
    ImageIcon icon = new ImageIcon(getClass().getResource("/Moneda100.png"));
    public PanelUsuario(){
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
        AuxMon.add(new JLabel(icon));
        AuxMon.add(new JLabel("moneda500"));
        AuxMon.add(new JLabel("moneda1000"));
        AuxMon.add(new JLabel("moneda1500"));
        Monedas.add(AuxMon,BorderLayout.CENTER);
        this.add(Monedas,BorderLayout.CENTER);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

    }

}
