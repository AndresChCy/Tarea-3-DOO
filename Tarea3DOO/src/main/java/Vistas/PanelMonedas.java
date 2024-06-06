package Vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PanelMonedas extends JPanel {
    private String[] monedas = {"Moneda100", "Moneda500", "Moneda1000", "Moneda1500"};
    private Map<String, BufferedImage> imagenesMonedas;
    private JButton[] darMonedasArray;

    /**
     * Constructor de la clase PanelMonedas.
     * Inicializa el panel, carga las imágenes de las monedas y configura el diseño del panel.
     */
    public PanelMonedas() {
        // Configuración del panel
        setBackground(Color.BLUE);
        setLayout(new GridBagLayout());

        imagenesMonedas = new HashMap<>();
        darMonedasArray = new JButton[monedas.length];

        // Cargar imágenes de monedas
        try {
            for (String moneda : monedas) {
                imagenesMonedas.put(moneda, ImageIO.read(getClass().getResource("/" + moneda + ".png")));
            }
        } catch (IOException ex) {
            System.err.println("Error al cargar imágenes: " + ex.getMessage());
        }

        // Agregar botones de monedas
        agregarBotonesMonedas();

        // Configurar la disposición de los paneles
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                redimensionarIconos();
            }
        });
    }

    /**
     * Método para agregar botones de monedas al panel de monedas.
     */
    private void agregarBotonesMonedas() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;

        for (int i = 0; i < monedas.length; i++) {
            String nombreMoneda = monedas[i];
            JButton darMoneda = new JButton();
            darMonedasArray[i] = darMoneda;

            constraints.gridx = i % 2;
            constraints.gridy = i / 2;
            add(darMoneda, constraints);

            // Añadir icono inicial
            actualizarIcono(darMoneda, imagenesMonedas.get(nombreMoneda));

            darMoneda.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lógica de cada botón
                    System.out.println("Se presionó el botón de " + nombreMoneda);
                }
            });
        }
    }

    /**
     * Método que redimensiona los iconos de los botones según el tamaño del panel.
     */
    private void redimensionarIconos() {
        for (int i = 0; i < monedas.length; i++) {
            String nombreMoneda = monedas[i];
            JButton boton = darMonedasArray[i];
            actualizarIcono(boton, imagenesMonedas.get(nombreMoneda));
        }
    }

    /**
     * Método para actualizar el icono de un botón con una imagen redimensionada.
     * @param boton El botón cuyo icono se actualizará.
     * @param imagen La imagen que se establecerá como icono en el botón.
     */
    private void actualizarIcono(JButton boton, BufferedImage imagen) {
        if (imagen != null) {
            int anchoBoton = boton.getWidth();
            int altoBoton = boton.getHeight();
            if (anchoBoton > 0 && altoBoton > 0) {
                Image img = imagen.getScaledInstance(anchoBoton, altoBoton, Image.SCALE_SMOOTH);
                boton.setIcon(new ImageIcon(img));
            }
        }
    }
}
