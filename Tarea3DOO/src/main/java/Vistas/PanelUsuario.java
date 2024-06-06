package Vistas;

import Modelo.Comprador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import Modelo.CreaMonedas;
import Modelo.Moneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.management.MemoryNotificationInfo;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;

/**
 * Clase que crea una interfaz grafica para que el usuario pueda apretar botones que interactuen
 * con un comprador
 */
public class PanelUsuario extends JPanel {
    private PanelMonedas panelMonedas;
    private PanelBotonConsumir panelBotonConsumir;

    /**
     * Grafica un panel para monedas y otro para poder consumir
     * @param bolsillo referencia al bolsillo grafico que se le añadiran monedas
     * @param comprador referencia al comprador que contiene el bolsillo
     * @param com referencia grafica del comprador
     */
    public PanelUsuario(PanelBolsillo bolsillo, Comprador comprador, PanelComprador com) {
        setLayout(null);
        panelMonedas = new PanelMonedas(bolsillo, comprador);
        this.add(panelMonedas);
        panelBotonConsumir = new PanelBotonConsumir(com, comprador);
        this.add(panelBotonConsumir);

        // Agregar un ComponentAdapter para manejar cambios de tamaño en el panel
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                actualizarDiseno();
            }
        });
    }

    /**
     * Método para actualizar el diseno de los componentes del panel de usuario.
     */
    private void actualizarDiseno() {
        int anchoPanel = getWidth();
        int altoPanel = getHeight();

        int margenX = (int) (anchoPanel * 0.05);
        int altoMonedas = altoPanel;
        int anchoMonedas = altoMonedas + margenX;
        int anchoBoton = anchoPanel - anchoMonedas;
        int altoBoton = altoPanel;

        int posXMonedas = anchoBoton;

        panelMonedas.setBounds(posXMonedas, 0, anchoMonedas, altoMonedas);
        panelBotonConsumir.setBounds(0, 0, anchoBoton, altoBoton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        actualizarDiseno(); // Asegurar que el diseno se actualice correctamente
    }

}


