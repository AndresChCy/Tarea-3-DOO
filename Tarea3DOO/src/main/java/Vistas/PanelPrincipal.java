package Vistas;
import Modelo.Expendedor;

import javax.swing.JPanel;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;
    private Expendedor expendedor;

    public PanelPrincipal() {
        expendedor = new Expendedor(4);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Permitir que los componentes se expandan
        gbc.weightx = 1.0; // Permitir expansión horizontal
        gbc.weighty = 1.0; // Permitir expansión vertical

        exp = new PanelExpendedor(expendedor);
        com = new PanelComprador();

        this.setBackground(Color.white);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.6; // Relación de expansión horizontal
        this.add(exp, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.4; // Relación de expansión horizontal
        this.add(com, gbc);
    }
}