package Logica.Animales.Marte;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;

/**
 * SubClase de Animal que representa a un Depredador
 */
public class Depredador extends Animal {
    public final static int temperaturaAdecuada = 28; //Grados Celcius

    /**
     * Constructor del Depredador
     * @param posicionXinicial  Posicion X en que aparecera el Depredador
     * @param posicionYinicial  Posicion Y en que aparecera el Depredador
     * @param panelHabitat      Panel al que pertenecera el Depredador
     */
    public Depredador(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, "Campo",
                Imagenes.Depredador, Sonidos.Depredador);
    }

    /**
     * Funcion que permite comer al Depredador
     * @param comida    Comida que trata de comer el Depredador
     * @return  Retorna si logro o no comerse al comida
     */
    @Override
    public boolean Comer(Comida comida) {return comida == Comida.Carne;}    //FALTA CAMBIAR
}