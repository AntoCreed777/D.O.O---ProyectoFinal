package Interfaz;

import Interfaz.Habitat.HabitatGrafico;
import Logica.*;
import Logica.TipoHabitats.HabitatMarte;
import Logica.TipoHabitats.HabitatTierra;

import javax.swing.*;

/**
 * JFrame principal en donde se muestra al Zoo
 */
public class Ventana extends  JFrame{

    /**
     * Constructor que configura el JFrame y agrega el PanelPrincipal
     */
    public Ventana(){
        this.setTitle("ventana");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // cerrar la aplicacion al apretar x
        this.setSize(1100, 670); // tamaño de la ventana

        PanelPrincipal panel = new PanelPrincipal();
        this.setContentPane(panel);

        this.setVisible(true);
    }

    /**
     * Funcion para agregar habitats si se aprieta un boton
     */
    public void apretarHabitat(){
        Habitat tierra = new HabitatTierra();
        Habitat marte = new HabitatMarte();
        HabitatGrafico habitat = new HabitatGrafico(marte);
    }
}
