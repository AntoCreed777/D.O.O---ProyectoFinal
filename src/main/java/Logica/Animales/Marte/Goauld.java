package Logica.Animales.Marte;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;
import static Logica.Animales.Animal.FamiliaTaxonomica.InsectoAncestral;

/**
 * SubClase de Animal que representa a un Goauld
 */
public class Goauld extends Animal {
    public final static int temperaturaAdecuada = 5; //Grados Celcius
    public final static Animal.Imagenes imagen = Imagenes.Goauld;
    public final static Comida comida = Comida.Humano;

    /**
     * Constructor del Goauld
     * @param posicionXinicial  Posicion X en que aparecera el Goauld
     * @param posicionYinicial  Posicion Y en que aparecera el Goauld
     * @param panelHabitat      Panel al que pertenecera el Goauld
     */
    public Goauld(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, InsectoAncestral,
                Comida.Humano,Imagenes.Goauld, Sonidos.Goauld);
    }
}