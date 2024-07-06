package Logica.Animales.Tierra;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;
import static Logica.Animales.Animal.FamiliaTaxonomica.Acuatico;

/**
 * SubClase de Animal que representa a un Pinguino
 */
public class Pinguino extends Animal {
    public final static int temperaturaAdecuada = -5; //Grados Celcius
    public final static Animal.Imagenes imagen = Imagenes.Pinguino;
    public final static Comida comida = Comida.Pescado;

    /**
     * Constructor del Pinguino
     * @param posicionXinicial  Posicion X en que aparecera el Pinguino
     * @param posicionYinicial  Posicion Y en que aparecera el Pinguino
     * @param panelHabitat      Panel al que pertenecera el Pinguino
     */
    public Pinguino(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat,Acuatico,
                Comida.Pescado,Imagenes.Pinguino, Sonidos.Pinguino);
    }
}
