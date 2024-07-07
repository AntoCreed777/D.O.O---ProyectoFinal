package Interfaz;

import javax.swing.*;

/**
 * La clase Ventana es el JFrame principal en el que se muestra el mapa con los diferentes paneles
 * donde se selecciona el planeta
 * Esta clase se encarga de configurar y gestionar la ventana principal
 */
public class Ventana extends JFrame{
    private final JPanel panelPrincipal = new PanelPrincipal(this);
    private final JPanel panelTierra = new PanelTierra(this);
    private final JPanel panelMarte = new PanelMarte(this);


    /**
     * Constructor que configura el JFrame y agrega el panel principal a la ventana
     */
    public Ventana(){
        this.setTitle("Zoologico Espacial");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // cerrar la aplicacion al apretar x
        this.setSize(1100, 670); // tamaño de la ventana
        this.setResizable(false);
        ImageIcon iconoVentana = Interfaz.imagenes.GeneradorImagen.scaledProducto("src/main/java/Interfaz/Imagenes/icono_ventana.png", 40,40);
        this.setIconImage(iconoVentana.getImage());
        this.add(panelPrincipal); // Agrega el panel principal a la ventana

        this.setVisible(true);
    }

    /**
     * Funcion para mostrar el panel principal de la aplicacion
     *  @param mostrar true para mostrar el panel principal, false para ocultarlo
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
        this.repaint(); // Refresca la ventana para reflejar los cambios
    }

    /**
     * Funcion para mostrar el panel del planeta marte
     *  @param mostrar Si se desea mostrar o no el panel de Marte (True or False)
     */
    public void mostrarPanelMarte(Boolean mostrar){
        if(mostrar){this.add(panelMarte);}
        else {this.remove(panelMarte);}
        this.repaint(); // Refresca la ventana para reflejar los cambios
    }

    /**
     * Funcion para devolver la instancia del panelPrincipal
     * @return Retorna la instancia del PanelPrincipal
     */
    public JPanel getPanelPrincipal(){return panelPrincipal;}
}
