package Vistas;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * La clase PanelMaquina2 representa un panel que muestra la imagen de fondo de la parte derecha de la máquina expendedora.
 */
public class PanelMaquina2 extends JPanel {
    private BufferedImage imagenFondoMaquina2;

    /**
     * Constructor de la clase PanelMaquina2.
     * Inicializa el panel y carga la imagen de fondo de la segunda máquina.
     */
    public PanelMaquina2() {
        try {
            // Cargar la imagen de fondo de la segunda máquina
            imagenFondoMaquina2 = ImageIO.read(getClass().getResource("/Máquina_Fondo_2.png"));
        } catch (IOException ex) {
            // Manejar cualquier error de carga de imagen
            System.out.println("Error al cargar imagen de fondo de la segunda máquina: " + ex.getMessage());
        }
    }

    /**
     * Método sobrescrito para dibujar la imagen de fondo de la segunda máquina en el panel.
     * @param g El contexto gráfico en el que se dibuja la imagen.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Verificar si la imagen de fondo de la segunda máquina existe y dibujarla
        if (imagenFondoMaquina2 != null) {
            int anchoPanel = getWidth();
            int altoPanel = getHeight();
            g.drawImage(imagenFondoMaquina2.getScaledInstance(anchoPanel, altoPanel, Image.SCALE_SMOOTH), 0, 0, this);
        }
    }
}