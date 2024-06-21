package Logica.Animales;

import Interfaz.PanelPrincipal;
import Logica.Comida;

import javax.swing.*;

public class Leon extends Animal{
    public final static String familiaTaxonomica = "Felino";
    public final static int temperaturaAdecuada = 28; //Grados Celcius

    public Leon(int posicionXinicial, int posicionYinicial, PanelPrincipal panelHabitat){
        super(posicionXinicial, posicionYinicial, panelHabitat);
    }

    @Override
    public void Comer(Comida comida){
        if(comida == Comida.Carne){
            System.out.println("Comiendo la carne, YAM YAM :)");
        }
        else{
            System.out.println("Que asco, no me gusta");
        }
    }

    @Override
    public void MeterSonido() {
        System.out.println("RRRROOOOOOAAAAARRRRR");
    }

}
