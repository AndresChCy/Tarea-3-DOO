package Vistas;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Modelo.Comprador ;

public class PanelComprador extends JPanel {
    private Comprador comprador;

    public PanelComprador() {
      //  this.comprador = new Comprador();
        this.setBackground(Color.green);
        this.setBounds(350, 0, 350, 560);
        this.setLayout(new BorderLayout());
        JPanel Usuario = new PanelUsuario();
        Usuario.setPreferredSize(new Dimension(0,150));
        this.add(Usuario,BorderLayout.SOUTH);
        


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