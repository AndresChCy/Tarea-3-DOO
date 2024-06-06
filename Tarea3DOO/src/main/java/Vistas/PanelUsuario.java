package Vistas;

import Modelo.Comprador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import Modelo.CreaMonedas;
import Modelo.Moneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.management.MemoryNotificationInfo;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;

public class PanelUsuario extends JPanel {
    private PanelMonedas panelMonedas;
    private PanelBotonConsumir panelBotonConsumir;


    public PanelUsuario(PanelBolsillo bolsillo,Comprador comprador,PanelComprador com) {
        setLayout(null);
        panelMonedas = new PanelMonedas(bolsillo, comprador);
        this.add(panelMonedas);
        panelBotonConsumir = new PanelBotonConsumir(com,comprador);
        this.add(panelBotonConsumir);

        // Agregar un ComponentAdapter para manejar cambios de tamaño en el panel
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                actualizarDiseño();
            }
        });
    }

    /**
     * Método para actualizar el diseño de los componentes del panel de usuario.
     */
    private void actualizarDiseño() {
        int anchoPanel = getWidth();
        int altoPanel = getHeight();

        int margenX = (int) (anchoPanel * 0.05);
        int altoMonedas = altoPanel;
        int anchoMonedas = altoMonedas + margenX;
        int anchoBoton = anchoPanel - anchoMonedas;
        int altoBoton = altoPanel;

        int posXMonedas = anchoBoton;

        panelMonedas.setBounds(posXMonedas, 0, anchoMonedas, altoMonedas);
        panelBotonConsumir.setBounds(0, 0, anchoBoton, altoBoton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        actualizarDiseño(); // Asegurar que el diseño se actualice correctamente
    }


 /*   public void BotonesMoneda(JPanel panel){
        for(CreaMonedas m : CreaMonedas.values()){
            JLabel iconoM = new JLabel(SintetizadorVisual.ObtenerImagen(m.crearMoneda(0)));
            iconoM.addMouseListener(new GeneraMoneda(m));
            panel.add(iconoM);
        }
    }
    private class GeneraMoneda implements MouseListener{
        private static int contador = 1;
        private CreaMonedas generador;
        public GeneraMoneda(CreaMonedas m){
            this.generador = m;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            Moneda m = generador.crearMoneda(contador);
            comprador.addMonedaBolsillo(m);
            System.out.println("Se genero una: " + m.toString());
            contador++;
            bolsillo.repaint();

        }
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }
*/

}
