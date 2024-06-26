package Vistas;

import Modelo.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import Modelo.CaracteristicasProducto;
import Modelo.Expendedor;

/**
 * La clase PanelBotones representa un panel que contiene botones con imágenes de productos.
 * Los botones se redimensionan automáticamente cuando se cambia el tamaño del panel.
 */
public class PanelBotones extends JPanel {
    private Map<String, BufferedImage> imagenesBotones;
    private String[] botones = {"Fanta", "Sprite", "CocaCola", "Snickers", "Super8", "Check"};
    private JButton[] botonesArray;
    private CaracteristicasProducto cualProducto;
    private PanelMensajes panelMensajes;

    private Expendedor expendedor;
    private PanelExpendedor exp;

    /**
     * Constructor de la clase PanelBotones.
     * Inicializa el panel, carga las imágenes de los productos y configura el diseño del panel.
     */

    public PanelBotones(Expendedor expendedor, PanelMensajes panelMensajes,PanelExpendedor exp) {
        this.expendedor = expendedor;
        this.exp = exp;
        // Inicializa el mapa de imágenes
        imagenesBotones = new HashMap<>();
        botonesArray = new JButton[6];

        // Inicializa el panel de los mensajes
        this.panelMensajes = panelMensajes;


        try {
            // Cargar las imágenes de los productos y almacenarlas en el mapa
            imagenesBotones.put("Fanta", ImageIO.read(getClass().getResource("/Logo_Fanta.png")));
            imagenesBotones.put("Sprite", ImageIO.read(getClass().getResource("/Logo_Sprite.png")));
            imagenesBotones.put("CocaCola", ImageIO.read(getClass().getResource("/Logo_CocaCola.png")));
            imagenesBotones.put("Snickers", ImageIO.read(getClass().getResource("/Logo_Snickers.png")));
            imagenesBotones.put("Super8", ImageIO.read(getClass().getResource("/Logo_Super8.png")));
            imagenesBotones.put("Check", ImageIO.read(getClass().getResource("/Check.png")));
        } catch (IOException ex) {
            // Manejar cualquier error de carga de imágenes
            System.out.println("Error al cargar imágenes: " + ex.getMessage());
        }

        // Configura el layout del panel
        setLayout(new GridLayout(3, 2));
        // Agrega los botones al panel
        agregarBotones();

        // Añadir un ComponentListener para redimensionar los iconos de los botones al cambiar el tamaño del panel
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                redimensionarIconos();
            }
        });
    }

    /**
     * Método que agrega los botones al panel y establece las imágenes.
     */
    public void agregarBotones() {
        // Crea los botones y establece las imágenes
        for (int i = 0; i < 6; i++) {
            String nombreBoton = botones[i];
            BufferedImage productoImg = imagenesBotones.get(nombreBoton);
            if (productoImg != null ) {
                JButton boton = new JButton();
                botonesArray[i] = boton;
                add(boton);
                if (i < 5) {
                    boton.addActionListener(new ElegirProducto(i));
                } else { // Botón "Comprar"
                    boton.addActionListener(new ConfirmarPago());
                }
            }
        }
    }

    /**
     * Método que redimensiona los iconos de los botones según el tamaño del panel.
     */
    private void redimensionarIconos() {
        for (int i = 0; i < 6; i++) {
            String nombreBoton = botones[i];
            BufferedImage productoImg = imagenesBotones.get(nombreBoton);
            if (productoImg != null) {
                JButton boton = botonesArray[i];
                int anchoBoton = boton.getWidth();
                int altoBoton = boton.getHeight();
                if (anchoBoton > 0 && altoBoton > 0) {
                    Image img = productoImg.getScaledInstance(anchoBoton, altoBoton, Image.SCALE_SMOOTH);
                    ImageIcon icono = new ImageIcon(img);
                    boton.setIcon(icono);
                }
            }
        }
    }

    /**
     * Clase privada especial para definir botones que se usan para elegir Productos
     */

    private class ElegirProducto implements ActionListener {
        private CaracteristicasProducto cual;

        /**
         * define que producto se asociara al boton
         * @param cual el producto
         */
        public ElegirProducto(int cual) {
            this.cual = SintetizadorVisual.ObtenerEleccion(cual);
        }

        /**
         * guarda el producto que sea clickedo para tenerlo de opcion al ser comprado
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            cualProducto = cual;
            String mensaje = SintetizadorVisual.verificarProducto(cual,expendedor);
            panelMensajes.actualizarMensaje(mensaje );
        }
    }

    /**
     * Clase privada para definir el boton que se usara para confirmar la compra
     */
    private class ConfirmarPago implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (expendedor.getCantidadDepositoExpecial() == 0) {
                try{
                    expendedor.comprarProducto(cualProducto);
                    panelMensajes.actualizarMensaje("Compra exitosa! \n Retire el producto");
                    exp.repaint();
                } catch (NoHayProductoException ex) {
                    panelMensajes.actualizarMensaje("Producto no disponible :(");
                } catch (PagoInsuficienteException ex) {
                    panelMensajes.actualizarMensaje("Pago insuficiente." +
                            " \n Por favor retire su dinero.");
                } catch (PagoIncorrectoException ex) {
                    panelMensajes.actualizarMensaje("Ingrese monedas para pagar.");
                }
                } else {
                    panelMensajes.actualizarMensaje("Favor retirar producto\nantes de comprar otro.");
                }
            }
        }
    }

