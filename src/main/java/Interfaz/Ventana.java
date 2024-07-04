package Interfaz;

import javax.swing.*;

/**
 * JFrame principal en donde se muestra el panel donde se selecciona el planeta
 */
public class Ventana extends JFrame{
    private final JPanel panelPrincipal = new PanelPrincipal(this);
    private final JPanel panelTierra = new PanelTierra(this);
    private final JPanel panelMarte = new PanelMarte(this);


    /**
     * Constructor que configura el JFrame y agrega el PanelPrincipal
     */
    public Ventana(){
        this.setTitle("ventana");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // cerrar la aplicacion al apretar x
        this.setSize(1100, 670); // tamaño de la ventana
        this.setResizable(false);

        this.add(panelPrincipal);

        this.setVisible(true);
    }

    /**
     * Funcion para mostrar el panel principal de la aplicacion
     *  @param mostrar Si se desea mostrar o no el panel principal (True or False)
     */
    public void mostrarPanelPrincipal(Boolean mostrar){
        panelPrincipal.setVisible(mostrar);
        this.repaint();
    }

    /**
     * Funcion para mostrar el panel del planeta tierra
     *  @param mostrar Si se desea mostrar o no el panel de la Tierra (True or False)
     */
    public void mostrarPanelTierra(Boolean mostrar){
        if(mostrar){this.add(panelTierra);}
        else {this.remove(panelTierra);}
        this.repaint();
    }

    /**
     * Funcion para mostrar el panel del planeta marte
     *  @param mostrar Si se desea mostrar o no el panel de Marte (True or False)
     */
    public void mostrarPanelMarte(Boolean mostrar){
        if(mostrar){this.add(panelMarte);}
        else {this.remove(panelMarte);}
        this.repaint();
    }

    /**
     * Funcion para devolver la instancia del panelPrincipal
     * @return Retorna la instancia del PanelPrincipal
     */
    public JPanel getPanelPrincipal(){return panelPrincipal;}
}
