package Logica;

import Interfaz.ObjetosGraficos.*;
import Logica.Animales.Animal;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase que representa a un habitat
 */
public abstract class Habitat {
    private final String backgroundImg;
    private final Animal.Imagenes[] animalesPermitidos;

    protected Color backgroundColor;
    protected Color editPanelColor;
    protected Color btnColor;
    protected Color btnMarginColor;

    protected final ArrayList<AnimalGrafico> listaAnimales;
    protected final List<ComidaGrafica> listaComida;
    protected final List<AccesorioGrafico> listaAccesorios;

    /**
     * Constructor que inicializa las listas de elementos que contiene el habitat
     */
    public Habitat(HabitatTipo habitatTipo, Animal.Imagenes[] animalesPermitidos){
        this.animalesPermitidos = animalesPermitidos;
        this.backgroundImg = habitatTipo.getImagen();
        listaAnimales = new ArrayList<AnimalGrafico>();
        this.listaComida = Collections.synchronizedList(new ArrayList<>());
        this.listaAccesorios = Collections.synchronizedList(new ArrayList<>());
    }

    /**
     * Interfaz que usan todos los Enum que designan los tipos de habitats
     */
    public interface HabitatTipo {String getImagen();}

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

    /**
     * Getter
     * @return Retorna la lista de animales permitidos dentro del habitat
     */
    public Animal.Imagenes[] getAnimalesPermitidos(){return animalesPermitidos;}
}
