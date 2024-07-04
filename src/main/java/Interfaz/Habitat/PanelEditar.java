package Interfaz.Habitat;

import Interfaz.Habitat.Paneles_Seleccion.PanelAgregarAccesorio;
import Interfaz.Habitat.Paneles_Seleccion.PanelAgregarAnimal;
import Interfaz.Habitat.Paneles_Seleccion.PanelAgregarComida;
import Interfaz.Habitat.Paneles_Seleccion.PanelSeleccion;

import javax.swing.*;
import java.awt.*;
import java.lang.Boolean;

/**
 * Clase que representa la zona en el HabitatGrafico en donde se mostraran los paneles que permiten
 * editar el habitat, tambien contiene todos los sub-paneles de edicion
 */
public class PanelEditar extends JPanel{
    private final JPanel panelSeleccion;
    private final PanelAgregarAnimal panelAgregarAnimal;
    private final PanelAgregarAccesorio panelAgregarAccesorio;
    private final PanelAgregarComida panelAgregarComida;

    /**
     * Contructor en donde se inician variables , se configura el panel y se agregan los elementos
     * @param habitatGrafico    Habitat al que pertenece y puede editar
     */
    public PanelEditar(HabitatGrafico habitatGrafico) {

        Color backgroundColor = habitatGrafico.getHabitat().getEditPanelColor();

        this.setBackground(backgroundColor);
        this.setBounds(0, 420, 1100, 250);
        this.setLayout(null);

        panelAgregarAnimal = new PanelAgregarAnimal(habitatGrafico);
        panelAgregarAccesorio = new PanelAgregarAccesorio(habitatGrafico);
        panelAgregarComida = new PanelAgregarComida(habitatGrafico);
        panelSeleccion = new PanelSeleccion(habitatGrafico.getHabitat(), this);

        mostrarPanelSeleccion(true);
    }

    /**
     * Funcion para mostrar o esconder el panel para elegir cual accion realizar
     * (Agregar animales, comida, etc)
     * @param mostrar Booleano que indica si se muestra o no el panel
     */
    public void mostrarPanelSeleccion(Boolean mostrar){
        if(mostrar){this.add(panelSeleccion);}
        else {this.remove(panelSeleccion);}
        this.repaint();
    }

    /**
    * Funcion para mostrar o esconder el panel para elegir cual animal agregar
    * @param mostrar Booleano que indica si se muestra o no el panel
    */
    public void mostrarPanelAgregarAnimal(Boolean mostrar){
        if(mostrar){this.add(panelAgregarAnimal);}
        else {this.remove(panelAgregarAnimal);}
        this.repaint();
    }

    /**
     * Funcion para mostrar o esconder el panel para elegir cual accesorio agregar
     * @param mostrar Booleano que indica si se muestra o no el panel
     */
    public void mostrarPanelAgregarAccesorio(Boolean mostrar){
        if(mostrar){this.add(panelAgregarAccesorio);}
        else {this.remove(panelAgregarAccesorio);}
        this.repaint();
    }

    /**
     * Funcion para mostrar o esconder el panel para elegir cual comida agregar
     * @param mostrar Booleano que indica si se muestra o no el panel
     */
    public void mostrarPanelAgregarComida(Boolean mostrar){
        if(mostrar){this.add(panelAgregarComida);}
        else {this.remove(panelAgregarComida);}
        this.repaint();
    }
}
