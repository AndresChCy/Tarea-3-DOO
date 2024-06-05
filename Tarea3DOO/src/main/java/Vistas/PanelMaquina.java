package Vistas;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

/**
 * La clase PanelMaquina representa un panel que muestra la imagen de fondo de la parte izquierda de la máquina expendedora.
 */
public class PanelMaquina extends JPanel {
    private Image imagenFondo;

    /**
     * Constructor de la clase PanelMaquina.
     * Inicializa el panel y carga la imagen de fondo de la máquina.
     */
    public PanelMaquina() {
        try {
            // Cargar la imagen de fondo de la máquina
            imagenFondo = ImageIO.read(getClass().getResource("/Máquina_Fondo.png"));
        } catch (IOException ex) {
            // Manejar cualquier error de carga de imagen
            System.out.println("Error al cargar la imagen de fondo de la máquina: " + ex.getMessage());
        }
    }

    /**
     * Método sobrescrito para dibujar la imagen de fondo de la máquina en el panel.
     * @param g El contexto gráfico en el que se dibuja la imagen.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Verificar si la imagen de fondo existe y dibujarla
        if (imagenFondo != null) {
            int ancho = getWidth();
            int alto = getHeight();
            g.drawImage(imagenFondo.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH), 0, 0, this);
        }
    }
}