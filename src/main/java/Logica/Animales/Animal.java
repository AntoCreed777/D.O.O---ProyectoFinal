package Logica.Animales;

import java.awt.*;
import java.util.Random;

import Interfaz.Habitat.PanelHabitat;
import Logica.Comida;

public abstract class Animal {
    private int posicionX;
    private int posicionY;
    private int anchoImg;
    private int altoImg;
    private final PanelHabitat panelHabitat;      //Panel del habitat al que pertenece el animal


    public Animal(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat) {
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
                if(posicionY + altoImg < panelHabitat.getHeight()){
                    posicionY+=1;
                }
                break;
            case 2: //Este
                if(posicionX + anchoImg < panelHabitat.getWidth()){
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

    public PanelHabitat getPanelHabitat() {return panelHabitat;}

    public int getPosicionX() {return posicionX;}
    public int getPosicionY() {return posicionY;}

    public void setAnchoImg(int anchoImg){this.anchoImg = anchoImg;}
    public void setAltoImg(int altoImg){this.altoImg = altoImg;}

    public abstract void MeterSonido();

    public abstract void Comer(Comida comida);
}
