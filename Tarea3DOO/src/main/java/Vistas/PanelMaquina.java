package Vistas;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

public class PanelMaquina extends JPanel {
    private Image imagenFondo;

    public PanelMaquina() {
        try {
            imagenFondo = ImageIO.read(getClass().getResource("/Máquina_Fondo.png"));
        } catch (IOException ex) {
            System.out.println("Error al cargar la imagen de fondo de la máquina: " + ex.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            int ancho = getWidth();
            int alto = getHeight();
            g.drawImage(imagenFondo.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH), 0, 0, this);
        }
    }
}
