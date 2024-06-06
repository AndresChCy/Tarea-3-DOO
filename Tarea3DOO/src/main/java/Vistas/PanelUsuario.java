package Vistas;

import Modelo.Comprador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class PanelUsuario extends JPanel {
    private PanelMonedas panelMonedas;
    private PanelBotonConsumir panelBotonConsumir;

    public PanelUsuario(PanelBolsillo bolsillo,Comprador comprador) {
        setLayout(null);
        panelMonedas = new PanelMonedas(bolsillo, comprador);
        this.add(panelMonedas);
        panelBotonConsumir = new PanelBotonConsumir();
        this.add(panelBotonConsumir);

        // Agregar un ComponentAdapter para manejar cambios de tamaño en el panel
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                actualizarDiseño();
            }
        });
    }

    /**
     * Método para actualizar el diseño de los componentes del panel de usuario.
     */
    private void actualizarDiseño() {
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
        actualizarDiseño(); // Asegurar que el diseño se actualice correctamente
    }
}
