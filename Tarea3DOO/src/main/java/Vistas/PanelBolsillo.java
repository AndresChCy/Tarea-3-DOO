package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

public class PanelBolsillo extends JPanel {
    public PanelBolsillo(){
        this.setLayout(new GridLayout(5,2));
        JLabel[] slot = new PanelSlot[10];
        for (int i = 0 ; i<10;i++){
            slot[i] = new PanelSlot(new ImageIcon(getClass().getResource("/SlotBolsillo.png")));
            this.add(slot[i]);
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
