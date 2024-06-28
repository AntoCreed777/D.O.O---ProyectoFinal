package Logica.TipoHabitats;

import Logica.Habitat;

import java.awt.*;

public class HabitatTierra extends Habitat {

    private int[] temperatura;

    public HabitatTierra(){
        super.backgroundColor = new Color(0xF6FFEC);
        super.editPanelColor = new Color(0x68B0AB);
        super.btnColor = new Color(0xFAF3DD);
        super.btnMarginColor = new Color(0xBABABA);
        super.backgroundImg = "src/main/java/Interfaz/Imagenes/habitat_polar_1.jpg";
        temperatura = new int[]{0, 100};
    }

    public void setTemperatura(int minimo, int maximo){
        temperatura[0] = minimo;
        temperatura[1] = maximo;
    }
}
