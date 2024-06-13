package Logica.Animales;

import javax.swing.*;
import java.util.Random;

import Logica.Comidas.*;

public abstract class Animal {
    private int posicionX;
    private int posicionY;
    private final int pantallaLimiteInferior;
    private final int pantallaLimiteDerecho;


    public Animal(int posicionXinicial, int posicionYinicial, JPanel panelHabitat) {
        pantallaLimiteInferior = panelHabitat.getPreferredSize().height;
        pantallaLimiteDerecho = panelHabitat.getPreferredSize().width;
    }

    public int getPosicionX() {return posicionX;}
    public int getPosicionY() {return posicionY;}

    public abstract void Comer(Comida comida);

    public void Moverse(){      //FALTA TERMINAR DE IMPLEMENTAR  //Por ahora solo velocidad uniforme
        Random rand = new Random();

        int direccion = rand.nextInt(4);
        switch(direccion){  //Tener en cuenta el origen de las coordenadas de la interfaz
            case 0: //Norte
                if(posicionY > 0){
                    posicionY-=1;
                }
            case 1: //Sur
                if(posicionY < pantallaLimiteInferior){
                    posicionY+=1;
                }
            case 2: //Este
                if(posicionX < pantallaLimiteDerecho){
                    posicionX+=1;
                }
            case 3: //Oeste
                if(posicionX > 0){
                    posicionX-=1;
                }
        }
    }

    public abstract void MeterSonido();

}
