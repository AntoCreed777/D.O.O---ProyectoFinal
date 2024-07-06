package Logica.Animales.Marte;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;

/**
 * SubClase de Animal que representa a un AlienX
 */
public class AlienX extends Animal {
    public final static int temperaturaAdecuada = 28; //Grados Celcius

    /**
     * Constructor del AlienX
     * @param posicionXinicial  Posicion X en que aparecera el AlienX
     * @param posicionYinicial  Posicion Y en que aparecera el AlienX
     * @param panelHabitat      Panel al que pertenecera el AlienX
     */
    public AlienX(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, "Campo",
                Comida.RobotLunar,Imagenes.AlienX, Sonidos.AlienX);
    }
}