package Vistas;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * La clase PanelMaquina2 representa un panel que muestra la imagen de fondo de la segunda parte de la máquina expendedora.
 * Contiene un panel de botones que se ajusta automáticamente al tamaño del panel principal.
 */
public class PanelMaquina2 extends JPanel {
    private BufferedImage imagenFondoMaquina2;
    private PanelBotones panelBotones;

    /**
     * Constructor de la clase PanelMaquina2.
     * Inicializa el panel, carga la imagen de fondo de la segunda máquina y agrega el panel de botones.
     */
    public PanelMaquina2() {
        try {
            // Cargar la imagen de fondo de la segunda máquina
            imagenFondoMaquina2 = ImageIO.read(getClass().getResource("/Máquina_Fondo_2.png"));
        } catch (IOException ex) {
            // Manejar cualquier error de carga de imagen
            System.out.println("Error al cargar imagen de fondo de la segunda máquina: " + ex.getMessage());
        }

        setLayout(null); // Usar un diseño nulo para posicionar manualmente los componentes

        // Crear y agregar el panel de botones
        panelBotones = new PanelBotones();
        this.add(panelBotones);

        // Añadir un ComponentListener para actualizar la posición y el tamaño de panelBotones al cambiar el tamaño del panel
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                ajustarPanelBotones();
            }
        });
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

        // Ajustar el tamaño y la posición de panelBotones
        ajustarPanelBotones();
    }

    /**
     * Ajusta el tamaño y la posición del panel de botones en función del tamaño del panel principal.
     */
    private void ajustarPanelBotones() {
        int anchoPanel = getWidth();
        int altoPanel = getHeight();

        // Calcular los márgenes proporcionales al tamaño del panel
        int margenX = (int) (anchoPanel * 0.15); // Margen de 15% del ancho del panel
        int margenYArriba = (int) (altoPanel * 0.1); // Margen de 10% de la mitad del alto del panel
        int margenYAbajo = (int) (altoPanel * 0.05); // Margen de 5% del alto del panel

        // Calcular las posiciones y dimensiones de PanelBotones
        int anchoBotones = anchoPanel - 2 * margenX;
        int altoBotones = altoPanel - (altoPanel / 2) - margenYArriba - margenYAbajo;
        int xBotones = margenX;
        int yBotones = altoPanel / 2 - margenYArriba;

        // Establecer los límites del panel de botones
        panelBotones.setBounds(xBotones, yBotones, anchoBotones, altoBotones);
        panelBotones.revalidate();
        panelBotones.repaint();
    }
}