package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;

/**
 * La clase PanelMensajes representa un panel que muestra mensajes en una interfaz gráfica.
 * Los mensajes se centran automáticamente y se ajustan para ocupar el espacio disponible en el panel.
 */
public class PanelMensajes extends JPanel {
    private String mensaje = "Bienvenido a la\nmáquina del Futuro";
    private String guardado="";


    /**
     * Constructor de la clase PanelMensajes.
     * Establece el color de fondo del panel.
     */
    public PanelMensajes() {
        this.setBackground(Color.black);
    }

    /**
     * Actualiza el mensaje que se muestra en el panel y repinta el componente.
     *
     * @param nuevoMensaje El nuevo mensaje a mostrar.
     */
    public void actualizarMensaje(String nuevoMensaje) {
        this.mensaje = nuevoMensaje;
        guardado = nuevoMensaje;
        repaint();
    }
    public void actualizarMensaje(int i){
        mensaje = guardado + "\n Ingreso: " + i+ "$";
        repaint();
    }

    public String getMensaje(){
        return this.mensaje;
    }

    /**
     * Sobrescribe el método paintComponent para personalizar la renderización del componente.
     * Dibuja el mensaje en el panel centrado tanto horizontal como verticalmente.
     *
     * @param g El contexto gráfico.
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

        // Dividir el mensaje en líneas
        String[] lineas = this.mensaje.split("\n");

        // Calcular la altura total del texto para centrarlo verticalmente
        int totalHeight = fm.getHeight() * lineas.length;
        int posY = (largoPanel - totalHeight) / 2 + fm.getAscent();

        // Dibujar cada línea del mensaje
        for (String linea : lineas) {
            // Calcular la posición X para centrar el texto horizontalmente
            int posX = (anchoPanel - fm.stringWidth(linea)) / 2;
            g.drawString(linea, posX, posY);
            posY += fm.getHeight();
        }
    }

    /**
     * Calcula el tamaño de las letras para que el mensaje se ajuste al área disponible del panel.
     *
     * @param ancho El ancho del panel.
     * @param largo El largo del panel.
     * @return El tamaño de la letra calculado.
     */
    private int calculadoraTamanoLetras(int ancho, int largo) {
        int tamanoLetras = 10; // Tamaño inicial de las letras
        String[] lineas = this.mensaje.split("\n");
        Graphics g = getGraphics();
        if (g != null) {
            FontMetrics fm;
            boolean esDemasiadoGrande = false;
            do {
                // Configurar la fuente con el tamaño actual
                g.setFont(new Font("Kristen ITC", Font.BOLD, tamanoLetras));
                fm = g.getFontMetrics();

                // Calcular el ancho máximo de las líneas
                int maxAnchoLinea = 0;
                for (String linea : lineas) {
                    int anchoLinea = fm.stringWidth(linea);
                    if (anchoLinea > maxAnchoLinea) {
                        maxAnchoLinea = anchoLinea;
                    }
                }

                // Calcular la altura total del texto
                int totalHeight = fm.getHeight() * lineas.length;

                // Verificar si el texto es demasiado grande para el panel
                if (maxAnchoLinea >= ancho * 0.9 || totalHeight >= largo * 0.9) {
                    esDemasiadoGrande = true;
                } else {
                    tamanoLetras++; // Incrementar el tamaño de las letras si aún caben en el panel
                }
            } while (!esDemasiadoGrande);
        }
        return tamanoLetras - 1; // Decrementar en 1 para obtener el último tamaño que cabía
    }
}
