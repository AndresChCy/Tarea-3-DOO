package Vistas;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelMaquina extends JPanel {
    private BufferedImage imagenFondoMaquina;

    public PanelMaquina() {
        try {
            imagenFondoMaquina = ImageIO.read(getClass().getResource("/Máquina_Fondo.png"));
        } catch (IOException ex) {
            System.out.println("Error al cargar imagen de fondo de la máquina");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondoMaquina != null) {
            int anchoPanel = getWidth();
            int altoPanel = getHeight();
            g.drawImage(imagenFondoMaquina.getScaledInstance(anchoPanel, altoPanel, Image.SCALE_SMOOTH), 0, 0, this);
        }
    }
}
