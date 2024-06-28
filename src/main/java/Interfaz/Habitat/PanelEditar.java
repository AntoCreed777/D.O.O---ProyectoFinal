package Interfaz.Habitat;

import Interfaz.Habitat.Paneles_Seleccion.PanelAgregarAccesorio;
import Interfaz.Habitat.Paneles_Seleccion.PanelAgregarAnimal;
import Interfaz.Habitat.Paneles_Seleccion.PanelAgregarComida;
import Interfaz.Habitat.Paneles_Seleccion.PanelSeleccion;

import javax.swing.*;
import java.awt.*;
import java.lang.Boolean;

public class PanelEditar extends JPanel{
    private JPanel panelSeleccion;
    private final PanelAgregarAnimal panelAgregarAnimal;
    private final PanelAgregarAccesorio panelAgregarAccesorio;
    private final PanelAgregarComida panelAgregarComida;

    private final HabitatGrafico habitatGrafico;


    public PanelEditar(HabitatGrafico habitatGrafico) {

        Color backgroundColor = habitatGrafico.getHabitat().getEditPanelColor();

        this.setBackground(backgroundColor);
        this.setBounds(0, 420, 1100, 250);
        this.setLayout(null);

        this.habitatGrafico = habitatGrafico;

        panelAgregarAnimal = new PanelAgregarAnimal(habitatGrafico);
        panelAgregarAccesorio = new PanelAgregarAccesorio(habitatGrafico);
        panelAgregarComida = new PanelAgregarComida(habitatGrafico);
        panelSeleccion = new PanelSeleccion(habitatGrafico.getHabitat(), this);

        mostrarPanelSeleccion(true);
    }

    public void mostrarPanelSeleccion(Boolean mostrar){
        if(mostrar){this.add(panelSeleccion);}
        else {this.remove(panelSeleccion);}
        this.repaint();
    }

    /*
    * Funcion para mostrar o esconder el panel para elegir cual animal agregar
    * @param Boolean mostrar
    * */

    public void mostrarPanelAgregarAnimal(Boolean mostrar){
        if(mostrar){this.add(panelAgregarAnimal);}
        else {this.remove(panelAgregarAnimal);}
        this.repaint();
    }

    public void mostrarPanelAgregarAccesorio(Boolean mostrar){
        if(mostrar){this.add(panelAgregarAccesorio);}
        else {this.remove(panelAgregarAccesorio);}
        this.repaint();
    }

    public void mostrarPanelAgregarComida(Boolean mostrar){
        if(mostrar){this.add(panelAgregarComida);}
        else {this.remove(panelAgregarComida);}
        this.repaint();
    }


    public HabitatGrafico getHabitatGrafico(){return habitatGrafico;}
}
