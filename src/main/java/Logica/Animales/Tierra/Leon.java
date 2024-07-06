package Logica.Animales.Tierra;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;

/**
 * SubClase de Animal que representa a un Leon
 */
public class Leon extends Animal {
    public final static int temperaturaAdecuada = 28; //Grados Celcius

    /**
     * Constructor del Leon
     * @param posicionXinicial  Posicion X en que aparecera el Leon
     * @param posicionYinicial  Posicion Y en que aparecera el Leon
     * @param panelHabitat      Panel al que pertenecera el Leon
     */
    public Leon(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, "Felino",
                Comida.Carne,Imagenes.Leon, Sonidos.Leon);
    }
}
