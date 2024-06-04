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

public class PanelDepositos extends JPanel {
    private BufferedImage imagenDeposito;
    private Map<String, BufferedImage> imagenesProductos;
    private Expendedor expendedor;
    private String[] productos = {"Fanta", "Sprite", "CocaCola", "Snickers", "Super8"};

    public PanelDepositos(Expendedor expendedor) {
        this.expendedor = expendedor;
        imagenesProductos = new HashMap<>();
        try {
            imagenDeposito = ImageIO.read(getClass().getResource("/Depósito.png"));
            imagenesProductos.put("Fanta", ImageIO.read(getClass().getResource("/Fanta.png")));
            imagenesProductos.put("Sprite", ImageIO.read(getClass().getResource("/Sprite.png")));
            imagenesProductos.put("CocaCola", ImageIO.read(getClass().getResource("/CocaCola.png")));
            imagenesProductos.put("Snickers", ImageIO.read(getClass().getResource("/Snickers.png")));
            imagenesProductos.put("Super8", ImageIO.read(getClass().getResource("/Super8.png")));
        } catch (IOException ex) {
            System.out.println("Error al cargar imágenes: " + ex.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int anchoPanel = getWidth();
        int altoPanel = getHeight();
        int altoDeposito = altoPanel / 5;

        for (int i = 0; i < 5; i++) {
            int y = i * altoDeposito;
            g.drawImage(imagenDeposito.getScaledInstance(anchoPanel, altoDeposito, Image.SCALE_SMOOTH), 0, y, this);

            int cantidadProductos = expendedor.getCantidadProductos(i);
            int anchoProducto = anchoPanel / 6;

            for (int j = 0; j < cantidadProductos && j < 6; j++) {
                BufferedImage productoImg = imagenesProductos.get(productos[i]);
                if (productoImg != null) {
                    g.drawImage(productoImg.getScaledInstance(anchoProducto, altoDeposito, Image.SCALE_SMOOTH),
                            j * anchoProducto, y, this);
                }
            }
        }
    }
}
