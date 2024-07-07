package Logica.Animales.Tierra;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;
import static Logica.Animales.Animal.FamiliaTaxonomica.Campo;

/**
 * SubClase de Animal que representa a un Caballo
 */
public class Caballo extends Animal {
    public final static int temperaturaAdecuada = 22; //Grados Celcius
    public final static Animal.Imagenes imagen = Imagenes.Caballo;
    public final static Comida comida = Comida.Pasto;

    /**
     * Constructor del Caballo
     * @param posicionXinicial  Posicion X en que aparecera el Caballo
     * @param posicionYinicial  Posicion Y en que aparecera el Caballo
     * @param panelHabitat      Panel al que pertenecera el Caballo
     */
    public Caballo(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, Campo,
                Comida.Pasto,Imagenes.Caballo, Sonidos.Caballo);
    }
}