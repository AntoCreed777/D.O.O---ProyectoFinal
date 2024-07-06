package Logica.Animales.Marte;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;

/**
 * SubClase de Animal que representa a un AsgardianoSG1
 */
public class AsgardianoSG1 extends Animal {
    public final static int temperaturaAdecuada = 28; //Grados Celcius

    /**
     * Constructor del AsgardianoSG1
     * @param posicionXinicial  Posicion X en que aparecera el AsgardianoSG1
     * @param posicionYinicial  Posicion Y en que aparecera el AsgardianoSG1
     * @param panelHabitat      Panel al que pertenecera el AsgardianoSG1
     */
    public AsgardianoSG1(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, "Campo",
                Comida.Vaca,Imagenes.AsgardianoSG1, Sonidos.AsgardianoSG1);
    }
}