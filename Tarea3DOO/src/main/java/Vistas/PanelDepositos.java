package Vistas;

import Modelo.Expendedor;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * La clase PanelDepositos representa el panel que muestra los depósitos de productos en el expendedor.
 */
public class PanelDepositos extends JPanel {
    private BufferedImage imagenDeposito;
    private Map<String, BufferedImage> imagenesProductos;
    private Expendedor expendedor;
    private String[] productos = {"Fanta", "Sprite", "CocaCola", "Snickers", "Super8"};

    /**
     * Constructor de la clase PanelDepositos.
     * Inicializa el panel de depósitos y carga las imágenes de los productos.
     * @param expendedor El Expendedor asociado al panel.
     */
    public PanelDepositos(Expendedor expendedor) {
        // Asignar el objeto Expendedor
        this.expendedor = expendedor;
        // Inicializar el mapa de imágenes de productos
        imagenesProductos = new HashMap<>();
        try {
            // Cargar la imagen del depósito
            imagenDeposito = ImageIO.read(getClass().getResource("/Depósito.png"));
            // Cargar las imágenes de los productos y almacenarlas en el mapa
            imagenesProductos.put("Fanta", ImageIO.read(getClass().getResource("/Fanta.png")));
            imagenesProductos.put("Sprite", ImageIO.read(getClass().getResource("/Sprite.png")));
            imagenesProductos.put("CocaCola", ImageIO.read(getClass().getResource("/CocaCola.png")));
            imagenesProductos.put("Snickers", ImageIO.read(getClass().getResource("/Snickers.png")));
            imagenesProductos.put("Super8", ImageIO.read(getClass().getResource("/Super8.png")));
        } catch (IOException ex) {
            // Manejar cualquier error de carga de imágenes
            System.out.println("Error al cargar imágenes: " + ex.getMessage());
        }
    }

    /**
     * Método sobrescrito para dibujar los componentes y la interfaz del panel de depósitos.
     * @param g El contexto gráfico en el que se dibujan los componentes.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Obtener las dimensiones del panel
        int anchoPanel = getWidth();
        int altoPanel = getHeight();
        // Calcular la altura de cada depósito
        int altoDeposito = altoPanel / 5;

        // Iterar sobre los depósitos y dibujarlos en el panel
        for (int i = 0; i < 5; i++) {
            int y = i * altoDeposito;
            // Dibujar la imagen del depósito
            g.drawImage(imagenDeposito.getScaledInstance(anchoPanel, altoDeposito, Image.SCALE_SMOOTH), 0, y, this);

            // Obtener la cantidad de productos en el depósito actual
            int cantidadProductos = expendedor.getCantidadProductos(i);
            // Calcular el ancho de cada imagen de producto en el depósito
            int anchoProducto = anchoPanel / 6;

            // Iterar sobre los productos en el depósito y dibujar sus imágenes
            for (int j = 0; j < cantidadProductos && j < 6; j++) {
                BufferedImage productoImg = imagenesProductos.get(productos[i]);
                // Verificar si la imagen del producto existe y dibujarla
                if (productoImg != null) {
                    g.drawImage(productoImg.getScaledInstance(anchoProducto, altoDeposito, Image.SCALE_SMOOTH),
                            j * anchoProducto, y, this);
                }
            }
        }
    }
}
