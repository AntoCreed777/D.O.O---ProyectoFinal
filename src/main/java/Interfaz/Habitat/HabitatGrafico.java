package Interfaz.Habitat;

import Interfaz.imagenes.GeneradorImagen;
import Logica.Habitat;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
 * Clase para graficar el habitat
 */
public class HabitatGrafico extends JFrame implements GeneradorImagen {

    private final Habitat habitat;
    private final JToggleButton editBtn;
    private final PanelEditar panelEditar;
    private final PanelHabitat panelHabitat;
    private final Color backgroundColor;

    public HabitatGrafico(Habitat habitat) {
        this.habitat = habitat;
        backgroundColor = habitat.getBackgroundColor();

        this.setSize(new Dimension(1100, 670));
        this.getContentPane().setBackground(backgroundColor);
        this.setLayout(null);
        this.setTitle("Hábitat");
        this.setResizable(false);

        panelHabitat = new PanelHabitat(habitat);
        this.add(panelHabitat);


        // boton de edicion
        editBtn = new JToggleButton("MENU");
        editBtn.setFont(new Font("monospaced", Font.BOLD, 16));
        editBtn.setBackground(new Color(0xFFFFFF));
        editBtn.setBorderPainted(false);
        editBtn.setMargin(new Insets(0,0,0,0));
        editBtn.setBounds(1010,5,70,40);
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
            panelHabitat.ajustarPanel("minimizar");
            panelEditar.setVisible(true);
        }
        else {
            panelHabitat.ajustarPanel("maximizar");

            panelEditar.mostrarPanelAgregarAccesorio(false);
            panelEditar.mostrarPanelAgregarComida(false);
            panelEditar.mostrarPanelAgregarAnimal(false);
            panelEditar.mostrarPanelSeleccion(true);
            panelEditar.setVisible(false);
        }

        this.repaint();
    }

    public PanelHabitat getPanelHabitat(){return panelHabitat;}
    public Habitat getHabitat(){return habitat;}
}





