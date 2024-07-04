package Logica.Animales;

import Interfaz.Habitat.PanelHabitat;
import Logica.Comida;

/**
 * SubClase de Animal que representa a un Caballo
 */
public class Caballo extends Animal{
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
    public boolean Comer(Comida comida){
        if(comida == Comida.Pasto){
            System.out.println("Comiendo el pastito, YAM YAM :)");
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
        System.out.println("El Cabaloo ***** de las montañasss");
    }
}