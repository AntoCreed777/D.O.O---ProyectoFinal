package Logica.Animales;

import Interfaz.Habitat.PanelHabitat;
import Logica.Comida;

public class Pinguino extends Animal{
    public final static int temperaturaAdecuada = -5; //Grados Celcius

    public Pinguino(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, "Ave");
    }

    @Override
    public boolean Comer(Comida comida) {
        if(comida == Comida.Pescado){
            System.out.println("Comiendome mi Pescadito :)");
            return true;
        }
        else{
            System.out.println("NO ME GUSTAA");
            return false;
        }
    }

    @Override
    public void MeterSonido() {
        System.out.println("CRIIRIRIIRXIXIIACI NO SE EL SONIDO QUE METE XD");
    }

}
