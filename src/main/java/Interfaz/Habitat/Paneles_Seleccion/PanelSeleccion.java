package Interfaz.Habitat.Paneles_Seleccion;

import Interfaz.BotonHabitat;
import Interfaz.Habitat.HabitatGrafico;
import Interfaz.Habitat.PanelEditar;
import Logica.Habitat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Panel que contiene los botones para seleccionar la accion que se quiere hacer dentro del habitat
 */
public class PanelSeleccion extends JPanel {
    private final PanelEditar panelEditar;
    private final Color btnColor;
    private final HabitatGrafico habitatGrafico;

    /**
     *Contructor en donde se inician variables , se configura el panel y se agregan los botones
     * para seleccionar lo que se desea hacer
     * @param habitat       Habitat al que pertenece este panel y sobre el que puede actuar
     * @param panelEditar   Panel en donde se muestran todos los demas paneles para seleccionar acciones
     */
    public PanelSeleccion(HabitatGrafico habitat, PanelEditar panelEditar) {
        this.habitatGrafico = habitat;

        this.setBounds(50,10,1000, 190);
        this.setBackground(habitat.getHabitat().getEditPanelColor());
        this.setLayout(new GridLayout(1, 3, 10, 0));

        this.panelEditar = panelEditar;
        this.btnColor = habitat.getHabitat().getBtnColor();

        this.add(btnComida());
        this.add(btnAnimal());
        this.add(btnAccesorio());
        this.add(btnEliminar());
    }

    /**
     * Creacion del boton para agregar animales
     * @return  Se retorna al boton que se creo
     */
    private JButton btnAnimal(){
        JButton btnAnimal = new JButton("Agregar animal");
        btnAnimal.setBackground(this.btnColor);

        btnAnimal.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelEditar.mostrarPanelSeleccion(false);
                panelEditar.mostrarPanelAgregarAnimal(true);}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        return btnAnimal;
    }

    /**
     * Creacion del boton para agregar accesorios
     * @return  Se retorna al boton que se creo
     */
    private JButton btnAccesorio(){
        JButton btnAccesorio = new JButton("Agregar accesorio");
        btnAccesorio.setBackground(this.btnColor);
        btnAccesorio.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelEditar.mostrarPanelSeleccion(false);
                panelEditar.mostrarPanelAgregarAccesorio(true);}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        return btnAccesorio;
    }

    /**
     * Creacion del boton para agregar comida
     * @return  Se retorna al boton que se creo
     */
    private JButton btnComida(){
        JButton btnComida = new JButton("Comida");
        btnComida.setBackground(this.btnColor);
        btnComida.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelEditar.mostrarPanelSeleccion(false);
                panelEditar.mostrarPanelAgregarComida(true);}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        return btnComida;
    }

    /**
     * Creacion del boton paraeliminar el habitat
     * @return  Se retorna al boton que se creo
     */
    private JButton btnEliminar(){

        final Action exitAction = new AbstractAction("Exit")
        {
            @Override
            public void actionPerformed(ActionEvent e){

                habitatGrafico.getBotonHabitat().resetHabitat();
                habitatGrafico.dispose();
            }
        };
        JButton btnEliminar = new JButton(exitAction);
        btnEliminar.setText("Eliminar habitat");
        btnEliminar.setBackground(this.btnColor);



        return btnEliminar;
    }
}