package Logica.Animales.Tierra;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;

/**
 * SubClase de Animal que representa a un Pinguino
 */
public class Pinguino extends Animal {
    public final static int temperaturaAdecuada = -5; //Grados Celcius

    /**
     * Constructor del Pinguino
     * @param posicionXinicial  Posicion X en que aparecera el Pinguino
     * @param posicionYinicial  Posicion Y en que aparecera el Pinguino
     * @param panelHabitat      Panel al que pertenecera el Pinguino
     */
    public Pinguino(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat,"Acuatico",
                Imagenes.Pinguino, Sonidos.Pinguino);
    }

    /**
     * Funcion que permite comer al Pinguino
     * @param comida    Comida que trata de comer el Pinguino
     * @return  Retorna si logro o no comerse al comida
     */
    @Override
    public boolean Comer(Comida comida) {return comida == Comida.Pescado;}
}
