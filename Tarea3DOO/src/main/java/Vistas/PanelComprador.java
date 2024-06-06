package Vistas;

import javax.swing.*;
import java.awt.*;

import Modelo.Comprador;
import Modelo.Moneda1500;

import java.awt.Graphics;

/**
 * Clase PanelComprador que extiende JPanel.
 * Representa el panel principal que contiene los componentes relacionados con el comprador.
 */
public class PanelComprador extends JPanel {
    private PanelUsuario panelUsuario; // Panel que muestra la interfaz de usuario
    private PanelBolsillo panelBolsillo; // Panel que muestra el bolsillo del comprador
    private PanelPersona panelPersona; // Panel que muestra la persona

    /**
     * Constructor de la clase PanelComprador.
     * Configura el fondo del panel y agrega los componentes relacionados con el comprador.
     *
     * @param comprador el objeto Comprador asociado al panel.
     */
    public PanelComprador(Comprador comprador) {
        // Establecer el fondo del panel como verde
        this.setBackground(Color.green);
        // Usar un diseño nulo para posicionar manualmente los componentes
        this.setLayout(null);

        // Inicializar los paneles relacionados con el comprador
        panelBolsillo = new PanelBolsillo(comprador,this);
        panelUsuario = new PanelUsuario(panelBolsillo,comprador);
        panelPersona = new PanelPersona(comprador);

        // Agregar los paneles al panel principal
        this.add(panelUsuario);
        this.add(panelBolsillo);
        this.add(panelPersona);
    }

    /**
     * Override del método paintComponent para personalizar el aspecto del panel.
     *
     * @param g el contexto gráfico en el cual dibujar.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int anchoPanel = getWidth();
        int altoPanel = getHeight();

        // Calcular posiciones y dimensiones de PanelBolsillo
        int altoPanelBolsillo = (int) (altoPanel * 0.75);
        int anchoPanelBolsillo = (int) (altoPanel * 0.3);
        int posXPanelBolsillo = (anchoPanel - anchoPanelBolsillo);
        int posYPanelBolsillo = 0;

        // Calcular posiciones y dimensiones de la Persona
        int margenPersonaX = (int) (anchoPanel * 0.01);
        int margenPersonaY = (int) (altoPanel * 0.01);
        int anchoPersona = posXPanelBolsillo - (2 * margenPersonaX);
        int altoPersona = (int) ((altoPanel * 0.75) - (2 * margenPersonaY));

        // Calcular posiciones y dimensiones de la interfaz de Usuario
        int anchoUsuario = anchoPanel;
        int altoUsuario = (int) (altoPanel * 0.25);
        int posXUsuario = 0;
        int posYUsuario = (int) (altoPanel * 0.75);

        // Establecer los límites de los componentes
        panelBolsillo.setBounds(posXPanelBolsillo, posYPanelBolsillo, anchoPanelBolsillo, altoPanelBolsillo);
        panelPersona.setBounds(margenPersonaX, margenPersonaY, anchoPersona, altoPersona);
        panelUsuario.setBounds(posXUsuario, posYUsuario, anchoUsuario, altoUsuario);
    }
}
