package Logica.TipoHabitats;

import Logica.Habitat;

import java.awt.*;

/**
 * SubClase que representa a un habitat del Planeta marte
 */
public class HabitatMarte extends Habitat {
    /**
     * Constructor que configura las variables
     */
    public HabitatMarte(){
        super.backgroundColor = new Color(0xFFB788);
        super.editPanelColor = new Color(0xE18158);
        super.btnColor = new Color(0xFFECC4);
        super.btnMarginColor = new Color(0xC68888);
        super.backgroundImg = "src/main/java/Interfaz/Imagenes/habitat_marte.png";
    }
}
