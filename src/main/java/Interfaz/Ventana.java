package Interfaz;

import javax.swing.*;


public class Ventana extends JFrame{
/**
 * JFrame principal en donde se muestra el panel donde se selecciona el planeta
 */


    private final JPanel panelPrincipal = new PanelPrincipal(this);
    private final JPanel panelTierra = new PanelTierra(this);
    private JPanel panelMarte = new PanelMarte(this);


    /**
     * Constructor que configura el JFrame y agrega el PanelPrincipal
     */
    public Ventana(){

        this.setTitle("ventana");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // cerrar la aplicacion al apretar x
        this.setSize(1100, 670); // tamaño de la ventana
        this.setResizable(false);

        panelTierra.setVisible(false);
        panelMarte.setVisible(false);
        this.add(panelPrincipal);

        this.setVisible(true);
    }

    /*
     * Funcion para mostrar el panel principal de la aplicacion
     *  @param Boolean mostrar
     */

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

    /*
     * Funcion para mostrar el panel del planeta tierra
     *  @param Boolean mostrar
     */
    public void mostrarPanelTierra(Boolean mostrar){

        if(mostrar){
            this.add(panelTierra);
            panelTierra.setVisible(true);

        } else {
            this.remove(panelTierra);
            panelTierra.setVisible(true);
        }
        this.repaint();
        panelTierra.repaint();
    }

    /*
     * Funcion para mostrar el panel del planeta marte
     *  @param Boolean mostrar
     */
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

    /*
     * Funcion para devolver la instancia del panelPrincipal
     * returns JPanel
     */
    public JPanel getPanelPrincipal(){return panelPrincipal;}
}
