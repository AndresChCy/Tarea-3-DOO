package Vistas;

import Modelo.Expendedor;
import Modelo.Comprador;


import javax.swing.JPanel;
import java.awt.*;

/**
 * La clase PanelPrincipal representa el panel principal de la interfaz de usuario.
 * Contiene un panel para el expendedor y un panel para el comprador.
 */
public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;
    private Expendedor expendedor;

    /**
     * Constructor de la clase PanelPrincipal.
     * Inicializa el panel principal, el panel del expendedor y el panel del comprador.
     */
    public PanelPrincipal() {
        // Inicializar el expendedor con una capacidad predeterminada de 4 productos
        expendedor = new Expendedor(1);

        // Configurar el diseño del panel principal como GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Permitir que los componentes se expandan
        gbc.weightx = 1.0; // Permitir expansión horizontal
        gbc.weighty = 1.0; // Permitir expansión vertical
        Comprador comprador = new Comprador();


        // Crear e inicializar el panel del expendedor y el panel del comprador
        com = new PanelComprador(comprador);
        exp = new PanelExpendedor(expendedor,comprador,com);


        // Establecer el color de fondo del panel principal como negro
        this.setBackground(Color.black);

        // Agregar el panel del expendedor al lado izquierdo del panel principal
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.6; // Relación de expansión horizontal 60%
        this.add(exp, gbc);

        // Agregar el panel del comprador al lado derecho del panel principal
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.4; // Relación de expansión horizontal 40%
        this.add(com, gbc);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        com.paintComponent(g);
        exp.paintComponent(g);
    }
}