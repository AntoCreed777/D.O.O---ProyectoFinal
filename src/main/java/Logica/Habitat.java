package Logica;

import Interfaz.ObjetosGraficos.AccesorioGrafico;
import Interfaz.ObjetosGraficos.AnimalGrafico;
import Interfaz.ObjetosGraficos.ComidaGrafica;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase que representa a un habitat
 */
public abstract class Habitat {

    protected Color backgroundColor;
    protected Color editPanelColor;
    protected Color btnColor ;
    protected Color btnMarginColor;
    protected String backgroundImg;

    protected final ArrayList<AnimalGrafico> listaAnimales;
    protected final List<ComidaGrafica> listaComida;
    protected final List<AccesorioGrafico> listaAccesorios;

    protected String[] animalesPermitidos;

    /**
     * Constructor que inicializa las listas de elementos que contiene el habitat
     */
    public Habitat(){
        listaAnimales = new ArrayList<AnimalGrafico>();
        this.listaComida = Collections.synchronizedList(new ArrayList<>());
        this.listaAccesorios = Collections.synchronizedList(new ArrayList<>());
    }

    /**
     * Getter
     * @return Retorna el color del fondo
     */
    public Color getBackgroundColor() {return backgroundColor;}

    /**
     * Getter
     * @return  Retorna el color del panel de edicion
     */
    public Color getEditPanelColor(){return editPanelColor;}

    /**
     * Getter
     * @return Retorna el color de los botones
     */
    public Color getBtnColor(){return btnColor;}

    /**
     * Getter
     * @return  Retorna el Color del Borde
     */
    public Color getBtnMarginColor(){return btnMarginColor;}

    /**
     * Getter
     * @return  Retorna la imagen que representa a este habitat
     */
    public String getBackgroundImg(){return backgroundImg;}

    /**
     * Getter
     * @return  Retorna la lista de animales que contiene el habitat
     */
    public List<AnimalGrafico> getListaAnimales(){return listaAnimales;}

    /**
     * Getter
     * @return  Retorna la lista de comida que contiene el habitat
     */
    public synchronized List<ComidaGrafica> getListaComida() {return listaComida;}

    /**
     * Getter
     * @return  Retorna la lista de accesorios que contiene el habitat
     */
    public synchronized List<AccesorioGrafico> getListaAccesorios() { return listaAccesorios;}


    public String[] getAnimalesPermitidos(){
        return animalesPermitidos;
    }

    public String getAnimalImg(String animal){
        switch (animal) {
            case "Vaca" : return "src/main/java/interfaz/Imagenes/Animales/Vaca.png";
            case "Leon" : return "src/main/java/interfaz/Imagenes/Animales/Leon.png";
            case "Pinguino" : return "src/main/java/interfaz/Imagenes/Animales/Pinguino.png";
            case "Tigre" : return "src/main/java/interfaz/Imagenes/Animales/Tigre.png";
            case "Nutria" : return "src/main/java/interfaz/Imagenes/Animales/Nutria.png";
            case "Caballo" : return "src/main/java/interfaz/Imagenes/Animales/Caballo.png";
            case "AlienX" : return "src/main/java/interfaz/Imagenes/Animales/AlienX.png";
            case "AsgardianoSG1" : return "src/main/java/interfaz/Imagenes/Animales/AsgardianoSG1.png";
            case "Aracne" : return "src/main/java/interfaz/Imagenes/Animales/Aracne.png";
            case "Depredador" : return "src/main/java/interfaz/Imagenes/Animales/Depredador.png";
            case "Goauld" : return "src/main/java/interfaz/Imagenes/Animales/Goauld.png";
            case "ReplicanteSG1" : return "src/main/java/interfaz/Imagenes/Animales/ReplicanteSG1.png";
            default : return "";
        }
    }
}
