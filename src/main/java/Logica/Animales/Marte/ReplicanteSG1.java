package Logica.Animales.Marte;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;
import static Logica.Animales.Animal.FamiliaTaxonomica.RazaSuperior;

/**
 * SubClase de Animal que representa a un ReplicanteSG1
 */
public class ReplicanteSG1 extends Animal {
    public final static int temperaturaAdecuada = 28; //Grados Celcius
    public final static Animal.Imagenes imagen = Imagenes.ReplicanteSG1;
    public final static Comida comida = Comida.RobotLunar;

    /**
     * Constructor del ReplicanteSG1
     * @param posicionXinicial  Posicion X en que aparecera el ReplicanteSG1
     * @param posicionYinicial  Posicion Y en que aparecera el ReplicanteSG1
     * @param panelHabitat      Panel al que pertenecera el ReplicanteSG1
     */
    public ReplicanteSG1(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, RazaSuperior,
                Comida.RobotLunar,Imagenes.ReplicanteSG1, Sonidos.ReplicanteSG1);
    }
}