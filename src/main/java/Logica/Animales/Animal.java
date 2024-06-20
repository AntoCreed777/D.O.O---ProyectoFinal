package Logica.Animales;

import javax.swing.*;
import java.util.Random;

import Logica.Comida;

public abstract class Animal {
    private int posicionX;
    private int posicionY;
    private final int pantallaLimiteInferior;
    private final int pantallaLimiteDerecho;
    private final JPanel panelHabitat;      //Panel del habitat al que pertenece el animal


    public Animal(int posicionXinicial, int posicionYinicial, JPanel panelHabitat) {
        this.pantallaLimiteInferior = panelHabitat.getPreferredSize().height - 1;
        this.pantallaLimiteDerecho = panelHabitat.getPreferredSize().width - 1;
        this.posicionX = posicionXinicial;
        this.posicionY = posicionYinicial;
        this.panelHabitat = panelHabitat;
    }

    public void Moverse(){
        Random rand = new Random();

        int direccion = rand.nextInt(4);
        switch(direccion){  //Tener en cuenta el origen de las coordenadas de la interfaz
            case 0: //Norte
                if(posicionY > 0){
                    posicionY-=1;
                }
                break;
            case 1: //Sur
                if(posicionY < pantallaLimiteInferior){
                    posicionY+=1;
                }
                break;
            case 2: //Este
                if(posicionX < pantallaLimiteDerecho){
                    posicionX+=1;
                }
                break;
            case 3: //Oeste
                if(posicionX > 0){
                    posicionX-=1;
                }
                break;
        }
    }

    public JPanel getPanelHabitat() {return panelHabitat;}

    public int getPosicionX() {return posicionX;}
    public int getPosicionY() {return posicionY;}

    public abstract void MeterSonido();

    public abstract void Comer(Comida comida);
}
