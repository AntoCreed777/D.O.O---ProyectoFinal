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
    private final int[] temperatura;
    private final Class<? extends Animal>[] animalesPermitidos;
    private final ArrayList<Comida> comidasPermitidas;

    protected Color backgroundColor;
    protected Color editPanelColor;
    protected Color btnColor ;
    protected Color btnMarginColor;

    protected final ArrayList<AnimalGrafico> listaAnimales;
    protected final List<ComidaGrafica> listaComida;
    protected final List<AccesorioGrafico> listaAccesorios;

    /**
     * Constructor que inicializa las listas de elementos que contiene el habitat
     */
    public Habitat(HabitatTipo habitatTipo, Class<? extends Animal>[] animalesPermitidos) throws NoSuchFieldException, IllegalAccessException {
        this.backgroundImg = habitatTipo.getImagen();
        this.temperatura = habitatTipo.getTemperatura();

        this.animalesPermitidos = animalesPermitidos;
        this.comidasPermitidas = new ArrayList<>();

        for(Class<? extends Animal> animal : animalesPermitidos){
            boolean yaEsta = false;
            for(Comida comida : comidasPermitidas){
                if(comida == animal.getField("comida").get(null)){yaEsta = true;break;}
            }
            if(!yaEsta){comidasPermitidas.add((Comida)animal.getField("comida").get(null));}
        }

        listaAnimales = new ArrayList<>();
        this.listaComida = Collections.synchronizedList(new ArrayList<>());
        this.listaAccesorios = Collections.synchronizedList(new ArrayList<>());
    }

    /**
     * Interfaz que usan todos los Enum que designan los tipos de habitats
     */
    public interface HabitatTipo {
        String getImagen();
        int[] getTemperatura();
    }

    /**
     * Interfaz que usan todos los Enum que designan los accesorios disponibles dentro del habitat
     */
    public interface AccesoriosTipo {
        String name();
        String getImagen();
    }

    /**
     * Getter
     * @return Retorna el color del fondo
     */
    public Color getBackgroundColor() {return backgroundColor;}

    /**
     * Getter del color de fondo
     * @return  Retorna el color del panel de edicion
     */
    public Color getEditPanelColor(){return editPanelColor;}

    /**
     * Getter del color de los botones
     * @return Retorna el color de los botones
     */
    public Color getBtnColor(){return btnColor;}

    /**
     * Getter del color del borde de los botones
     * @return  Retorna el color del borde
     */
    public Color getBtnMarginColor(){return btnMarginColor;}

    /**
     * Getterde la imagen de fondo
     * @return  Retorna la imagen que representa a este habitat
     */
    public String getBackgroundImg(){return backgroundImg;}

    /**
     * Getter de la lista de animales que contiene el hábitat
     * @return  Retorna la lista de animales
     */
    public List<AnimalGrafico> getListaAnimales(){return listaAnimales;}

    /**
     * Getter de la lista de comida que contiene el hábitat
     * @return  Retorna la lista de comida
     */
    public synchronized List<ComidaGrafica> getListaComida() {return listaComida;}

    /**
     * Getter de la lista de accesorios que contiene el hábitat
     * @return  Retorna la lista de accesorios
     */
    public synchronized List<AccesorioGrafico> getListaAccesorios() { return listaAccesorios;}

    /**
     * Getter de la lista de animales permitidos en el hábitat
     * @return Retorna la lista de animales permitidos
     */
    public Class<? extends Animal>[] getAnimalesPermitidos(){return animalesPermitidos;}

    /**
     * Getter de la lista de comidas permitidas en el hábitat
     * @return Retorna la lista de comidas permitidas
     */
    public ArrayList<Comida> getComidasPermitidas(){return comidasPermitidas;}

    /**
     * Getter de la temperatura mínima y máxima del hábitat
     * @return Retorna la temperatura minima y maxima
     */
    public int[] getTemperatura() {return temperatura;}
}
