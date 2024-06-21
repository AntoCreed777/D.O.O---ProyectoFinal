package Logica.Animales;

import Interfaz.Habitat.PanelHabitat;
import Logica.Comida;

public class Pinguino extends Animal{
    public final static String familiaTaxonomica = "Ave";
    public final static int temperaturaAdecuada = -5; //Grados Celcius

    public Pinguino(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat);
    }

    @Override
    public void Comer(Comida comida) {
        if(comida == Comida.Pescado){
            System.out.println("Comiendome mi Pescadito :)");
        }
        else{
            System.out.println("NO ME GUSTAA");
        }
    }

    @Override
    public void MeterSonido() {
        System.out.println("CRIIRIRIIRXIXIIACI NO SE EL SONIDO QUE METE XD");
    }

}
