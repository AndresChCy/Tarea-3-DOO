package Vistas;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelZonaExtraccion extends JPanel {
    private BufferedImage imagenMaquinaCerrada;
    private BufferedImage imagenMaquinaAbierta;
    private BufferedImage imagenMaquinaActual;

    public PanelZonaExtraccion() {
        try {
            imagenMaquinaCerrada = ImageIO.read(getClass().getResource("/Máquina_Cerrada.png"));
            imagenMaquinaAbierta = ImageIO.read(getClass().getResource("/Máquina_Abierta.png"));
            imagenMaquinaActual = imagenMaquinaCerrada;
        } catch (IOException ex) {
            System.out.println("Error al cargar imagen de zona de extracción");
        }

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                imagenMaquinaActual = imagenMaquinaAbierta;
                repaint();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                imagenMaquinaActual = imagenMaquinaCerrada;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int anchoPanel = getWidth();
        int altoPanel = getHeight();
        g.drawImage(imagenMaquinaActual.getScaledInstance(anchoPanel, altoPanel, Image.SCALE_SMOOTH), 0, 0, this);
    }
}
