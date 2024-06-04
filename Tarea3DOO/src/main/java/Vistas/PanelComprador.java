package Vistas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Modelo.Comprador ;
import java.awt.Graphics;

public class PanelComprador extends JPanel {
    private Comprador comprador;
    JPanel Usuario;
    JLabel Comprador;
    JPanel Bolsillo;

    public PanelComprador() {
      //  this.comprador = new Comprador();
        this.setBackground(Color.green);
        this.setBounds(350, 0, 350, 560);
        this.setLayout(new BorderLayout());
        Usuario = new PanelUsuario();
        Comprador = new JLabel(new ImageIcon(getClass().getResource("/Comprador.png")));
        Bolsillo = new PanelBolsillo();
        Usuario.setPreferredSize(new Dimension(0,150));

        this.add(Comprador, BorderLayout.CENTER);
        this.add(Usuario,BorderLayout.SOUTH);
        this.add(Bolsillo,BorderLayout.EAST );
        


}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);


    }
}