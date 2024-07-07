package Logica.Animales.Marte;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;
import static Logica.Animales.Animal.FamiliaTaxonomica.InsectoAncestral;

/**
 * SubClase de Animal que representa a un Aracne
 */
public class Aracne extends Animal {
    public final static int temperaturaAdecuada = 8; //Grados Celcius
    public final static Animal.Imagenes imagen = Imagenes.Aracne;
    public final static Comida comida = Comida.Humano;

    /**
     * Constructor del Aracne
     * @param posicionXinicial  Posicion X en que aparecera el Aracne
     * @param posicionYinicial  Posicion Y en que aparecera el Aracne
     * @param panelHabitat      Panel al que pertenecera el Aracne
     */
    public Aracne(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, InsectoAncestral,
                Comida.Humano,Imagenes.Aracne, Sonidos.Aracne);
    }
}