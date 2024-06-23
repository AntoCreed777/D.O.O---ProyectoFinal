package Logica.Animales;

import Interfaz.Habitat.PanelHabitat;
import Logica.Comida;

public class Leon extends Animal{
    public final static int temperaturaAdecuada = 28; //Grados Celcius

    public Leon(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat, "Felino");
    }

    @Override
    public boolean Comer(Comida comida){
        if(comida == Comida.Carne){
            System.out.println("Comiendo la carne, YAM YAM :)");
            return true;
        }
        else{
            System.out.println("Que asco, no me gusta");
            return false;
        }
    }

    @Override
    public void MeterSonido() {
        System.out.println("RRRROOOOOOAAAAARRRRR");
    }

}
