package Vistas;
import javax.swing.*;
import java.awt.*;

import Modelo.Comprador ;
import Modelo.Moneda1500;

import java.awt.Graphics;

public class PanelComprador extends JPanel {
    private PanelUsuario panelUsuario;
    private PanelBolsillo panelBolsillo;
    private PanelPersona panelPersona;

    public PanelComprador(Comprador comprador) {

        this.setBackground(Color.green);
        this.setLayout(null);

        panelBolsillo = new PanelBolsillo(comprador);
        panelUsuario = new PanelUsuario();
        panelPersona = new PanelPersona();

        this.add(panelUsuario);
        this.add(panelBolsillo);
        this.add(panelPersona);
}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int anchoPanel = getWidth();
        int altoPanel = getHeight();

        //Calcular posiciones y dimensiones de PanelBolsillo
        int anchoPanelBolsillo = (int) (anchoPanel * 0.45);
        int altoPanelBolsillo = (int) (altoPanel * 0.75);
        int posXPanelBolsillo = (int) (anchoPanel * 0.55);
        int posYPanelBolsillo = 0;

        //Calcular posiciones y dimensiones de la Persona
        int margenPersonaX = (int) (anchoPanel * 0.01);
        int margenPersonaY = (int) (altoPanel * 0.01);
        int anchoPersona = (int) ((anchoPanel * 0.55) - (2 * margenPersonaX));
        int altoPersona = (int) ((altoPanel * 0.75) - (2 * margenPersonaY));

        //Calcular posiciones y dimensiones de la interfaz de Usuario
        int anchoUsuario = anchoPanel;
        int altoUsuario = (int) (altoPanel * 0.25);
        int posXUsuario = 0;
        int posYUsuario = (int) (altoPanel * 0.75);

        //Establecer los límites de los componentes
        panelBolsillo.setBounds(posXPanelBolsillo, posYPanelBolsillo, anchoPanelBolsillo, altoPanelBolsillo);
        panelPersona.setBounds(margenPersonaX, margenPersonaY, anchoPersona, altoPersona);
        panelUsuario.setBounds(posXUsuario, posYUsuario, anchoUsuario, altoUsuario);
    }
}
