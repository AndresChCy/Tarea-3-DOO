package Vistas;

import Modelo.Moneda;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class PanelMonedas extends JPanel {
    private String[] nombresMonedas = {"Moneda100", "Moneda500", "Moneda1000", "Moneda1500"};
    private Map<String, BufferedImage> imagenesMonedas;
    private JButton[] botonesMonedas;
    public static int numSerie = 1; // Número de serie inicial para las monedas

    /**
     * Constructor de la clase PanelMonedas.
     * Configura el panel y carga las imágenes de las monedas.
     */
    public PanelMonedas() {
        setBackground(Color.BLUE);
        setLayout(new GridBagLayout());

        imagenesMonedas = new HashMap<>();
        botonesMonedas = new JButton[nombresMonedas.length];

        try {
            // Cargar las imágenes de las monedas
            for (String nombreMoneda : nombresMonedas) {
                imagenesMonedas.put(nombreMoneda, ImageIO.read(getClass().getResource("/" + nombreMoneda + ".png")));
            }
        } catch (IOException ex) {
            System.err.println("Error al cargar imágenes: " + ex.getMessage());
        }

        // Agregar botones para cada tipo de moneda al panel
        agregarBotonesMonedas();

        // Agregar un listener para redimensionar los iconos al cambiar el tamaño del panel
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                redimensionarIconos();
            }
        });
    }

    /**
     * Método para agregar botones para cada tipo de moneda al panel.
     */
    private void agregarBotonesMonedas() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;

        for (int i = 0; i < nombresMonedas.length; i++) {
            String nombreMoneda = nombresMonedas[i];
            JButton botonMoneda = new JButton();
            botonesMonedas[i] = botonMoneda;

            // Configurar las coordenadas del botón en la cuadrícula del panel
            constraints.gridx = i % 2;
            constraints.gridy = i / 2;
            add(botonMoneda, constraints);

            // Actualizar el icono del botón con la imagen correspondiente
            actualizarIcono(botonMoneda, imagenesMonedas.get(nombreMoneda));

            // Agregar un ActionListener para manejar el clic en el botón
            botonMoneda.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        // Obtener la clase correspondiente al nombre de la moneda
                        Class<?> claseMoneda = Class.forName("Modelo." + nombreMoneda);

                        // Obtener el constructor que acepta un número de serie
                        Constructor<?> constructor = claseMoneda.getConstructor(int.class);

                        // Crear una nueva instancia de la clase MonedaX con un número de serie incremental
                        Moneda m = (Moneda) constructor.newInstance(numSerie);
                        numSerie++; // Incrementar el número de serie para la próxima moneda

                        // Realizar acciones con la moneda creada

                    } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
                        ex.printStackTrace(); // Manejo de errores
                    }
                }
            });
        }
    }

    /**
     * Método para redimensionar los iconos de los botones al cambiar el tamaño del panel.
     */
    private void redimensionarIconos() {
        for (int i = 0; i < nombresMonedas.length; i++) {
            String nombreMoneda = nombresMonedas[i];
            JButton botonMoneda = botonesMonedas[i];
            // Actualizar el icono del botón con la imagen redimensionada
            actualizarIcono(botonMoneda, imagenesMonedas.get(nombreMoneda));
        }
    }

    /**
     * Método para actualizar el icono de un botón con una imagen.
     *
     * @param boton  el botón al que se actualizará el icono.
     * @param imagen la imagen que se utilizará como icono.
     */
    private void actualizarIcono(JButton boton, BufferedImage imagen) {
        if (imagen != null) {
            int anchoBoton = boton.getWidth();
            int altoBoton = boton.getHeight();
            if (anchoBoton > 0 && altoBoton > 0) {
                // Escalar la imagen para que se ajuste al tamaño del botón
                Image img = imagen.getScaledInstance(anchoBoton, altoBoton, Image.SCALE_SMOOTH);
                boton.setIcon(new ImageIcon(img));
            }
        }
    }
}