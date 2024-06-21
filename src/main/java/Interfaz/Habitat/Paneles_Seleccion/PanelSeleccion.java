package Interfaz.Habitat.Paneles_Seleccion;

import Interfaz.Habitat.PanelEditar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelSeleccion extends JPanel {
    private final PanelEditar panelEditar;

    public PanelSeleccion(int backgroundColor, int btnColor, PanelEditar panelEditar) {
        this.setBounds(50,10,1000, 190);
        this.setBackground(new Color(backgroundColor));
        this.setLayout(new GridLayout(1, 3, 10, 0));

        this.panelEditar = panelEditar;

        JButton btnAnimal = new JButton("Agregar animal");
        btnAnimal.setBackground(new Color(btnColor));

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

        JButton btnAccesorio = new JButton("Agregar accesorio");
        btnAccesorio.setBackground(new Color(btnColor));

        JButton btnEliminar = new JButton("Eliminar habitat");
        btnEliminar.setBackground(new Color(btnColor));

        this.add(btnAnimal);
        this.add(btnAccesorio);
        this.add(btnEliminar);

    }
}
