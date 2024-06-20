package Logica.Animales;

import Logica.Comida;

import javax.swing.*;

public class Vaca extends Animal{
    public final static String familiaTaxonomica = "Ave";
    public final static int temperaturaAdecuada = 24; //Grados Celcius

    public Vaca(int posicionXinicial, int posicionYinicial, JPanel panelHabitat) {
        super(posicionXinicial, posicionYinicial, panelHabitat);
    }

    @Override
    public void Comer(Comida comida) {
        if(comida == Comida.Pasto){
            System.out.println("Que rico, pasto amarillo");
        }
        else{
            System.out.println("Qeu rico, aire, na mentira, esto apesta :(");
        }
    }

    @Override
    public void MeterSonido() {
        System.out.println("MUUUUUUUUUUU MUUUUUUUUUUUU");
    }

}
