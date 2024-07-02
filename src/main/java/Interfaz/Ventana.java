package Interfaz;

import javax.swing.*;


public class Ventana extends JFrame{

    private final JPanel panelPrincipal = new PanelPrincipal(this);
    private final JPanel panelTierra = new PanelTierra();
    private JPanel panelMarte;

    public Ventana(){

        this.setTitle("ventana");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // cerrar la aplicacion al apretar x
        this.setSize(1100, 670); // tamaño de la ventana
        this.setResizable(false);

        panelTierra.setVisible(false);
        this.add(panelPrincipal);

        this.setVisible(true);
    }

    public void mostrarPanelPrincipal(Boolean mostrar){
        if(mostrar) {
            this.add(panelPrincipal);
            panelPrincipal.setVisible(true);
        } else {
            this.remove(panelPrincipal);
            panelPrincipal.setVisible(false);
        }
        this.repaint();
    }

    public void mostrarPanelTierra(Boolean mostrar){

        if(mostrar){
            this.add(panelTierra);
            panelTierra.setVisible(true);
        } else {
            this.remove(panelTierra);
            panelTierra.setVisible(true);
        }
        this.repaint();
    }

    public void mostrarPanelMarte(Boolean mostrar){

        if(mostrar){
            this.add(panelMarte);
            panelMarte.setVisible(true);
        } else {
            this.remove(panelMarte);
            panelMarte.setVisible(true);
        }
        this.repaint();
    }
}
