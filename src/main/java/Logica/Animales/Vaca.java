package Logica.Animales;

import Interfaz.Habitat.PanelHabitat;
import Logica.Comida;

public class Vaca extends Animal{
    public final static String familiaTaxonomica = "Ave";
    public final static int temperaturaAdecuada = 24; //Grados Celcius

    public Vaca(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat) {
        super(posicionXinicial, posicionYinicial, panelHabitat);
    }

    @Override
    public boolean Comer(Comida comida) {
        if(comida == Comida.Pasto){
            System.out.println("Que rico, pasto amarillo");
            return true;
        }
        else{
            System.out.println("Qeu rico, aire, na mentira, esto apesta :(");
            return false;
        }
    }

    @Override
    public void MeterSonido() {
        System.out.println("MUUUUUUUUUUU MUUUUUUUUUUUU");
    }

}
