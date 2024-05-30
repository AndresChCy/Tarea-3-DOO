package Vistas;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class PanelExpendedor extends JPanel {
    private BufferedImage maquinaCerrada;
    private BufferedImage maquinaAbierta;
    private BufferedImage maquinaActual;
    private BufferedImage deposito;

    private ArrayList<Rectangle> areaDepositos = new ArrayList<>();
    private Rectangle areaZonaExtraccion;

    public PanelExpendedor() {
        // Establecer el color de fondo del panel
        this.setBackground(new java.awt.Color(30, 120, 120));
        try {
            // Cargar las imágenes de la máquina cerrada, abierta y del depósito
            maquinaCerrada = ImageIO.read(getClass().getResource("/Máquina_Cerrada.png"));
            maquinaAbierta = ImageIO.read(getClass().getResource("/Máquina_Abierta.png"));
            maquinaActual = maquinaCerrada;
            deposito = ImageIO.read(getClass().getResource("/Depósito.png"));
        } catch (IOException ex) {
            System.out.println("Error al cargar imagen");
        }

        // Agregar un listener para el movimiento del ratón
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                if (areaZonaExtraccion != null && areaZonaExtraccion.contains(x, y)) {
                    maquinaActual = maquinaAbierta;
                } else {
                    maquinaActual = maquinaCerrada;
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // Márgenes
        int marginTop = 30;
        int marginBottom = 50;
        int totalMargin = marginTop + marginBottom;

        // Proporciones de la máquina
        int maquinaHeight = panelHeight - totalMargin;
        int maquinaWidth = panelWidth * 70 / 100; // reducir el ancho para dejar espacio a la derecha
        int maquinaX = 10; // ligeramente desplazado hacia la izquierda
        int maquinaY = marginTop;

        // Proporciones de los depósitos
        int ventanaWidth = maquinaWidth * 75 / 100;
        int ventanaHeight = maquinaHeight * 70 / 100;
        int ventanaX = maquinaX + (maquinaWidth - ventanaWidth) / 2;
        int ventanaY = maquinaY + 20;

        int depositoWidth = ventanaWidth;
        int depositoHeight = ventanaHeight / 5;

        areaDepositos.clear();
        for (int i = 0; i < 5; i++) {
            int depositoX = ventanaX;
            int depositoY = ventanaY + i * depositoHeight;
            areaDepositos.add(new Rectangle(depositoX, depositoY, depositoWidth, depositoHeight));
        }

        // Proporciones del área de extracción
        int zonaExtraccionWidth = ventanaWidth * 90 / 100;
        int zonaExtraccionHeight = maquinaHeight * 10 / 100;
        int zonaExtraccionX = maquinaX + (maquinaWidth - zonaExtraccionWidth) / 2;
        int zonaExtraccionY = maquinaY + maquinaHeight - zonaExtraccionHeight - 45;

        areaZonaExtraccion = new Rectangle(zonaExtraccionX, zonaExtraccionY, zonaExtraccionWidth, zonaExtraccionHeight);

        // Dibujar el fondo de la máquina
        g.setColor(new java.awt.Color(180, 30, 30));
        g.fillRect(maquinaX, maquinaY, maquinaWidth, maquinaHeight);

        // Dibujar los depósitos
        for (Rectangle areaDeposito : areaDepositos) {
            if (deposito != null) {
                g.drawImage(deposito.getScaledInstance(areaDeposito.width, areaDeposito.height, Image.SCALE_SMOOTH), areaDeposito.x, areaDeposito.y, this);
            }
        }

        // Dibujar el estado actual del área de extracción
        if (maquinaActual != null) {
            g.drawImage(maquinaActual.getScaledInstance(zonaExtraccionWidth, zonaExtraccionHeight, Image.SCALE_SMOOTH), zonaExtraccionX, zonaExtraccionY, this);
        }
    }
}