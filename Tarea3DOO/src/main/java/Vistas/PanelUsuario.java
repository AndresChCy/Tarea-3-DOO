package Vistas;

import javax.swing.*;
import java.awt.*;
import java.lang.management.MemoryNotificationInfo;

public class PanelUsuario extends JPanel {
    public PanelUsuario(){
        setBackground(Color.blue);
        this.setLayout(new BorderLayout());
        this.add(new JButton("Consumir"),BorderLayout.WEST);
        JPanel Monedas = new JPanel();
        Monedas.setBackground(Color.blue);
        Monedas.setLayout(new BorderLayout(20,20));
        Monedas.add(new JLabel("Dar moneda"),BorderLayout.NORTH);
        JPanel AuxMon = new JPanel();
        AuxMon.setLayout(new GridLayout(2,2));
        AuxMon.add(new JLabel("moneda100"));
        AuxMon.add(new JLabel("moneda500"));
        AuxMon.add(new JLabel("moneda1000"));
        AuxMon.add(new JLabel("moneda1500"));
        Monedas.add(AuxMon,BorderLayout.CENTER);
        this.add(Monedas,BorderLayout.CENTER);

    }

}
