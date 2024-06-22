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
    private int direccion = -1; //Pueden ser 8 direcciones
    //Norte=0, NorOeste=1, Oeste=2, SurOeste=3,
    //Sur=4, SurEste=5, Este=6, NorEste=7

    public Animal(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat) {
        this.panelHabitat = panelHabitat;
        this.posicionX = posicionXinicial;
        this.posicionY = posicionYinicial;
    }

    public void Moverse(){
        Random rand = new Random();
        if(direccion == -1){direccion = rand.nextInt(8);}

        switch(direccion){  //Tener en cuenta el origen de las coordenadas de la interfaz
            case 0: //Norte
                if(posicionY > 0){posicionY--;}
                else{
                    while(direccion == 0 || direccion == 1 || direccion == 7){
                        direccion = rand.nextInt(8);
                    }
                }
                break;
            case 1: //NorOeste
                if(posicionY > 0 && posicionX > 0){
                    posicionX--;
                    posicionY--;
                }
                else if (posicionY <=0 && posicionX <= 0) {direccion = 5;}
                else if(posicionY > 0){ //Choca en la pared izquierda
                    while(direccion == 1 || direccion == 2 || direccion == 3){
                        direccion = rand.nextInt(8);
                    }
                }
                else{ //Choca arriba
                    while(direccion == 0 || direccion == 1 || direccion == 7){
                        direccion = rand.nextInt(8);
                    }
                }
                break;
            case 2: //Oeste
                if(posicionX > 0){posicionX--;}
                else{
                    while(direccion == 2 || direccion == 1 || direccion == 3){
                        direccion = rand.nextInt(8);
                    }
                }
                break;
            case 3: //SurOeste
                if(posicionX > 0 && posicionY + altoImg < panelHabitat.getHeight()){
                    posicionX--;
                    posicionY++;
                }
                else if(posicionY <= 0 && posicionY + altoImg >= panelHabitat.getWidth()){direccion = 7;}
                else if(posicionX > 0){ //Choca abajo
                    while(direccion == 3 || direccion == 4 || direccion == 5){
                        direccion = rand.nextInt(8);
                    }
                }
                else{   //Choca a la izquierda
                    while(direccion == 1 || direccion == 2 || direccion == 3){
                        direccion = rand.nextInt(8);
                    }
                }
                break;
            case 4: //Sur
                if(posicionY + altoImg < panelHabitat.getHeight()){posicionY++;}
                else{
                    while(direccion == 4 || direccion == 3 || direccion == 5){
                        direccion = rand.nextInt(8);
                    }
                }
                break;
            case 5: //SurEste
                if(posicionY + altoImg < panelHabitat.getHeight() && posicionX + anchoImg < panelHabitat.getWidth()){
                    posicionX++;
                    posicionY++;
                }
                else if(posicionY + altoImg >= panelHabitat.getHeight() && posicionX + anchoImg >= panelHabitat.getWidth()){
                    direccion = 1;
                }
                else if (posicionY + altoImg < panelHabitat.getHeight()){   //Choca a la derecha
                    while(direccion == 5 || direccion == 6 || direccion == 7){
                        direccion = rand.nextInt(8);
                    }
                }
                else{   //Choca Abajo
                    while(direccion == 3 || direccion == 4 || direccion == 5){
                        direccion = rand.nextInt(8);
                    }
                }
                break;
            case 6: //Este
                if(posicionX + anchoImg < panelHabitat.getWidth()){posicionX++;}
                else{
                    while(direccion == 6 || direccion == 5 || direccion == 7){
                        direccion = rand.nextInt(8);
                    }
                }
                break;
            case 7: //NorEste
                if(posicionY > 0 && posicionX + anchoImg < panelHabitat.getWidth()){
                    posicionX++;
                    posicionY--;
                } else if (posicionY <= 0 && posicionX + anchoImg >= panelHabitat.getWidth()) {
                    direccion = 3;
                }
                else if (posicionY > 0){    //Choca en la pared derecha
                    while(direccion == 5 || direccion == 6 || direccion == 7){
                        direccion = rand.nextInt(8);
                    }
                }
                else{   //Choca en la pared de arriba
                    while(direccion == 1 || direccion == 0 || direccion == 7){
                        direccion = rand.nextInt(8);
                    }
                }
        }
    }

    public PanelHabitat getPanelHabitat() {return panelHabitat;}

    public int getPosicionX() {return posicionX;}
    public int getPosicionY() {return posicionY;}

    public void rePosicionar(Rectangle maximizado, Rectangle minimizado) {
        if (maximizado.width == panelHabitat.getWidth()) { // Si se maximizó
            posicionX = (int)(((double) posicionX / (double) minimizado.width) * maximizado.width);
            posicionY = (int)(((double) posicionY / (double) minimizado.height) * maximizado.height);
        }
        else { // Si se minimizó
            posicionX = (int)(((double) posicionX / (double) maximizado.width) * minimizado.width);
            posicionY = (int)(((double) posicionY / (double) maximizado.height) * minimizado.height);
            if(posicionX + anchoImg > minimizado.width){posicionX = minimizado.width - anchoImg;}
            if(posicionY + altoImg > minimizado.height){posicionY = minimizado.height - altoImg;}
        }
    }

    public void setAnchoImg(int anchoImg){this.anchoImg = anchoImg;}
    public void setAltoImg(int altoImg){this.altoImg = altoImg;}

    public void validarPosicion(){
        if(posicionX + anchoImg > panelHabitat.getWidth()){
            posicionX = panelHabitat.getWidth() - anchoImg;
        }
        if(posicionY + altoImg > panelHabitat.getHeight()){
            posicionY = panelHabitat.getHeight() - altoImg;
        }
    }

    public abstract void MeterSonido();

    public abstract void Comer(Comida comida);
}
