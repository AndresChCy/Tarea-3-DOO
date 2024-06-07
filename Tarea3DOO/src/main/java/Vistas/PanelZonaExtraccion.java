package Vistas;

import Modelo.Comprador;
import Modelo.Expendedor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * La clase PanelZonaExtraccion representa un panel que muestra la zona de extracción de productos de la máquina expendedora.
 * Cambia la imagen de la máquina entre abierta y cerrada según el movimiento y salida del ratón.
 */
public class PanelZonaExtraccion extends JPanel {
    private BufferedImage imagenMaquinaCerrada;
    private BufferedImage imagenMaquinaAbierta;
    private BufferedImage imagenMaquinaActual;

    /**
     * Constructor de la clase PanelZonaExtraccion.
     * Inicializa el panel y carga las imágenes de la máquina abierta y cerrada.
     * Agrega listeners para manejar los eventos de movimiento y salida del ratón.
     */
    public PanelZonaExtraccion(Comprador comprador, Expendedor expendedor,PanelComprador com) {
        this.setOpaque(false);
        try {
            // Cargar las imágenes de la máquina abierta y cerrada
            imagenMaquinaCerrada = ImageIO.read(getClass().getResource("/Máquina_Cerrada.png"));
            imagenMaquinaAbierta = ImageIO.read(getClass().getResource("/Máquina_Abierta.png"));
            // Establecer la imagen actual como la máquina cerrada por defecto
            imagenMaquinaActual = imagenMaquinaCerrada;
        } catch (IOException ex) {
            // Manejar cualquier error de carga de imagen
            System.out.println("Error al cargar imagen de zona de extracción: " + ex.getMessage());
        }
        JLabel producto = new JLabel()  ;
        add(producto);

        // Agregar un listener para manejar el movimiento del ratón
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                // Cambiar la imagen de la máquina a abierta cuando el ratón se mueve sobre el panel
                try{
                    actualizarIcono(PanelZonaExtraccion.this,SintetizadorVisual.ObtenerIcono(expendedor.getProducto()).getImage(),producto);
                }catch(NullPointerException ex){
                    producto.setIcon(null);
                }
                imagenMaquinaActual = imagenMaquinaAbierta;
                repaint(); // Volver a pintar el panel
            }
        });

        // Agregar un listener para manejar la salida del ratón del panel
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                // Cambiar la imagen de la máquina a cerrada cuando el ratón sale del panel
                producto.setIcon(null);
                imagenMaquinaActual = imagenMaquinaCerrada;
                repaint(); // Volver a pintar el panel
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                comprador.agarrarProducto(expendedor);
                producto.setIcon(null);
                repaint();
                com.repaint();
            }
        });
    }

    /**
     * Método sobrescrito para dibujar la imagen de la máquina actual en el panel.
     * @param g El contexto gráfico en el que se dibuja la imagen.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Obtener las dimensiones del panel
        int anchoPanel = getWidth();
        int altoPanel = getHeight();
        // Dibujar la imagen de la máquina actual en el panel
        g.drawImage(imagenMaquinaActual.getScaledInstance(anchoPanel, altoPanel, Image.SCALE_SMOOTH), 0, 0, this);
    }
    /**
     * Actualiza el icono de un JLabel rotando la imagen 90 grados y escalándola
     * para ajustarse al tamaño del botón especificado.
     *
     * @param boton El botón al cual se ajustará la imagen.
     * @param imagen La imagen que se rotará y escalará.
     * @param etiquetaProducto El JLabel cuyo icono se actualizará.
     */
    private void actualizarIcono(PanelZonaExtraccion boton, Image imagen, JLabel etiquetaProducto) {
        if (imagen != null) {
            int anchoBoton = boton.getWidth();
            int altoBoton = boton.getHeight();
            if (anchoBoton > 0 && altoBoton > 0) {
                // Convertir la imagen a BufferedImage si no lo es
                BufferedImage imagenBufferizada;
                imagenBufferizada = new BufferedImage(imagen.getWidth(null), imagen.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                Graphics2D bGr = imagenBufferizada.createGraphics();
                bGr.drawImage(imagen, 0, 0, null);
                bGr.dispose();

                // Rotar la imagen 90 grados
                int anchoImagen = imagenBufferizada.getWidth();
                int altoImagen = imagenBufferizada.getHeight();
                BufferedImage imagenRotada = new BufferedImage(altoImagen, anchoImagen, imagenBufferizada.getType());

                AffineTransform transformacion = new AffineTransform();
                transformacion.translate(altoImagen / 2.0, anchoImagen / 2.0);
                transformacion.rotate(Math.toRadians(90));
                transformacion.translate(-anchoImagen / 2.0, -altoImagen / 2.0);

                AffineTransformOp operacion = new AffineTransformOp(transformacion, AffineTransformOp.TYPE_BILINEAR);
                operacion.filter(imagenBufferizada, imagenRotada);

                // Escalar la imagen rotada para que se ajuste al tamaño del botón
                Image imagenEscalada = imagenRotada.getScaledInstance(anchoBoton, altoBoton, Image.SCALE_SMOOTH);
                etiquetaProducto.setIcon(new ImageIcon(imagenEscalada));
            }
        }
    }
}