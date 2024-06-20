package Interfaz;

import Logica.Animales.*;

import javax.swing.*;

public class AnimalGrafico implements GeneradorImagen{
    private JLabel label = null;
    private int width;
    private int height;
    private final Animal animal;

    public AnimalGrafico(Animal animal){
        this.animal = animal;

        if(animal instanceof Leon){
            width = 0;
            height = 0;
            label = GeneradorImagen.ImageLabel("leonPNG",0,0,width,height);
        }

        else if(animal instanceof Pinguino){
            width = 0;
            height = 0;
            label = GeneradorImagen.ImageLabel("pinguinoPNG",0,0,width,height);
        }

        else if(animal instanceof Vaca){
            width = 100;
            height = 100;
            label = GeneradorImagen.ImageLabel("src/main/java/Interfaz/imagenes/Vaca.png",animal.getPosicionX(),animal.getPosicionY(),width,height);
        }
    }

    public void Moverse(){
        this.animal.Moverse();
        label.setBounds(animal.getPosicionX(),animal.getPosicionY(),width,height);
        this.animal.getPanelHabitat().repaint();
    }

    public JLabel getLabel(){return this.label;}
}
