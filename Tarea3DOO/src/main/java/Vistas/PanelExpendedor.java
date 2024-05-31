package Vistas;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    private PanelMaquina panelMaquina;
    private PanelMaquina2 panelMaquina2;
    private PanelDepositos panelDepositos;
    private PanelZonaExtraccion panelZonaExtraccion;

    public PanelExpendedor() {
        this.setBackground(new java.awt.Color(30, 120, 120));
        this.setLayout(null);

        panelMaquina = new PanelMaquina();
        panelMaquina2 = new PanelMaquina2();
        panelDepositos = new PanelDepositos();
        panelZonaExtraccion = new PanelZonaExtraccion();

        panelMaquina.setLayout(null);
        panelMaquina.add(panelDepositos);
        panelMaquina.add(panelZonaExtraccion);

        this.add(panelMaquina);
        this.add(panelMaquina2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int marginTop = 10;
        int marginBottom = 25;

        int totalHeight = panelHeight - marginTop - marginBottom;
        int totalWidth = panelWidth - 20; // Ajuste para ambos paneles y la línea divisoria
        int machineHeight = totalHeight;
        int machineWidth1 = (int) (totalWidth * 0.6);
        int machineWidth2 = (int) (totalWidth * 0.4);
        int machineX1 = 10;
        int machineX2 = machineX1 + machineWidth1 + 1; // +1 para la línea divisoria
        int machineY = marginTop;

        int ventanaWidth1 = machineWidth1 * 75 / 100;
        int ventanaHeight1 = machineHeight * 70 / 100;
        int ventanaX1 = (machineWidth1 - ventanaWidth1) / 2; // Centrado dentro de panelMaquina
        int ventanaY1 = 20;

        int zonaExtraccionWidth1 = ventanaWidth1 * 90 / 100;
        int zonaExtraccionHeight1 = machineHeight * 10 / 100;
        int zonaExtraccionX1 = (machineWidth1 - zonaExtraccionWidth1) / 2; // Centrado dentro de panelMaquina
        int zonaExtraccionY1 = machineHeight - zonaExtraccionHeight1 - 45;

        panelMaquina.setBounds(machineX1, machineY, machineWidth1, machineHeight);
        panelMaquina2.setBounds(machineX2, machineY, machineWidth2, machineHeight);
        panelDepositos.setBounds(ventanaX1, ventanaY1, ventanaWidth1, ventanaHeight1);
        panelZonaExtraccion.setBounds(zonaExtraccionX1, zonaExtraccionY1, zonaExtraccionWidth1, zonaExtraccionHeight1);

        // Dibujar la línea divisoria
        g.setColor(Color.BLACK);
        g.drawLine(machineX1 + machineWidth1, machineY, machineX1 + machineWidth1, machineY + machineHeight);
    }
}
