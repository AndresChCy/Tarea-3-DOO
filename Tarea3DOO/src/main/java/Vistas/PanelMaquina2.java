package Vistas;

import Modelo.Comprador;
import Modelo.Expendedor;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * La clase PanelMaquina2 representa un panel que muestra la imagen de fondo de la segunda parte de la máquina expendedora.
 * Contiene un panel de botones y de mensajes que se ajustan automáticamente al tamaño del panel principal.
 */
public class PanelMaquina2 extends JPanel {
    private Expendedor expendedor;
    private BufferedImage imagenFondoMaquina2; // Imagen de fondo de la segunda máquina
    private PanelBotones panelBotones; // Panel que contiene los botones
    private PanelMensajes panelMensajes; // Panel que muestra los mensajes
    private PanelBotonDepositarMonedas panelBotonDepositarMonedas; // Botón para depositar monedas
    private PanelBotonRetirarVuelto panelBotonRetirarVuelto; // Botón para retirar vuelto



    /**
     * Constructor de la clase PanelMaquina2.
     * Inicializa el panel, carga la imagen de fondo de la segunda máquina y agrega el panel de botones.
     *
     * @param expendedor el expendedor asociado a este panel.
     */

    public PanelMaquina2(Expendedor expendedor,Comprador comprador, PanelComprador com,PanelExpendedor exp) {

        this.expendedor = expendedor;


        try {
            // Cargar la imagen de fondo de la segunda máquina
            imagenFondoMaquina2 = ImageIO.read(getClass().getResource("/Máquina_Fondo_2.png"));
        } catch (IOException ex) {
            // Manejar cualquier error de carga de imagen
            System.out.println("Error al cargar imagen de fondo de la segunda máquina: " + ex.getMessage());
        }

        setLayout(null); // Usar un diseño nulo para posicionar manualmente los componentes

        // Crear y agregar el panel de mensajes
        panelMensajes = new PanelMensajes();
        this.add(panelMensajes);

        // Crear y agregar el panel de botones

        panelBotones = new PanelBotones(expendedor, panelMensajes,exp);

        this.add(panelBotones);

        // Crear y agregar los botones para depositar monedas y retirar vuelto

        panelBotonDepositarMonedas = new PanelBotonDepositarMonedas(panelMensajes,expendedor,com,comprador);
        panelBotonRetirarVuelto = new PanelBotonRetirarVuelto(panelMensajes,comprador,expendedor,com);

        this.add(panelBotonDepositarMonedas);
        this.add(panelBotonRetirarVuelto);

        // Añadir un ComponentListener para actualizar la posición y el tamaño de panelBotones al cambiar el tamaño del panel
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                ajustarPanelBotones();
            }
        });
    }

    /**
     * Método sobrescrito para dibujar la imagen de fondo de la segunda máquina en el panel.
     *
     * @param g El contexto gráfico en el que se dibuja la imagen.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Verificar si la imagen de fondo de la segunda máquina existe y dibujarla
        if (imagenFondoMaquina2 != null) {
            int anchoPanel = getWidth();
            int altoPanel = getHeight();
            // Dibujar la imagen de fondo escalada para que cubra todo el panel
            g.drawImage(imagenFondoMaquina2.getScaledInstance(anchoPanel, altoPanel, Image.SCALE_SMOOTH), 0, 0, this);
        }

        // Ajustar el tamaño y la posición de panelBotones
        ajustarPanelBotones();

        // Ajustar el tamaño y la posición de panelMensajes
        ajustarPanelMensajes();

        // Ajustar el tamaño y la posición de los botones relacionados a las monedas
        ajustarPanelBotonesMonedas();
    }

    /**
     * Ajusta el tamaño y la posición del panel de botones en función del tamaño del panel principal.
     */
    private void ajustarPanelBotones() {
        int anchoPanel = getWidth();
        int altoPanel = getHeight();

        // Calcular los márgenes proporcionales al tamaño del panel
        int margenX = (int) (anchoPanel * 0.15); // Margen de 15% del ancho del panel
        int margenYArriba = (int) (altoPanel * 0.1); // Margen de 10% de la mitad del alto del panel
        int margenYAbajo = (int) (altoPanel * 0.05); // Margen de 5% del alto del panel

        // Calcular las posiciones y dimensiones de PanelBotones
        int anchoBotones = anchoPanel - 2 * margenX;
        int altoBotones = (altoPanel / 2) - margenYArriba - margenYAbajo;
        int xBotones = margenX;
        int yBotones = altoPanel / 2 - margenYArriba - margenYAbajo;

        // Establecer los límites del panel de botones
        panelBotones.setBounds(xBotones, yBotones, anchoBotones, altoBotones);
        panelBotones.revalidate();
        panelBotones.repaint();
    }

    /**
     * Ajusta el tamaño y la posición del panel de mensajes en función del tamaño del panel principal.
     */
    private void ajustarPanelMensajes() {
        int anchoPanel = getWidth();
        int altoPanel = getHeight();

        // Calcular los márgenes proporcionales al tamaño del panel
        int margenMensajesX = (int) (anchoPanel * 0.05); // Margen de 5% del ancho del panel
        int margenMensajesY = (int) (altoPanel * 0.025); // Margen de 2.5% del alto del panel

        // Calcular las posiciones y dimensiones de PanelMensajes
        int anchoMensajes = anchoPanel - 2 * margenMensajesX;
        int altoMensajes = altoPanel / 3 - 2 * margenMensajesY;
        int xMensajes = margenMensajesX;
        int yMensajes = margenMensajesY;

        // Establecer límites del panel de los mensajes
        panelMensajes.setBounds(xMensajes, yMensajes, anchoMensajes, altoMensajes);
    }

    /**
     * Ajusta el tamaño y la posición de los botones de depositar monedas y retirar vuelto en función del tamaño del panel principal.
     */
    private void ajustarPanelBotonesMonedas() {
        int anchoPanel = getWidth();
        int altoPanel = getHeight();

        // Relación para calcular los márgenes
        double relacionMargen = 0.15;

        // Calcular el tamaño de los botones de monedas
        int anchoBotonesMonedas = anchoPanel / 4;
        int altoBotonesMonedas = anchoBotonesMonedas;

        // Calcular la distancia entre los botones
        int distanciaBotones = (int) (anchoPanel - 2 * ((anchoPanel * relacionMargen) + anchoBotonesMonedas));

        // Calcular los márgenes y posiciones de los botones
        int margenBotonesMonedasX1 = (int) (anchoPanel * relacionMargen);
        int margenBotonesMonedasX2 = margenBotonesMonedasX1 + anchoBotonesMonedas + distanciaBotones;
        int margenBotonesMonedasY = (int) (altoPanel * 0.75);

        // Establecer los límites de los botones
        panelBotonDepositarMonedas.setBounds(margenBotonesMonedasX1, margenBotonesMonedasY, anchoBotonesMonedas, altoBotonesMonedas);
        panelBotonRetirarVuelto.setBounds(margenBotonesMonedasX2, margenBotonesMonedasY, anchoBotonesMonedas, altoBotonesMonedas);
    }
}
