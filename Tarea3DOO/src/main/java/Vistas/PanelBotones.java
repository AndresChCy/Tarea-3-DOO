package Vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * La clase PanelBotones representa un panel que contiene botones con imágenes de productos.
 * Los botones se redimensionan automáticamente cuando se cambia el tamaño del panel.
 */
public class PanelBotones extends JPanel {
    private Map<String, BufferedImage> imagenesBotones;
    private String[] botones = {"Fanta", "Sprite", "CocaCola", "Snickers", "Super8", "Cancelar"};
    private JButton[] botonesArray;

    /**
     * Constructor de la clase PanelBotones.
     * Inicializa el panel, carga las imágenes de los productos y configura el diseño del panel.
     */
    public PanelBotones() {
        // Inicializa el mapa de imágenes
        imagenesBotones = new HashMap<>();
        botonesArray = new JButton[6];

        try {
            // Cargar las imágenes de los productos y almacenarlas en el mapa
            imagenesBotones.put("Fanta", ImageIO.read(getClass().getResource("/Logo_Fanta.png")));
            imagenesBotones.put("Sprite", ImageIO.read(getClass().getResource("/Logo_Sprite.png")));
            imagenesBotones.put("CocaCola", ImageIO.read(getClass().getResource("/Logo_CocaCola.png")));
            imagenesBotones.put("Snickers", ImageIO.read(getClass().getResource("/Logo_Snickers.png")));
            imagenesBotones.put("Super8", ImageIO.read(getClass().getResource("/Logo_Super8.png")));
            imagenesBotones.put("Cancelar", ImageIO.read(getClass().getResource("/Cancelar.png")));
        } catch (IOException ex) {
            // Manejar cualquier error de carga de imágenes
            System.out.println("Error al cargar imágenes: " + ex.getMessage());
        }

        // Configura el layout del panel
        setLayout(new GridLayout(3, 2));
        // Agrega los botones al panel
        agregarBotones();

        // Añadir un ComponentListener para redimensionar los iconos de los botones al cambiar el tamaño del panel
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                redimensionarIconos();
            }
        });
    }

    /**
     * Método que agrega los botones al panel y establece las imágenes.
     */
    public void agregarBotones() {
        // Crea los botones y establece las imágenes
        for (int i = 0; i < 6; i++) {
            String nombreBoton = botones[i];
            BufferedImage productoImg = imagenesBotones.get(nombreBoton);
            if (productoImg != null) {
                JButton boton = new JButton();
                botonesArray[i] = boton;
                add(boton);
            }
        }
    }

    /**
     * Método que redimensiona los iconos de los botones según el tamaño del panel.
     */
    private void redimensionarIconos() {
        for (int i = 0; i < 6; i++) {
            String nombreBoton = botones[i];
            BufferedImage productoImg = imagenesBotones.get(nombreBoton);
            if (productoImg != null) {
                JButton boton = botonesArray[i];
                int anchoBoton = boton.getWidth();
                int altoBoton = boton.getHeight();
                if (anchoBoton > 0 && altoBoton > 0) {
                    Image img = productoImg.getScaledInstance(anchoBoton, altoBoton, Image.SCALE_SMOOTH);
                    ImageIcon icono = new ImageIcon(img);
                    boton.setIcon(icono);
                }
            }
        }
    }
}