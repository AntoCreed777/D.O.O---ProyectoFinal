package Logica.TipoHabitats;

import Logica.Habitat;

import java.awt.*;

/**
 * SubClase que representa a un habitat del Planeta Tierra
 */
public class HabitatTierra extends Habitat {
    /**
     * Constructor que configura las variables
     */
    public HabitatTierra(){
        super.backgroundColor = new Color(0xF6FFEC);
        super.editPanelColor = new Color(0x68B0AB);
        super.btnColor = new Color(0xFAF3DD);
        super.btnMarginColor = new Color(0xBABABA);
        super.backgroundImg = "src/main/java/Interfaz/Imagenes/habitat_polar_1.jpg";
    }
}
