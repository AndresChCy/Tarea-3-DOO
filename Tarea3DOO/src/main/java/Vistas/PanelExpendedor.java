package Vistas;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;


public class PanelExpendedor extends JPanel {
    public PanelExpendedor() {
        this.setBackground(Color.gray);
        this.setBounds(0, 0, 450, 560); // Posición y tamaño del panel
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujo del expendedor y sus componentes
        g.setColor(Color.blue);
        g.drawRect(10, 10, 320, 540); // Ejemplo
        // Llamar a los métodos paintComponent de los productos y monedas
    }
}