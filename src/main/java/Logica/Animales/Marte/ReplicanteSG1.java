package Logica.Animales.Marte;

import Interfaz.Habitat.PanelHabitat;
import Logica.Animales.Animal;
import Logica.Comida;

/**
 * SubClase de Animal que representa a un ReplicanteSG1
 */
public class ReplicanteSG1 extends Animal {
    public final static int temperaturaAdecuada = 28; //Grados Celcius

    /**
     * Constructor del ReplicanteSG1
     * @param posicionXinicial  Posicion X en que aparecera el ReplicanteSG1
     * @param posicionYinicial  Posicion Y en que aparecera el ReplicanteSG1
     * @param panelHabitat      Panel al que pertenecera el ReplicanteSG1
     */
    public ReplicanteSG1(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, "Campo",
                Comida.RobotLunar,Imagenes.ReplicanteSG1, Sonidos.ReplicanteSG1);
    }
}