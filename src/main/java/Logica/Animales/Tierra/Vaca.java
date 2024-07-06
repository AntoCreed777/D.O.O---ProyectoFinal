package Logica.Animales.Tierra;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;

import static Logica.Animales.Animal.FamiliaTaxonomica.Campo;

/**
 * SubClase de Animal que representa a un Vaca
 */
public class Vaca extends Animal {
    public final static int temperaturaAdecuada = 24; //Grados Celcius

    /**
     * Constructor del Vaca
     * @param posicionXinicial  Posicion X en que aparecera el Vaca
     * @param posicionYinicial  Posicion Y en que aparecera el Vaca
     * @param panelHabitat      Panel al que pertenecera el Vaca
     */
    public Vaca(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat) {
        super(posicionXinicial, posicionYinicial, panelHabitat, Campo,
                Comida.Pasto,Imagenes.Vaca, Sonidos.Vaca);
    }
}
