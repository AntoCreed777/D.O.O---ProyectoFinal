package Interfaz.Habitat;

import Interfaz.Animal_Y_Comida.AnimalGrafico;
import Interfaz.Animal_Y_Comida.ComidaGrafica;
import Interfaz.GeneradorImagen;
import Logica.TipoHabitat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Clase para graficar el habitat
 */
public class HabitatGrafico extends JFrame implements GeneradorImagen {

    private final TipoHabitat tipoHabitat;
    private final JToggleButton editBtn;
    private final PanelEditar panelEditar;
    private final PanelHabitat panelHabitat;
    private final int backgroundColor = 0xF6FFEC;

    public HabitatGrafico(TipoHabitat tipo) {
        tipoHabitat = tipo;

        this.setSize(new Dimension(1100, 670));
        this.getContentPane().setBackground(new Color(backgroundColor));
        this.setLayout(null);
        this.setTitle("habitat");
        this.setResizable(true);

        panelHabitat = new PanelHabitat(backgroundColor, tipoHabitat);
        this.add(panelHabitat);


        // boton de edicion
        editBtn = new JToggleButton("edit");
        editBtn.setBackground(new Color(0xFFCBF4FA, true));
        editBtn.setBounds(1020,0,60,30);
        editBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarPanelEditar();
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        this.add(editBtn);


        // panel de edicion
        panelEditar = new PanelEditar(this);
        panelEditar.setVisible(false);
        this.add(panelEditar);

        this.setVisible(true);
    }

    public void mostrarPanelEditar(){
        if(editBtn.isSelected()){
            panelHabitat.minimizarPanel();
            panelEditar.setVisible(true);
        }
        else {
            panelHabitat.maximizarPanel();

            panelEditar.mostrarPanelAgregarAnimal(false);
            panelEditar.mostrarPanelSeleccion(true);
            panelEditar.setVisible(false);
        }

        this.repaint();
    }

    public PanelHabitat getPanelHabitat(){return panelHabitat;}
}





