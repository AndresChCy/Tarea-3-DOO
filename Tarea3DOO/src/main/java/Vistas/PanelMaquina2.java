package Vistas;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelMaquina2 extends JPanel {
    private BufferedImage maquinaFondo2;

    public PanelMaquina2() {
        try {
            maquinaFondo2 = ImageIO.read(getClass().getResource("/Máquina_Fondo_2.png"));
        } catch (IOException ex) {
            System.out.println("Error al cargar imagen de fondo de la segunda máquina");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (maquinaFondo2 != null) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            g.drawImage(maquinaFondo2.getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH), 0, 0, this);
        }
    }
}
