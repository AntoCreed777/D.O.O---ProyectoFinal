package Logica.Animales.Marte;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;
import static Logica.Animales.Animal.FamiliaTaxonomica.RazaInteligente;

/**
 * SubClase de Animal que representa a un AsgardianoSG1
 */
public class AsgardianoSG1 extends Animal {
    public final static int temperaturaAdecuada = 10; //Grados Celcius
    public final static Animal.Imagenes imagen = Imagenes.AsgardianoSG1;
    public final static Comida comida = Comida.Vaca;

    /**
     * Constructor del AsgardianoSG1
     * @param posicionXinicial  Posicion X en que aparecera el AsgardianoSG1
     * @param posicionYinicial  Posicion Y en que aparecera el AsgardianoSG1
     * @param panelHabitat      Panel al que pertenecera el AsgardianoSG1
     */
    public AsgardianoSG1(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, RazaInteligente,
                Comida.Vaca,Imagenes.AsgardianoSG1, Sonidos.AsgardianoSG1);
    }
}