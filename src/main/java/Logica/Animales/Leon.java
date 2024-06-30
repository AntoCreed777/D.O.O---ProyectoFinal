package Logica.Animales;

import Interfaz.Habitat.PanelHabitat;
import Logica.Comida;

/**
 * SubClase de Animal que representa a un Leon
 */
public class Leon extends Animal{
    public final static int temperaturaAdecuada = 28; //Grados Celcius

    /**
     * Constructor del Leon
     * @param posicionXinicial  Posicion X en que aparecera el Leon
     * @param posicionYinicial  Posicion Y en que aparecera el Leon
     * @param panelHabitat      Panel al que pertenecera el Leon
     */
    public Leon(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, "Felino");
    }

    /**
     * Funcion que permite comer al Leon
     * @param comida    Comida que trata de comer el Leon
     * @return  Retorna si logro o no comerse al comida
     */
    @Override
    public boolean Comer(Comida comida){
        if(comida == Comida.Carne){
            System.out.println("Comiendo la carne, YAM YAM :)");
            return true;
        }
        else{
            System.out.println("Que asco, no me gusta");
            return false;
        }
    }

    /**
     * Funcion que permite meter sonido al animal
     */
    @Override
    public void MeterSonido() {
        System.out.println("RRRROOOOOOAAAAARRRRR");
    }

}
