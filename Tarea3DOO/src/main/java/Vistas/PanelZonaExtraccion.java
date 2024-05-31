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
    private BufferedImage maquinaCerrada;
    private BufferedImage maquinaAbierta;
    private BufferedImage maquinaActual;

    public PanelZonaExtraccion() {
        try {
            maquinaCerrada = ImageIO.read(getClass().getResource("/Máquina_Cerrada.png"));
            maquinaAbierta = ImageIO.read(getClass().getResource("/Máquina_Abierta.png"));
            maquinaActual = maquinaCerrada;
        } catch (IOException ex) {
            System.out.println("Error al cargar imagen de zona de extracción");
        }

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                maquinaActual = maquinaAbierta;
                repaint();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                maquinaActual = maquinaCerrada;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        g.drawImage(maquinaActual.getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH), 0, 0, this);
    }
}
