package Vistas;

import Modelo.Comprador;
import Modelo.Moneda;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

/**
 * Clase PanelBolsillo que extiende JPanel.
 * Representa el panel que muestra el bolsillo del comprador, que contiene varias monedas.
 */
public class PanelBolsillo extends JPanel {
    Comprador comprador; // El comprador asociado al bolsillo
    private PanelSlot[] slots; // Array de slots que representan las posiciones del bolsillo

    /**
     * Constructor de la clase PanelBolsillo.
     * Configura el diseño del panel como una cuadrícula de 5x2 y crea los slots del bolsillo.
     *
     * @param comprador el objeto Comprador asociado al bolsillo.
     */
    public PanelBolsillo(Comprador comprador){
        // Configurar el diseño del panel como una cuadrícula de 5x2
        this.setLayout(new GridLayout(5, 2));
        // Inicializar el array de slots
        slots = new PanelSlot[10];
        this.comprador = comprador; // Asignar el comprador pasado como parámetro
        // Crear los slots del bolsillo y agregarlos al panel
        for (int i = 0; i < 10; i++) {
            slots[i] = new PanelSlot();
            this.add(slots[i]);
        }
    }

    /**
     * Override del método paintComponent para actualizar la apariencia del bolsillo.
     *
     * @param g el contexto gráfico en el cual dibujar.
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Moneda m = null; // Inicializar la moneda a null
        // Recorrer todas las posiciones del bolsillo
        for (int i = 0; i < 10; i++) {
            // Obtener la moneda en la posición actual si existe
            if (i < comprador.getBolsillo().size())
                m = comprador.getBolsillo().get(i);
            // Establecer la moneda en el slot correspondiente
            slots[i].setContiene(m);
            m = null; // Reiniciar la moneda para la siguiente iteración
        }
    }
}
