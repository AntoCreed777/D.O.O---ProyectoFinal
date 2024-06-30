package Logica.Animales;

import Interfaz.Habitat.PanelHabitat;
import Logica.Comida;

/**
 * SubClase de Animal que representa a un Vaca
 */
public class Vaca extends Animal{
    public final static int temperaturaAdecuada = 24; //Grados Celcius

    /**
     * Constructor del Vaca
     * @param posicionXinicial  Posicion X en que aparecera el Vaca
     * @param posicionYinicial  Posicion Y en que aparecera el Vaca
     * @param panelHabitat      Panel al que pertenecera el Vaca
     */
    public Vaca(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat) {
        super(posicionXinicial, posicionYinicial, panelHabitat, "Bovido");
    }

    /**
     * Funcion que permite comer al Vaca
     * @param comida    Comida que trata de comer el Vaca
     * @return  Retorna si logro o no comerse al comida
     */
    @Override
    public boolean Comer(Comida comida) {
        if(comida == Comida.Pasto){
            System.out.println("Que rico, pasto amarillo");
            return true;
        }
        else{
            System.out.println("Qeu rico, aire, na mentira, esto apesta :(");
            return false;
        }
    }

    /**
     * Funcion que permite meter sonido al animal
     */
    @Override
    public void MeterSonido() {
        System.out.println("MUUUUUUUUUUU MUUUUUUUUUUUU");
    }

}
