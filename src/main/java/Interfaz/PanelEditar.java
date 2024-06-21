package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.Boolean;

public class PanelEditar extends JPanel{
    private JPanel panelSeleccion;
    private JPanel panelAgregarAnimal = null;
    private final Color btnColor = new Color(0xFAF3DD);
    private final Color backgroundColor = new Color(0x68B0AB);


    public PanelEditar() {

        this.setBackground(backgroundColor);
        this.setBounds(0, 420, 1085, 220);
        this.setLayout(null);

        crearPanelSeleccion();
        crearPanelAgregarAnimal();

        mostrarPanelSeleccion(true);

    }

    public void crearPanelSeleccion(){

        panelSeleccion = new JPanel(new GridLayout(1, 0, 10,0));
        panelSeleccion.setBounds(50,10,985, 190);
        panelSeleccion.setBackground(backgroundColor);


        JButton btnAnimal = new JButton("Agregar animal");
        btnAnimal.setBackground(btnColor);

        btnAnimal.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarPanelSeleccion(false);
                mostrarPanelAgregarAnimal(true);}
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
        btnAccesorio.setBackground(btnColor);

        JButton btnEliminar = new JButton("Eliminar habitat");
        btnEliminar.setBackground(btnColor);

        panelSeleccion.add(btnAnimal);
        panelSeleccion.add(btnAccesorio);
        panelSeleccion.add(btnEliminar);

    }


    public void crearPanelAgregarAnimal(){

        panelAgregarAnimal = new JPanel(new GridLayout(1, 0, 10,0));
        panelAgregarAnimal.setBounds(50, 10, 985, 190);
        panelAgregarAnimal.setBackground(backgroundColor);

        String[] animalstr = {"vaca", "leon", "pinguino"};
        for (String s : animalstr) {
            JButton btn = new JButton(s);
            btn.setBackground(btnColor);


            panelAgregarAnimal.add(btn);
        }
    }


    public void mostrarPanelSeleccion(Boolean val){

        if(val){this.add(panelSeleccion);}
        else {this.remove(panelSeleccion);}

        this.repaint();
    }


    /*
    * Funcion para mostrar o esconder el panel para elegir cual animal agregar
    * @param Boolean val
    * */

    public void mostrarPanelAgregarAnimal(Boolean val){

        this.repaint();
        if(val){this.add(panelAgregarAnimal);}
        else {this.remove(panelAgregarAnimal);}
        
        this.repaint();
    }
}
