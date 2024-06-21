package Interfaz.Animal_Y_Comida;

import Interfaz.GeneradorImagen;
import Logica.Animales.*;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class AnimalGrafico implements GeneradorImagen, Runnable{
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

        animal.setAltoImg(height);
        animal.setAnchoImg(width);
    }

    @Override
    public void run() {
        try {
            while (true) {
                //Proceso de movimiento del Animal
                this.animal.Moverse();
                label.setBounds(animal.getPosicionX(),animal.getPosicionY(),width,height);
                this.animal.getPanelHabitat().repaint();

                //Zona en que alcanza la comida el animal (Su hitbox)
                Rectangle rectangleA = this.label.getBounds();

                //Lista de la comida disponible dentro del habitat
                List<ComidaGrafica> comidas = this.animal.getPanelHabitat().getContenidoComida();

                synchronized(comidas){
                    Iterator<ComidaGrafica> iterator = comidas.iterator();
                    while(iterator.hasNext()){
                        ComidaGrafica comida = iterator.next();
                        Rectangle rectangleC = comida.getLabel().getBounds();
                        if(rectangleC.intersects(rectangleA)){
                            this.animal.Comer(comida.getComida());  //Come su comida
                            this.animal.getPanelHabitat().remove(comida.getLabel());
                            iterator.remove();
                            this.animal.getPanelHabitat().repaint();
                            break;
                        }
                    }
                }

                Thread.sleep(10);
            }
        }
        catch (InterruptedException e) {e.printStackTrace();}
    }

    public JLabel getLabel(){return this.label;}
}
