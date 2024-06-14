package Interfaz;

import Logica.Animales.Animal;
import Logica.TipoHabitat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/*
* Clase para graficar el habitat
*/
public class HabitatGrafico extends JPanel implements GeneradorImagen{

    private HabitatGrafico habitat;
    private ArrayList<AnimalGrafico> listaAnimales = null;

    public HabitatGrafico(TipoHabitat tipo, int posX, int posY, int width , int height) {

        habitat = this;
        listaAnimales = new ArrayList<AnimalGrafico>();


        this.setBounds(posX, posY, width, height);

        String img = "";
        switch(tipo){
            case POLAR -> img = "src/main/java/Interfaz/Imagenes/habitat_polar_1.jpg";
            case JUNGLA -> img = "src/main/java/Interfaz/Imagenes/habitat_jungla_1.png";
            case DESERTICO -> img = "src/main/java/Interfaz/Imagenes/habitat_desertico_1.png";
        }

        JLabel label = GeneradorImagen.ImageLabel(img, 0, 0, width, height);
        this.add(label);

    }


    /*
    * Funcion para añadir accesorios decorativos al habitat
    */
    public void agregarAccesorio(Accesorios accesorio, int posX, int posY){

        String img = "";
        switch(accesorio){
            case ROCA -> img =  "src/main/java/Interfaz/Imagenes/accesorio_roca_1.jpg";
            case ARBOL -> img = "src/main/java/Interfaz/Imagenes/accesorio_arbol_1.png";
        }

        JLabel accesorioLabel = GeneradorImagen.ImageLabel(img, posX, posY, 100, 100);
        accesorioLabel.setVerticalAlignment(JLabel.CENTER);
        accesorioLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(accesorioLabel);

    }

    public void agregarAnimal(AnimalGrafico animal){
        listaAnimales.add(animal);
    }

    public AnimalGrafico sacarAnimal(AnimalGrafico animal){
        int index = listaAnimales.indexOf(animal); // requiere un equals bien definido en animal
        return listaAnimales.get(index);
    }

    public enum Accesorios{
        ARBOL, ROCA,
    }


}
