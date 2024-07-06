package Logica.Animales.Marte;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;
import static Logica.Animales.Animal.FamiliaTaxonomica.InsectoAnsestral;

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
        super(posicionXinicial, posicionYinicial, panelHabitat, InsectoAnsestral,
                Comida.Humano,Imagenes.Goauld, Sonidos.Goauld);
    }
}