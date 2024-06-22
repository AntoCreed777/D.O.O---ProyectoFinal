package Interfaz.Animal_Y_Comida;

import Interfaz.GeneradorImagen;
import Logica.Animales.*;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class AnimalGrafico implements GeneradorImagen, Runnable{
    private final String imagen;
    private JLabel label;
    private final int widthMax;
    private final int heightMax;
    private final  int widthMin;
    private final int heightMin;
    private final Animal animal;

    public AnimalGrafico(Animal animal){
        this.animal = animal;

        switch (animal) {
            case Leon leon -> {
                widthMax = 100;
                heightMax = 100;
                widthMin = 80;
                heightMin = 80;
                imagen = "src/main/java/Interfaz/imagenes/Leon.png";
            }
            case Pinguino pinguino -> {
                widthMax = 100;
                heightMax = 100;
                widthMin = 80;
                heightMin = 80;
                imagen = "src/main/java/Interfaz/imagenes/Pinguino.png";
            }
            case Vaca vaca -> {
                widthMax = 100;
                heightMax = 100;
                widthMin = 80;
                heightMin = 80;
                imagen = "src/main/java/Interfaz/imagenes/Vaca.png";
            }
            case null, default -> {
                widthMax = 0;
                heightMax = 0;
                widthMin = 0;
                heightMin = 0;
                imagen = null;
            }
        }

        label = GeneradorImagen.ImageLabel(imagen,animal.getPosicionX(),animal.getPosicionY(), widthMin, heightMin);

        animal.setAltoImg(heightMax);
        animal.setAnchoImg(widthMax);
    }

    @Override
    public void run() {
        try {
            while (true) {
                //Proceso de movimiento del Animal
                this.animal.Moverse();
                label.setBounds(animal.getPosicionX(),animal.getPosicionY(), widthMax, heightMax);
                this.animal.getPanelHabitat().repaint();

                //Zona en que alcanza la comida el animal (Su hitbox)
                Rectangle rectangleA = this.label.getBounds();

                //Lista de la comida disponible dentro del habitat
                List<ComidaGrafica> comidas = this.animal.getPanelHabitat().getListaComida();

                synchronized(comidas){
                    Iterator<ComidaGrafica> iterator = comidas.iterator();
                    while(iterator.hasNext()){
                        ComidaGrafica comida = iterator.next();
                        Rectangle rectangleC = comida.getLabel().getBounds();
                        if(rectangleC.intersects(rectangleA)){
                            //Come su comida
                            if(this.animal.Comer(comida.getComida())){
                                this.animal.getPanelHabitat().remove(comida.getLabel());
                                iterator.remove();
                            }
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

    public void rePosicionar(Rectangle maximizado, Rectangle minimizado){animal.rePosicionar(maximizado, minimizado);}

    public void reDimencionar(Rectangle maximizado){
        if(maximizado.width == animal.getPanelHabitat().getWidth()) {    //Si se maximizo
            animal.getPanelHabitat().remove(label);
            label = GeneradorImagen.ImageLabel(imagen, animal.getPosicionX(), animal.getPosicionY(), widthMax, heightMax);
            animal.getPanelHabitat().add(label);
            animal.getPanelHabitat().repaint();
        }
        else{   //Si se minimizo
            animal.getPanelHabitat().remove(label);
            label = GeneradorImagen.ImageLabel(imagen, animal.getPosicionX(), animal.getPosicionY(), widthMin, heightMin);
            animal.getPanelHabitat().add(label);
            animal.getPanelHabitat().repaint();
        }

    }

    public void validarPosicion(){animal.validarPosicion();}
}
