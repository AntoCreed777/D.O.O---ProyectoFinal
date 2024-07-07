package Logica.Animales.Tierra;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;
import static Logica.Animales.Animal.FamiliaTaxonomica.Felino;

/**
 * SubClase de Animal que representa a un Leon
 */
public class Leon extends Animal {
    public final static int temperaturaAdecuada = 25; //Grados Celcius
    public final static Animal.Imagenes imagen = Imagenes.Leon;
    public final static Comida comida = Comida.Carne;

    /**
     * Constructor del Leon
     * @param posicionXinicial  Posicion X en que aparecera el Leon
     * @param posicionYinicial  Posicion Y en que aparecera el Leon
     * @param panelHabitat      Panel al que pertenecera el Leon
     */
    public Leon(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, Felino,
                Comida.Carne,Imagenes.Leon, Sonidos.Leon);
    }
}
