package Vistas;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;


public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal() {
        setLayout(null); // Utilizar layout nulo para posiciones absolutas
        exp = new PanelExpendedor();
        com = new PanelComprador();
        this.setBackground(Color.white);
        this.add(exp);
        this.add(com);

    }
}