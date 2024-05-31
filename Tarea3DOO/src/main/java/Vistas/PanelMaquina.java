package Vistas;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelMaquina extends JPanel {
    private BufferedImage maquinaFondo;

    public PanelMaquina() {
        try {
            maquinaFondo = ImageIO.read(getClass().getResource("/Máquina_Fondo.png"));
        } catch (IOException ex) {
            System.out.println("Error al cargar imagen de fondo de la máquina");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (maquinaFondo != null) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            g.drawImage(maquinaFondo.getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH), 0, 0, this);
        }
    }
}
