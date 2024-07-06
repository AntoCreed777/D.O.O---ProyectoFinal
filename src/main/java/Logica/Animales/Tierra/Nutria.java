package Logica.Animales.Tierra;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;

/**
 * SubClase de Animal que representa a un Nutria
 */
public class Nutria extends Animal {
    public final static int temperaturaAdecuada = 28; //Grados Celcius

    /**
     * Constructor del Nutria
     * @param posicionXinicial  Posicion X en que aparecera el Nutria
     * @param posicionYinicial  Posicion Y en que aparecera el Nutria
     * @param panelHabitat      Panel al que pertenecera el Nutria
     */
    public Nutria(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, "Acuatico",
                Comida.Pescado,Imagenes.Nutria, Sonidos.Nutria);
    }
}