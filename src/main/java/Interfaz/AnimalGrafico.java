package Interfaz;

import Logica.Animales.*;

import javax.swing.*;

public class AnimalGrafico implements GeneradorImagen{
    private JLabel label = null;
    private final Animal animal;

    public AnimalGrafico(Animal animal){
        this.animal = animal;

        if(animal instanceof Leon){
            label = GeneradorImagen.ImageLabel("leonPNG",0,0,0,0);
        }

        else if(animal instanceof Pinguino){
            label = GeneradorImagen.ImageLabel("pinguinoPNG",0,0,0,0);
        }

        else if(animal instanceof Vaca){
            label = GeneradorImagen.ImageLabel("vacaPNG",0,0,0,0);
        }
    }

    public void Moverse(){
        this.animal.Moverse();
        label.setBounds(animal.getPosicionX(),animal.getPosicionY(),0,0);
        label.repaint();
    }
}
