package Interfaz.Habitat.Paneles_Seleccion;

import Interfaz.Animal_Y_Comida.AnimalGrafico;
import Interfaz.Habitat.HabitatGrafico;
import Logica.Animales.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelAgregarAnimal extends JPanel {
    private final int backgroundColor;
    private final int btnColor;
    private final HabitatGrafico habitatGrafico;

    public PanelAgregarAnimal(int backgroundColor, int btnColor, HabitatGrafico habitatGrafico) {
        this.backgroundColor = backgroundColor;
        this.btnColor = btnColor;
        this.habitatGrafico = habitatGrafico;

        this.setBounds(50, 10, 1000, 190);
        this.setBackground(new Color(backgroundColor));

        String[] animalstr = {"vaca", "leon", "pinguino"};
        this.setLayout(new GridLayout(1, animalstr.length, 10, 0));

        for (String s : animalstr) {
            agregarBotones(s);
        }
    }

    private void agregarBotones(String animal){
        JButton btn = new JButton(animal);
        btn.setBackground(new Color(btnColor));

        btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AnimalGrafico animalGrafico = switch (animal) {
                    case "vaca" -> new AnimalGrafico(new Vaca(0, 0, habitatGrafico.getPanelHabitat()));
                    case "leon" -> new AnimalGrafico(new Leon(0, 0, habitatGrafico.getPanelHabitat()));
                    case "pinguino" -> new AnimalGrafico(new Pinguino(0, 0, habitatGrafico.getPanelHabitat()));
                    default -> null;
                };

                if (animalGrafico != null) {
                    habitatGrafico.getPanelHabitat().agregarAnimal(animalGrafico);
                }

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

        this.add(btn);
    }
}
