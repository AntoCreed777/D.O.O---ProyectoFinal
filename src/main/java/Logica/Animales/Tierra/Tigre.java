package Logica.Animales.Tierra;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;
import static Logica.Animales.Animal.FamiliaTaxonomica.Felino;

/**
 * SubClase de Animal que representa a un Tigre
 */
public class Tigre extends Animal {
    public final static int temperaturaAdecuada = 28; //Grados Celcius
    public final static Animal.Imagenes imagen = Imagenes.Tigre;
    public final static Comida comida = Comida.Carne;

    /**
     * Constructor del Tigre
     * @param posicionXinicial  Posicion X en que aparecera el Tigre
     * @param posicionYinicial  Posicion Y en que aparecera el Tigre
     * @param panelHabitat      Panel al que pertenecera el Tigre
     */
    public Tigre(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, Felino,
                Comida.Carne,Imagenes.Tigre, Sonidos.Tigre);
    }
}