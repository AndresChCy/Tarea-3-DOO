package Vistas;


import javax.swing.*;
import java.awt.*;

import Modelo.*;

/**
 * La clase PanelExpendedor representa el panel que contiene la interfaz gráfica del expendedor.
 */
public class PanelExpendedor extends JPanel {
    private PanelMaquina panelMaquina;
    private PanelMaquina2 panelMaquina2;
    private PanelDepositos panelDepositos;
    private PanelZonaExtraccion panelZonaExtraccion;
    private Expendedor expendedor;

    /**
     * Constructor de la clase PanelExpendedor.
     * Inicializa los componentes de la interfaz gráfica del expendedor.
     * @param expendedor El Expendedor asociado al panel.
     */
    public PanelExpendedor(Expendedor expendedor, Comprador comprador,PanelComprador com) {
        this.expendedor = expendedor;
        // Establecer el color de fondo del panel
        this.setBackground(new java.awt.Color(30, 120, 120));
        // Configurar el diseño del panel como null para permitir un diseño personalizado
        this.setLayout(null);

        // Inicializar los componentes de la interfaz gráfica del expendedor
        panelMaquina = new PanelMaquina();
        panelMaquina2 = new PanelMaquina2(expendedor);
        panelDepositos = new PanelDepositos(expendedor);
        panelZonaExtraccion = new PanelZonaExtraccion(comprador, expendedor,com);

        // Configurar el diseño del panel interno de la máquina como null para permitir un diseño personalizado
        panelMaquina.setLayout(null);
        // Agregar los paneles de depósitos y zona de extracción al panel interno de la máquina
        panelMaquina.add(panelDepositos);
        panelMaquina.add(panelZonaExtraccion);

        // Agregar los paneles de la máquina y el expendedor al panel principal
        this.add(panelMaquina);
        this.add(panelMaquina2);
    }

    /**
     * Método sobrescrito para dibujar los componentes y personalizar el diseño del panel expendedor.
     * @param g El contexto gráfico en el que se dibujan los componentes.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Obtener las dimensiones del panel
        int anchoPanel = getWidth();
        int altoPanel = getHeight();

        // Definir márgenes y dimensiones de los componentes
        int margen = 10;
        int anchoDivisor = 1;
        int anchoDisponible = anchoPanel - (2 * margen) - anchoDivisor;
        int anchoMaquina1 = anchoDisponible / 2;
        int anchoMaquina2 = anchoDisponible / 2;
        double relacionAspecto = 0.45;
        int altoMaximoMaquina = altoPanel - (2 * margen);
        int altoMaquina = (int) (anchoMaquina1 / relacionAspecto);
        if (altoMaquina > altoMaximoMaquina) {
            altoMaquina = altoMaximoMaquina;
            anchoMaquina1 = (int) (altoMaquina * relacionAspecto);
            anchoMaquina2 = anchoMaquina1;
        }

        // Calcular posiciones de los componentes
        int anchoTotal = anchoMaquina1 + anchoDivisor + anchoMaquina2;
        int inicioX = (anchoPanel - anchoTotal) / 2;
        int maquinaX1 = inicioX;
        int maquinaX2 = maquinaX1 + anchoMaquina1 + anchoDivisor;
        int maquinaY = margen;

        int anchoVentana1 = anchoMaquina1 * 75 / 100;
        int altoVentana1 = altoMaquina * 70 / 100;
        int ventanaX1 = (anchoMaquina1 - anchoVentana1) / 2;
        int ventanaY1 = maquinaY + 20;

        int anchoZonaExtraccion = anchoVentana1 * 90 / 100;
        int altoZonaExtraccion = altoMaquina * 10 / 100;
        int zonaExtraccionX = (anchoMaquina1 - anchoZonaExtraccion) / 2;
        int zonaExtraccionY = maquinaY + altoMaquina - altoZonaExtraccion - 45;

        // Establecer los límites de los componentes
        panelMaquina.setBounds(maquinaX1, maquinaY, anchoMaquina1, altoMaquina);
        panelMaquina2.setBounds(maquinaX2, maquinaY, anchoMaquina2, altoMaquina);
        panelDepositos.setBounds(ventanaX1, ventanaY1, anchoVentana1, altoVentana1);
        panelZonaExtraccion.setBounds(zonaExtraccionX, zonaExtraccionY, anchoZonaExtraccion, altoZonaExtraccion);

        // Dibujar la línea divisoria entre las dos máquinas
        g.setColor(Color.BLACK);
        g.drawLine(maquinaX1 + anchoMaquina1, maquinaY, maquinaX1 + anchoMaquina1, maquinaY + altoMaquina);
    }
}