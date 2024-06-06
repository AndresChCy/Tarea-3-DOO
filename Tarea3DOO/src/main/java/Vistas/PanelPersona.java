package Vistas;

import Modelo.Comprador;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Imagen del comprador
 */
public class PanelPersona extends JPanel {
    private BufferedImage imagenPersona;
    private PanelMano panelMano;

    public PanelPersona(Comprador comprador) {
        setOpaque(false);
        try {
            imagenPersona = ImageIO.read(getClass().getResource("/Comprador.png"));
        } catch (IOException ex) {
            // Manejar cualquier error de carga de imagen
            System.out.println("Error al cargar la imagen de la persona: " + ex.getMessage());
        }

        panelMano = new PanelMano(comprador);
        this.add(panelMano);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenPersona != null) {
            int anchoPanel = getWidth();
            int altoPanel = getHeight();

            int anchoImagenPersona = imagenPersona.getWidth();
            int altoImagenPersona = imagenPersona.getHeight();

            float relacionAspecto = (float) anchoImagenPersona / altoImagenPersona;

            int nuevoAncho = anchoPanel;
            int nuevoAlto = (int) (anchoPanel / relacionAspecto);

            if (nuevoAlto > altoPanel) {
                nuevoAlto = altoPanel;
                nuevoAncho = (int) (altoPanel * relacionAspecto);
            }

            // Centrar la imagen en el panel
            int x = (anchoPanel - nuevoAncho) / 2;
            int y = (altoPanel - nuevoAlto) / 2;

            // Dibujar la imagen escalada
            g.drawImage(imagenPersona, x, y, nuevoAncho, nuevoAlto, this);

            // Calcular posiciones y dimensiones de panelMano (esto es solo un ejemplo)
            int anchoMano = (int) (nuevoAncho * 0.3333333);
            int altoMano = (int) (nuevoAlto * 0.166);
            int posXMano = x;
            int posYMano = y + (int) (nuevoAlto * 0.4);

            panelMano.setBounds(posXMano, posYMano, anchoMano, altoMano);
        }
    }
}
