package Interfaz.Habitat.Paneles_Seleccion;

import Interfaz.Habitat.PanelEditar;
import Logica.Habitat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelSeleccion extends JPanel {
    private final PanelEditar panelEditar;
    private final Color btnColor;

    public PanelSeleccion(Habitat habitat, PanelEditar panelEditar) {
        this.setBounds(50,10,1000, 190);
        this.setBackground(habitat.getEditPanelColor());
        this.setLayout(new GridLayout(1, 3, 10, 0));

        this.panelEditar = panelEditar;
        this.btnColor = habitat.getBtnColor();

        this.add(btnComida());
        this.add(btnAnimal());
        this.add(btnAccesorio());
        this.add(btnEliminar());
    }

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

    private JButton btnEliminar(){
        JButton btnEliminar = new JButton("Eliminar habitat");
        btnEliminar.setBackground(this.btnColor);

        return btnEliminar;
    }
}
