package Interfaz.Animal_Y_Comida;

import Interfaz.imagenes.GeneradorImagen;
import Interfaz.Sonidos.Sonido;
import Logica.Animales.*;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;

/**
 * Clase que muestra de forma grafica un animal
 */
public class AnimalGrafico implements GeneradorImagen, Runnable, Sonido {
    private final String imagen;
    private JLabel label;
    private final int widthMax;
    private final int heightMax;
    private final  int widthMin;
    private final int heightMin;
    private final Animal animal;
    private final Clip sonido;
    private Boolean running = true;

    /**
     * Constructor en donde se carga la imagen que representa al animal y se guarda al animal
     * @param animal    Animal que representara esta clase
     */
    public AnimalGrafico(Animal animal){
        this.animal = animal;

        switch (animal) {
            case Leon leon -> {
                widthMax = 100;
                heightMax = 100;
                widthMin = 80;
                heightMin = 80;
                imagen = "src/main/java/Interfaz/imagenes/Animales/Leon.png";
                sonido = Sonido.cargarSonido("src/main/java/Interfaz/Sonidos/lion.wav");
            }
            case Pinguino pinguino -> {
                widthMax = 100;
                heightMax = 100;
                widthMin = 80;
                heightMin = 80;
                imagen = "src/main/java/Interfaz/imagenes/Animales/Pinguino.png";
                sonido = Sonido.cargarSonido("src/main/java/Interfaz/Sonidos/penguin.wav");
            }
            case Vaca vaca -> {
                widthMax = 100;
                heightMax = 100;
                widthMin = 80;
                heightMin = 80;
                imagen = "src/main/java/Interfaz/imagenes/Animales/Vaca.png";
                sonido = Sonido.cargarSonido("src/main/java/Interfaz/Sonidos/cow.wav");
            }
            case null, default -> {
                widthMax = 0;
                heightMax = 0;
                widthMin = 0;
                heightMin = 0;
                imagen = null;
                sonido = Sonido.cargarSonido("");
            }
        }

        label = GeneradorImagen.ImageLabel(imagen,animal.getPosicionX(),animal.getPosicionY(), widthMin, heightMin);

        animal.setAltoImg(heightMax);
        animal.setAnchoImg(widthMax);
    }

    /**
     * Funcion que controla el movimiento del animal y cuando come
     */
    @Override
    public void run() {
        try {
            while (running) {
                //Proceso de movimiento del Animal
                this.animal.Moverse();
                label.setBounds(animal.getPosicionX(),animal.getPosicionY(), widthMax, heightMax);
                this.animal.getPanelHabitat().repaint();

                //Zona en que alcanza la comida el animal (Su hitbox)
                Rectangle rectangleA = this.label.getBounds();

                //Lista de la comida disponible dentro del habitat
                List<ComidaGrafica> comidas = this.animal.getPanelHabitat().getHabitat().getListaComida();

                synchronized(comidas){
                    Iterator<ComidaGrafica> iterator = comidas.iterator();
                    while(iterator.hasNext()){
                        ComidaGrafica comida = iterator.next();
                        Rectangle rectangleC = comida.getLabel().getBounds();
                        if(rectangleC.intersects(rectangleA)){
                            //Come su comida
                            if(this.animal.Comer(comida.getComida())){
                                Sonido.reproducirSonido(sonido,() -> {});
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

    /**
     * Funcion que se encarga de rePosicionar el label segun los limites del panel
     * al que pertenece
     * @param maximizado    Limite maximo del panel
     * @param minimizado    Limite minimo del panel
     */
    public void rePosicionar(Rectangle maximizado, Rectangle minimizado){animal.rePosicionar(maximizado, minimizado);}

    /**
     * Funcion que se encarga de redimensionar el label segun los limites del panel
     * al que pertenece
     * @param maximizado    Limite maximo del panel
     */
    public void reDimencionar(Rectangle maximizado){
        animal.getPanelHabitat().remove(label);
        if(maximizado.width == animal.getPanelHabitat().getWidth()) {    //Si se maximizo
            label = GeneradorImagen.ImageLabel(imagen, animal.getPosicionX(), animal.getPosicionY(), widthMax, heightMax);
        }
        else{   //Si se minimizo
            label = GeneradorImagen.ImageLabel(imagen, animal.getPosicionX(), animal.getPosicionY(), widthMin, heightMin);
        }
        animal.getPanelHabitat().add(label);

    }

    /**
     * Funcion que valida que el animal se encuentre dentro de los limites del panel en que
     * se muestra
     */
    public void validarPosicion(){animal.validarPosicion();}

    /**
     * getter
     * @return Retorna la familia taxonomica a la que pertenece el animal
     */
    public String getFamiliaTaxonomica(){return animal.getFamiliaTaxonomica();}

    /**
     * Getter
     * @return  Retorna la label que contiene esta clase
     */
    public JLabel getLabel(){return this.label;}

    /**
     * Setter
     * @param running   Estado que se desea implementar en el hilo
     */
    public void setRunning(Boolean running){this.running = running;}
}
