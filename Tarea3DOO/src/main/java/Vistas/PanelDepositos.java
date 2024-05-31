package Vistas;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class PanelDepositos extends JPanel {
    private BufferedImage deposito;
    private ArrayList<BufferedImage> depositos;

    public PanelDepositos() {
        try {
            deposito = ImageIO.read(getClass().getResource("/Depósito.png"));
        } catch (IOException ex) {
            System.out.println("Error al cargar imagen de depósito");
        }
        depositos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            depositos.add(deposito);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int depositoHeight = panelHeight / 5;

        for (int i = 0; i < 5; i++) {
            int y = i * depositoHeight;
            g.drawImage(deposito.getScaledInstance(panelWidth, depositoHeight, Image.SCALE_SMOOTH), 0, y, this);
        }
    }
}
