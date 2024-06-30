package Logica.TipoHabitats;

import Logica.Habitat;

import java.awt.*;

/**
 * SubClase que representa a un habitat del Planeta Tierra
 */
public class HabitatTierra extends Habitat {
    private int[] temperatura;

    /**
     * Constructor que configura las variables
     */
    public HabitatTierra(){
        super.backgroundColor = new Color(0xF6FFEC);
        super.editPanelColor = new Color(0x68B0AB);
        super.btnColor = new Color(0xFAF3DD);
        super.btnMarginColor = new Color(0xBABABA);
        super.backgroundImg = "src/main/java/Interfaz/Imagenes/habitat_polar_1.jpg";
        temperatura = new int[]{0, 100};
    }

    /**
     * Funcion que establece la Temperatura mminima y maxima dentro del habitat
     * @param minimo    Temperatura minima dentro del habitat
     * @param maximo    Temperatura maxima dentro del habitat
     */
    public void setTemperatura(int minimo, int maximo){
        temperatura[0] = minimo;
        temperatura[1] = maximo;
    }
}
