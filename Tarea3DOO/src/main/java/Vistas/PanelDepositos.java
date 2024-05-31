package Vistas;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class PanelDepositos extends JPanel {
    private BufferedImage imagenDeposito;
    private ArrayList<BufferedImage> depositos;

    public PanelDepositos() {
        try {
            imagenDeposito = ImageIO.read(getClass().getResource("/Depósito.png"));
        } catch (IOException ex) {
            System.out.println("Error al cargar imagen de depósito");
        }
        depositos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            depositos.add(imagenDeposito);
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
        }
    }
}