package Interfaz;

import Interfaz.Habitat.HabitatGrafico;
import Logica.*;
import Logica.TipoHabitats.HabitatMarte;
import Logica.TipoHabitats.HabitatTierra;

import javax.swing.*;
import java.awt.*;


public class Ventana extends  JFrame{

    public Ventana(){
        this.setTitle("ventana");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // cerrar la aplicacion al apretar x
        this.setSize(1100, 670); // tamaño de la ventana

        PanelPrincipal panel = new PanelPrincipal();
        this.setContentPane(panel);


        this.setVisible(true);
    }

}
