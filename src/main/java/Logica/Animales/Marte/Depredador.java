package Logica.Animales.Marte;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;
import static Logica.Animales.Animal.FamiliaTaxonomica.RazaInteligente;

/**
 * SubClase de Animal que representa a un Depredador
 */
public class Depredador extends Animal {
    public final static int temperaturaAdecuada = 25; //Grados Celcius
    public final static Animal.Imagenes imagen = Imagenes.Depredador;
    public final static Comida comida = Comida.Vaca;

    /**
     * Constructor del Depredador
     * @param posicionXinicial  Posicion X en que aparecera el Depredador
     * @param posicionYinicial  Posicion Y en que aparecera el Depredador
     * @param panelHabitat      Panel al que pertenecera el Depredador
     */
    public Depredador(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, RazaInteligente,
                Comida.Vaca,Imagenes.Depredador, Sonidos.Depredador);
    }
}