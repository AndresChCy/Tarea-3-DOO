package Vistas;

import Modelo.Comprador;
import Modelo.Expendedor;

import javax.swing.*;
import java.awt.*;

/**
 * Clase PanelBotonDepositarMonedas que extiende JButton.
 * Representa un botón personalizado en forma de círculo para depositar monedas.
 */
public class PanelBotonDepositarMonedas extends JButton {

    /**
     * Constructor que crea un botón circular transparente y agrega un ActionListener.
     *
     * @param panelMensajes PanelMensajes al que se le actualizará el mensaje al hacer clic en el botón.
     */
    public PanelBotonDepositarMonedas(PanelMensajes panelMensajes, Comprador comprador, Expendedor expendedor,PanelComprador panel) {
        // Hacer el botón transparente
        setContentAreaFilled(false);

        // Agregar un ActionListener para manejar el evento de clic
        addActionListener(e -> {
            try {
                comprador.Pagar(expendedor);
                panel.repaint();

            } catch (Exception ex) {
                panelMensajes.actualizarMensaje("Por favor solo monedas");
                System.out.println("No puedes pagar con eso!");
            }
            panelMensajes.actualizarMensaje("Test1");
        });
    }

    /**
     * Override del método paintComponent para dibujar el botón circular.
     *
     * @param g el contexto gráfico en el cual dibujar.
     */
    @Override
    protected void paintComponent(Graphics g) {
        // Cambiar el color dependiendo del estado del botón
        if (getModel().isArmed()) {
            g.setColor(Color.darkGray); // Cuando el botón está presionado
        } else {
            g.setColor(Color.black); // Cuando el botón no está presionado
        }
        // Dibujar un óvalo relleno que representa el botón circular
        g.fillOval(0, 0, getWidth() - 1, getHeight() - 1);

        // Llamar al método de la superclase para asegurar que el botón se dibuje correctamente
        super.paintComponent(g);
    }

    /**
     * Override del método paintBorder para dibujar el borde del botón circular.
     *
     * @param g el contexto gráfico en el cual dibujar.
     */
    @Override
    protected void paintBorder(Graphics g) {
        // Establecer el color del borde y dibujar el óvalo del borde
        g.setColor(Color.green);
        g.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
    }

    /**
     * Override del método contains para detectar si un punto está dentro del círculo del botón.
     *
     * @param x coordenada X del punto a verificar.
     * @param y coordenada Y del punto a verificar.
     * @return true si el punto (x, y) está dentro del círculo, false en caso contrario.
     */
    @Override
    public boolean contains(int x, int y) {
        // Calcular el radio del botón circular
        int radio = Math.min(getWidth(), getHeight()) / 2;
        // Calcular las coordenadas del centro del botón
        int centroX = getWidth() / 2;
        int centroY = getHeight() / 2;

        // Calcular la distancia entre el punto dado y el centro del botón
        int distancia = (int) Math.sqrt(Math.pow(x - centroX, 2) + Math.pow(y - centroY, 2));

        // Verificar si la distancia es menor o igual al radio para determinar si está dentro del círculo
        return distancia <= radio;
    }
}
