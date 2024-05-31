package Vistas;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelMaquina2 extends JPanel {
    private BufferedImage imagenFondoMaquina2;

    public PanelMaquina2() {
        try {
            imagenFondoMaquina2 = ImageIO.read(getClass().getResource("/Máquina_Fondo_2.png"));
        } catch (IOException ex) {
            System.out.println("Error al cargar imagen de fondo de la segunda máquina");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondoMaquina2 != null) {
            int anchoPanel = getWidth();
            int altoPanel = getHeight();
            g.drawImage(imagenFondoMaquina2.getScaledInstance(anchoPanel, altoPanel, Image.SCALE_SMOOTH), 0, 0, this);
        }
    }
}
