package Vistas;

import javax.swing.*;
import java.awt.*;
import Modelo.Expendedor;

public class PanelExpendedor extends JPanel {
    private PanelMaquina panelMaquina;
    private PanelMaquina2 panelMaquina2;
    private PanelDepositos panelDepositos;
    private PanelZonaExtraccion panelZonaExtraccion;

    public PanelExpendedor(Expendedor expendedor) {
        this.setBackground(new java.awt.Color(30, 120, 120));
        this.setLayout(null);

        panelMaquina = new PanelMaquina();
        panelMaquina2 = new PanelMaquina2();
        panelDepositos = new PanelDepositos(expendedor);
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

        int anchoPanel = getWidth();
        int altoPanel = getHeight();

        // Margen superior, inferior y a los lados
        int margen = 10;
        // Ancho de la línea divisoria entre las dos máquinas
        int anchoDivisor = 1;

        // Calcular el ancho disponible para las máquinas
        int anchoDisponible = anchoPanel - (2 * margen) - anchoDivisor;
        int anchoMaquina1 = anchoDisponible / 2;
        int anchoMaquina2 = anchoDisponible / 2;

        // Asegurarse de que la altura mantenga la relación de aspecto
        double relacionAspecto = 0.45;
        int altoMaximoMaquina = altoPanel - (2 * margen);
        int altoMaquina = (int) (anchoMaquina1 / relacionAspecto);

        if (altoMaquina > altoMaximoMaquina) {
            altoMaquina = altoMaximoMaquina;
            anchoMaquina1 = (int) (altoMaquina * relacionAspecto);
            anchoMaquina2 = anchoMaquina1;
        }

        // Calcular las posiciones horizontales para centrar el expendedor
        int anchoTotal = anchoMaquina1 + anchoDivisor + anchoMaquina2;
        int inicioX = (anchoPanel - anchoTotal) / 2;
        int maquinaX1 = inicioX;
        int maquinaX2 = maquinaX1 + anchoMaquina1 + anchoDivisor;
        int maquinaY = margen;

        // Dimensiones y posiciones de los componentes internos
        int anchoVentana1 = anchoMaquina1 * 75 / 100;
        int altoVentana1 = altoMaquina * 70 / 100;
        int ventanaX1 = (anchoMaquina1 - anchoVentana1) / 2;
        int ventanaY1 = maquinaY + 20;

        int anchoZonaExtraccion = anchoVentana1 * 90 / 100;
        int altoZonaExtraccion = altoMaquina * 10 / 100;
        int zonaExtraccionX = (anchoMaquina1 - anchoZonaExtraccion) / 2;
        int zonaExtraccionY = maquinaY + altoMaquina - altoZonaExtraccion - 45;

        // Establecer los límites de los paneles
        panelMaquina.setBounds(maquinaX1, maquinaY, anchoMaquina1, altoMaquina);
        panelMaquina2.setBounds(maquinaX2, maquinaY, anchoMaquina2, altoMaquina);
        panelDepositos.setBounds(ventanaX1, ventanaY1, anchoVentana1, altoVentana1);
        panelZonaExtraccion.setBounds(zonaExtraccionX, zonaExtraccionY, anchoZonaExtraccion, altoZonaExtraccion);

        // Dibujar la línea divisoria
        g.setColor(Color.BLACK);
        g.drawLine(maquinaX1 + anchoMaquina1, maquinaY, maquinaX1 + anchoMaquina1, maquinaY + altoMaquina);
    }
}
