package Interfaz.Habitat.Paneles_Seleccion;

import Interfaz.Animal_Y_Comida.AnimalGrafico;
import Interfaz.GeneradorImagen;
import Interfaz.Habitat.HabitatGrafico;
import Logica.Animales.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelAgregarAnimal extends JPanel {
    private final Color backgroundColor;
    private final Color btnColor;
    private final HabitatGrafico habitatGrafico;

    public PanelAgregarAnimal(Color backgroundColor, Color btnColor, HabitatGrafico habitatGrafico) {
        this.backgroundColor = backgroundColor;
        this.btnColor = btnColor;
        this.habitatGrafico = habitatGrafico;

        this.setBounds(50, 10, 1000, 190);
        this.setBackground(backgroundColor);

        String[] animalstr = {"Vaca", "Leon", "Pinguino"};
        //this.setLayout(new GridLayout(1, animalstr.length, 10, 0));
        this.setLayout(null);

        int padding = 10;
        int ancho = 200;
        int margen = (985 - (ancho + padding)*animalstr.length)/2 ;
        for (int i = 0; i < animalstr.length; i++) {

            ImageIcon img = switch (animalstr[i]) {
                case "Vaca" -> GeneradorImagen.scaledProducto("src/main/java/interfaz/Imagenes/Vaca.png", ancho - 100,120);
                case "Leon" -> GeneradorImagen.scaledProducto("src/main/java/interfaz/Imagenes/Leon.png", ancho - 100,120);
                case "Pinguino" -> GeneradorImagen.scaledProducto("src/main/java/interfaz/Imagenes/Pinguino.png", ancho - 100 ,120);
                default -> null;
            };

            JButton btn = agregarBotones(animalstr[i]);
            btn.setIcon(img);
            btn.setMargin(new Insets(10,5,5, 10));
            btn.setHorizontalTextPosition(JButton.CENTER);
            btn.setVerticalTextPosition(JButton.BOTTOM);
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
                AnimalGrafico animalGrafico = switch (animal) {
                    case "Vaca" -> new AnimalGrafico(new Vaca(habitatGrafico.getPanelHabitat().clickMouse.x, habitatGrafico.getPanelHabitat().clickMouse.y, habitatGrafico.getPanelHabitat()));
                    case "Leon" -> new AnimalGrafico(new Leon(habitatGrafico.getPanelHabitat().clickMouse.x, habitatGrafico.getPanelHabitat().clickMouse.y, habitatGrafico.getPanelHabitat()));
                    case "Pinguino" -> new AnimalGrafico(new Pinguino(habitatGrafico.getPanelHabitat().clickMouse.x, habitatGrafico.getPanelHabitat().clickMouse.y, habitatGrafico.getPanelHabitat()));
                    default -> null;
                };

                if (animalGrafico != null) {habitatGrafico.getPanelHabitat().agregarAnimal(animalGrafico);}
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
