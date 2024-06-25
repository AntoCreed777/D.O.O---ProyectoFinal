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
    private final Color btnColor = new Color(0xFAF3DD);
    private final Color backgroundColor = new Color(0x68B0AB);
    private final HabitatGrafico habitatGrafico;


    public PanelEditar(HabitatGrafico habitatGrafico) {
        this.setBackground(backgroundColor);
        this.setBounds(0, 420, 1100, 250);
        this.setLayout(null);

        this.habitatGrafico = habitatGrafico;

        panelAgregarAnimal = new PanelAgregarAnimal(backgroundColor, btnColor, habitatGrafico);
        panelAgregarAccesorio = new PanelAgregarAccesorio(backgroundColor, btnColor, habitatGrafico);
        panelAgregarComida = new PanelAgregarComida(backgroundColor, btnColor, habitatGrafico);
        panelSeleccion = new PanelSeleccion(backgroundColor,btnColor, this);

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
