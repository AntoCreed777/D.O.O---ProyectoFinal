package Logica;

import Interfaz.Animal_Y_Comida.AccesorioGrafico;
import Interfaz.Animal_Y_Comida.AnimalGrafico;
import Interfaz.Animal_Y_Comida.ComidaGrafica;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase que representa a un habitat
 */
public class Habitat {

    protected Color backgroundColor;
    protected Color editPanelColor;
    protected Color btnColor ;
    protected Color btnMarginColor;
    protected String backgroundImg;

    protected final ArrayList<AnimalGrafico> listaAnimales;
    protected final List<ComidaGrafica> listaComida;
    protected final List<AccesorioGrafico> listaAccesorios;

    private int[] temperatura;

    /**
     * Constructor que inicializa las listas de elementos que contiene el habitat
     */
    public Habitat(){
        listaAnimales = new ArrayList<AnimalGrafico>();
        this.listaComida = Collections.synchronizedList(new ArrayList<>());
        this.listaAccesorios = Collections.synchronizedList(new ArrayList<>());
        temperatura = new int[]{0, 100};
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

    /**
     * Funcion que establece la Temperatura mminima y maxima dentro del habitat
     * @param minimo    Temperatura minima dentro del habitat
     * @param maximo    Temperatura maxima dentro del habitat
     */
    public void setTemperatura(int minimo, int maximo){
        temperatura[0] = minimo;
        temperatura[1] = maximo;
    }
}
