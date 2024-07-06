package Logica.Animales.Marte;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;

/**
 * SubClase de Animal que representa a un Goauld
 */
public class Goauld extends Animal {
    public final static int temperaturaAdecuada = 28; //Grados Celcius

    /**
     * Constructor del Goauld
     * @param posicionXinicial  Posicion X en que aparecera el Goauld
     * @param posicionYinicial  Posicion Y en que aparecera el Goauld
     * @param panelHabitat      Panel al que pertenecera el Goauld
     */
    public Goauld(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, "Campo",
                Imagenes.Goauld, Sonidos.Goauld);
    }

    /**
     * Funcion que permite comer al Goauld
     * @param comida    Comida que trata de comer el Goauld
     * @return  Retorna si logro o no comerse al comida
     */
    @Override
    public boolean Comer(Comida comida) {return comida == Comida.Humano;}
}