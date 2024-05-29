package Vistas;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelComprador extends JPanel {
    public PanelComprador() {
        this.setBackground(Color.green);
        this.setBounds(350, 0, 450, 560);
        this.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Lógica para manejar el click
            int x = e.getX();
            int y = e.getY();
            // Determina en qué área se hizo click y actúa en consecuencia
            repaint(); // Actualiza la vista
        }
    });
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // Dibujo del comprador y sus componentes
    g.setColor(Color.yellow);
    g.drawRect(10, 10, 410, 540); // Ejemplo
    // Llamar a los métodos paintComponent de las monedas y otras vistas
}
}