package Logica.Animales.Tierra;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;

/**
 * SubClase de Animal que representa a un Caballo
 */
public class Caballo extends Animal {
    public final static int temperaturaAdecuada = 28; //Grados Celcius

    /**
     * Constructor del Caballo
     * @param posicionXinicial  Posicion X en que aparecera el Caballo
     * @param posicionYinicial  Posicion Y en que aparecera el Caballo
     * @param panelHabitat      Panel al que pertenecera el Caballo
     */
    public Caballo(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, "Campo",
                Imagenes.Caballo, Sonidos.Caballo);
    }

    /**
     * Funcion que permite comer al Caballo
     * @param comida    Comida que trata de comer el Caballo
     * @return  Retorna si logro o no comerse al comida
     */
    @Override
    public boolean Comer(Comida comida) {return comida == Comida.Pasto;}
}