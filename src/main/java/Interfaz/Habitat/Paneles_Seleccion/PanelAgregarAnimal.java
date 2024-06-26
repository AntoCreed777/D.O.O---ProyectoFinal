package Interfaz.Habitat.Paneles_Seleccion;

import Interfaz.Animal_Y_Comida.AnimalGrafico;
import Interfaz.GeneradorImagen;
import Interfaz.Habitat.HabitatGrafico;
import Logica.Animales.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelAgregarAnimal extends JPanel {
    private final Color backgroundColor;
    private final Color btnColor;
    private final Color btnMarginColor;
    private final HabitatGrafico habitatGrafico;

    public PanelAgregarAnimal(HabitatGrafico habitatGrafico) {
        this.habitatGrafico = habitatGrafico;
        this.backgroundColor = habitatGrafico.getPlaneta().getEditPanelColor();
        this.btnColor = habitatGrafico.getPlaneta().getBtnColor();
        this.btnMarginColor = habitatGrafico.getPlaneta().getBtnMarginColor();

        this.setBounds(50, 10, 1000, 190);
        this.setBackground(backgroundColor);

        String[] animalstr = {"Vaca", "Leon", "Pinguino"};

        this.setLayout(null);

        int padding = 10;
        int ancho = 200;
        int margen = (985 - (ancho + padding)*animalstr.length)/2 ;
        for (int i = 0; i < animalstr.length; i++) {

            JButton btn = agregarBotones(animalstr[i], ancho);

            btn.setBounds(margen + padding*i + ancho*i, 10, ancho,180);

            this.add(btn);
        }
    }

    private JButton agregarBotones(String animal, int ancho){
        JButton btn = new JButton(animal);

        btn.setBackground(btnColor);
        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.setVerticalTextPosition(JButton.BOTTOM);
        btn.setBorder(new MatteBorder(10,5,10,5, btnMarginColor));
        btn.setBorderPainted(true);

        ImageIcon img = switch (animal) {
            case "Vaca" -> GeneradorImagen.scaledProducto("src/main/java/interfaz/Imagenes/Vaca.png", ancho - 100,100);
            case "Leon" -> GeneradorImagen.scaledProducto("src/main/java/interfaz/Imagenes/Leon.png", ancho - 100,100);
            case "Pinguino" -> GeneradorImagen.scaledProducto("src/main/java/interfaz/Imagenes/Pinguino.png", ancho - 100 ,100);
            default -> null;
        };

        btn.setIcon(img);

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
