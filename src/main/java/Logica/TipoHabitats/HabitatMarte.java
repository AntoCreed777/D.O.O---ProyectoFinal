package Logica.TipoHabitats;

import Logica.Habitat;

import java.awt.*;

public class HabitatMarte extends Habitat {

    private int[] temperatura;

    public HabitatMarte(){

        super.backgroundColor = new Color(0xFFB788);
        super.editPanelColor = new Color(0xE18158);
        super.btnColor = new Color(0xFFECC4);
        super.btnMarginColor = new Color(0xC68888);
        super.backgroundImg = "src/main/java/Interfaz/Imagenes/habitat_marte.png";
        temperatura = new int[]{0, 100};
    }

    public void setTemperatura(int minimo, int maximo){
        temperatura[0] = minimo;
        temperatura[1] = maximo;
    }

}
