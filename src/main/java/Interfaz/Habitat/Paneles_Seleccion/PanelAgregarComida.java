package Interfaz.Habitat.Paneles_Seleccion;

import Interfaz.Animal_Y_Comida.AnimalGrafico;
import Interfaz.Habitat.HabitatGrafico;
import Logica.Animales.Leon;
import Logica.Animales.Pinguino;
import Logica.Animales.Vaca;
import Logica.Comida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelAgregarComida extends JPanel {

    private final Color backgroundColor;
    private final Color btnColor;
    private final HabitatGrafico habitatGrafico;

    public PanelAgregarComida(Color backgroundColor, Color btnColor, HabitatGrafico habitatGrafico) {

        this.backgroundColor = backgroundColor;
        this.btnColor = btnColor;
        this.habitatGrafico = habitatGrafico;

        this.setBounds(50, 10, 1000, 190);
        this.setBackground(backgroundColor);

        Comida[] comidaStr = Comida.values();

        this.setLayout(null);

        int padding = 10;
        int ancho = 200;
        int margen = (985 - (ancho + padding)*comidaStr.length)/2 ;
        for (int i = 0; i < comidaStr.length; i++) {
            JButton btn = agregarBotones(comidaStr[i].name());
            btn.setBounds(margen + padding*i + ancho*i, 10, ancho,200);

            this.add(btn);
        }
    }

    private JButton agregarBotones(String animal){
        JButton btn = new JButton(animal);
        btn.setBackground(btnColor);

        btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
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

        return btn;
    }
}
