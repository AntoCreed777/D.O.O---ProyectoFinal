package Logica.Animales.Marte;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;

/**
 * SubClase de Animal que representa a un Aracne
 */
public class Aracne extends Animal {
    public final static int temperaturaAdecuada = 28; //Grados Celcius

    /**
     * Constructor del Aracne
     * @param posicionXinicial  Posicion X en que aparecera el Aracne
     * @param posicionYinicial  Posicion Y en que aparecera el Aracne
     * @param panelHabitat      Panel al que pertenecera el Aracne
     */
    public Aracne(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, "Campo",
                Imagenes.Aracne, Sonidos.Aracne);
    }

    /**
     * Funcion que permite comer al Aracne
     * @param comida    Comida que trata de comer el Aracne
     * @return  Retorna si logro o no comerse al comida
     */
    @Override
    public boolean Comer(Comida comida) {return comida == Comida.Humano;}
}