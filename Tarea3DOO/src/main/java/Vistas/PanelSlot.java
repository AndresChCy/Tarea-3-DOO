package Vistas;

import Modelo.Moneda;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Clase PanelSlot que extiende JPanel.
 * Representa un slot en la interfaz gráfica donde se puede insertar una moneda.
 */
public class PanelSlot extends JPanel {
    private BufferedImage ImagenFondo; // Imagen de fondo del slot
    private Moneda contiene; // Moneda contenida en el slot
    private JLabel moneda; // Etiqueta para mostrar la imagen de la moneda

    /**
     * Constructor de la clase PanelSlot.
     * Inicializa el panel y carga la imagen de fondo del slot.
     * Crea la etiqueta para mostrar la moneda y la agrega al panel.
     */
    public PanelSlot(){
        super();
        try {
            // Cargar la imagen de fondo del slot
            this.ImagenFondo = ImageIO.read(getClass().getResource("/SlotBolsillo.png"));
        } catch (IOException ex) {
            // Manejar cualquier error de carga de imágenes
            System.out.println("Error al cargar imágenes: " + ex.getMessage());
        }
        // Inicializar la etiqueta para mostrar la moneda
        moneda = new JLabel();
        contiene = null; // Inicialmente el slot no contiene ninguna moneda
        // Agregar la etiqueta al panel
        this.add(moneda);
    }

    /**
     * Override del método paintComponent para dibujar la imagen de fondo del slot.
     *
     * @param g el contexto gráfico en el cual dibujar.
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        // Dibujar la imagen de fondo del slot
        g.drawImage(ImagenFondo, 0, 0, this);
        // Llamar al método para mostrar la moneda (si hay alguna)
        this.HacerMoneda();
    }

    /**
     * Método para establecer la moneda que contiene el slot.
     *
     * @param m la moneda a establecer.
     */
    public void setContiene(Moneda m){
        this.contiene = m;
    }

    /**
     * Método para mostrar la imagen de la moneda en el slot.
     */
    public void HacerMoneda(){
        try{
            // Obtener la imagen de la moneda y establecerla en la etiqueta
            ImageIcon i = SintetizadorVisual.ObtenerImagen(contiene);
            moneda.setIcon(i);
        } catch(NullPointerException e){}
    }
}
