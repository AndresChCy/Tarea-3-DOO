package Vistas;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * La clase PanelZonaExtraccion representa un panel que muestra la zona de extracción de productos de la máquina expendedora.
 * Cambia la imagen de la máquina entre abierta y cerrada según el movimiento y salida del ratón.
 */
public class PanelZonaExtraccion extends JPanel {
    private BufferedImage imagenMaquinaCerrada;
    private BufferedImage imagenMaquinaAbierta;
    private BufferedImage imagenMaquinaActual;

    /**
     * Constructor de la clase PanelZonaExtraccion.
     * Inicializa el panel y carga las imágenes de la máquina abierta y cerrada.
     * Agrega listeners para manejar los eventos de movimiento y salida del ratón.
     */
    public PanelZonaExtraccion() {
        try {
            // Cargar las imágenes de la máquina abierta y cerrada
            imagenMaquinaCerrada = ImageIO.read(getClass().getResource("/Máquina_Cerrada.png"));
            imagenMaquinaAbierta = ImageIO.read(getClass().getResource("/Máquina_Abierta.png"));
            // Establecer la imagen actual como la máquina cerrada por defecto
            imagenMaquinaActual = imagenMaquinaCerrada;
        } catch (IOException ex) {
            // Manejar cualquier error de carga de imagen
            System.out.println("Error al cargar imagen de zona de extracción: " + ex.getMessage());
        }

        // Agregar un listener para manejar el movimiento del ratón
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                // Cambiar la imagen de la máquina a abierta cuando el ratón se mueve sobre el panel
                imagenMaquinaActual = imagenMaquinaAbierta;
                repaint(); // Volver a pintar el panel
            }
        });

        // Agregar un listener para manejar la salida del ratón del panel
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                // Cambiar la imagen de la máquina a cerrada cuando el ratón sale del panel
                imagenMaquinaActual = imagenMaquinaCerrada;
                repaint(); // Volver a pintar el panel
            }
        });
    }

    /**
     * Método sobrescrito para dibujar la imagen de la máquina actual en el panel.
     * @param g El contexto gráfico en el que se dibuja la imagen.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Obtener las dimensiones del panel
        int anchoPanel = getWidth();
        int altoPanel = getHeight();
        // Dibujar la imagen de la máquina actual en el panel
        g.drawImage(imagenMaquinaActual.getScaledInstance(anchoPanel, altoPanel, Image.SCALE_SMOOTH), 0, 0, this);
    }
}