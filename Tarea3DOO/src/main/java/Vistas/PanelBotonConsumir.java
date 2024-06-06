package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase PanelBotonConsumir que extiende JButton.
 * Representa un botón personalizado para consumir algo.
 */
public class PanelBotonConsumir extends JButton {
    private String texto; // Texto que se mostrará en el botón

    /**
     * Constructor de la clase PanelBotonConsumir.
     * Configura el fondo del botón y establece el texto.
     * Agrega un ActionListener para manejar el evento de clic del mouse.
     */
    public PanelBotonConsumir() {
        this.setBackground(Color.BLACK); // Establecer el fondo del botón como negro
        this.texto = "Consumir"; // Texto predeterminado

        // Agregar el listener para el evento de clic del mouse
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar el código que deseas ejecutar cuando se haga clic en el botón
                System.out.println("Botón Consumir clickeado");
            }
        });
    }

    /**
     * Override del método paintComponent para personalizar el aspecto del botón.
     * Dibuja el texto centrado vertical y horizontalmente en el botón.
     *
     * @param g el contexto gráfico en el cual dibujar.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int anchoPanel = getWidth();
        int largoPanel = getHeight();

        // Establecer el color del texto
        g.setColor(Color.ORANGE);

        // Calcular el tamaño de la fuente adecuado
        int tamanoLetras = calculadoraTamanoLetras(anchoPanel, largoPanel);

        // Configurar la fuente y obtener métricas de la fuente
        g.setFont(new Font("Kristen ITC", Font.BOLD, tamanoLetras));
        FontMetrics fm = g.getFontMetrics();

        // Calcular la altura total del texto para centrarlo verticalmente
        int alturaTotal = fm.getHeight();
        int posY = (largoPanel - alturaTotal) / 2 + fm.getAscent();

        // Calcular la posición X para centrar el texto horizontalmente
        int posX = (anchoPanel - fm.stringWidth(texto)) / 2;

        // Dibujar el texto en el botón
        g.drawString(texto, posX, posY);
    }

    /**
     * Método privado para calcular el tamaño de las letras adecuado para que el texto quepa en el botón.
     *
     * @param ancho el ancho del botón.
     * @param largo el largo del botón.
     * @return el tamaño de las letras adecuado para el texto.
     */
    private int calculadoraTamanoLetras(int ancho, int largo) {
        int tamanoLetras = 16; // Tamaño inicial de las letras
        String mensaje = "Consumir";
        Graphics g = getGraphics();
        if (g != null) {
            FontMetrics fm;
            boolean esDemasiadoGrande = false;
            do {
                // Configurar la fuente con el tamaño actual
                g.setFont(new Font("Matura M7 Script Capitals", Font.BOLD, tamanoLetras));
                fm = g.getFontMetrics();

                // Calcular el ancho del texto
                int anchoTexto = fm.stringWidth(mensaje);

                // Calcular la altura total del texto
                int totalHeight = fm.getHeight();

                // Verificar si el texto es demasiado grande para el panel
                if (anchoTexto >= ancho * 0.9 || totalHeight >= largo * 0.9) {
                    esDemasiadoGrande = true;
                } else {
                    tamanoLetras++; // Incrementar el tamaño de las letras si aún caben en el panel
                }
            } while (!esDemasiadoGrande);
        }
        return tamanoLetras - 1; // Decrementar en 1 para obtener el último tamaño que cabía
    }
}
