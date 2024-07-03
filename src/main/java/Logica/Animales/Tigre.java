package Logica.Animales;

import Interfaz.Habitat.PanelHabitat;
import Logica.Comida;

/**
 * SubClase de Animal que representa a un Tigre
 */
public class Tigre extends Animal{
    public final static int temperaturaAdecuada = 28; //Grados Celcius

    /**
     * Constructor del Tigre
     * @param posicionXinicial  Posicion X en que aparecera el Tigre
     * @param posicionYinicial  Posicion Y en que aparecera el Tigre
     * @param panelHabitat      Panel al que pertenecera el Tigre
     */
    public Tigre(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, "Felino",
                Imagenes.Tigre, Sonidos.Tigre);
    }

    /**
     * Funcion que permite comer al Tigre
     * @param comida    Comida que trata de comer el Tigre
     * @return  Retorna si logro o no comerse al comida
     */
    @Override
    public boolean Comer(Comida comida){
        if(comida == Comida.Carne){
            System.out.println("Que mejor que un asaito");
            return true;
        }
        else{
            System.out.println("MAAAAA, y la comida??");
            return false;
        }
    }

    /**
     * Funcion que permite meter sonido al animal
     */
    @Override
    public void MeterSonido() {
        System.out.println("ojasdboasbdoasbd");
    }
}