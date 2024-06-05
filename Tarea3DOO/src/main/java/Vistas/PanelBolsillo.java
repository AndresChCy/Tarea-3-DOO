package Vistas;

import Modelo.Comprador;
import Modelo.Moneda;
import Modelo.Moneda100;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

public class PanelBolsillo extends JPanel {
    Comprador comprador;
    private PanelSlot[] slots;
    public PanelBolsillo(Comprador comprador,PanelComprador panel){
        this.setLayout(new GridLayout(5,2));
        slots = new PanelSlot[10];
        this.comprador = comprador;
        for (int i = 0 ; i<10;i++){
            slots[i] = new PanelSlot(comprador,i,panel);
            this.add(slots[i]);
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Moneda m = null;
        for (int i = 0 ; i<10;i++){
            if(i < comprador.getBolsillo().size() )  m = comprador.getBolsillo().get(i);
            slots[i].setContiene(m);
            m = null;
        }

    }
}
