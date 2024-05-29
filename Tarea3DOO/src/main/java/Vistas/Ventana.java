package Vistas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Ventana extends JFrame {
    public Ventana() {
        this.setTitle("Expendedor y Comprador");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PanelPrincipal panelPrincipal = new PanelPrincipal();
        this.add(panelPrincipal, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Ventana();
    }
}