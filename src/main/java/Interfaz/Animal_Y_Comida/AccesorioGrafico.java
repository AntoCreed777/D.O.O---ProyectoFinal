package Interfaz.Animal_Y_Comida;

import Interfaz.GeneradorImagen;
import Interfaz.Habitat.PanelHabitat;
import Logica.Accesorios;
import Logica.Comida;

import javax.swing.*;
import java.awt.*;

public class AccesorioGrafico implements GeneradorImagen, Runnable{
    private final PanelHabitat panelHabitat;
    private JLabel label;
    private final Accesorios accesorio;
    private int posicionX;
    private int posicionY;
    private final int Max = 100;
    private final int Min = 80;

    public AccesorioGrafico(Accesorios accesorio, int posicionX, int posicionY, PanelHabitat panelHabitat){
        this.panelHabitat = panelHabitat;
        this.accesorio = accesorio;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.label = GeneradorImagen.ImageLabel(accesorio.getImagen(), posicionX, posicionY,Min,Min);
    }

    public JLabel getLabel() {return this.label;}
    public Accesorios getAccesorio() {return this.accesorio;}
    public int getPosicionX() {return this.posicionX;}
    public int getPosicionY() {return this.posicionY;}
    public PanelHabitat getPanelHabitat() {return panelHabitat;}

    @Override
    public void run() {
        int posicionY = this.posicionY - 100;   //Lo muevo 100 pixeles arriba de donde debe aparecer

        while(this.posicionY > posicionY){
            this.label.setBounds(this.posicionX, posicionY, 100, 100);
            panelHabitat.repaint();
            posicionY++;

            try {Thread.sleep(10);}
            catch (InterruptedException e) {throw new RuntimeException(e);}

        }
        synchronized (panelHabitat.getPlaneta().getListaAccesorios()) {
            panelHabitat.getPlaneta().getListaAccesorios().add(this);    //Cuando llega al suelo se agrega a la lista
        }

        while(true){
            label.setBounds(this.posicionX,this.posicionY,Max,Max);
            try{
                Thread.sleep(1);
            }
            catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }

    public void rePosicionarDimencionar(Rectangle maximizado, Rectangle minimizado) {
        panelHabitat.remove(label);
        if (maximizado.width == panelHabitat.getWidth()) { // Si se maximizó
            posicionX = (int)(((double) posicionX / (double) minimizado.width) * maximizado.width);
            posicionY = (int)(((double) posicionY / (double) minimizado.height) * maximizado.height);

            label = GeneradorImagen.ImageLabel(accesorio.getImagen(), posicionX, posicionY,Max,Max);

        }
        else { // Si se minimizó
            posicionX = (int)(((double) posicionX / (double) maximizado.width) * minimizado.width);
            posicionY = (int)(((double) posicionY / (double) maximizado.height) * minimizado.height);
            if(posicionX + Max > minimizado.width){posicionX = minimizado.width - Max;}
            if(posicionY + Max > minimizado.height){posicionY = minimizado.height - Max;}

            label = GeneradorImagen.ImageLabel(accesorio.getImagen(), posicionX, posicionY,Min,Min);
        }
        panelHabitat.add(label);
    }

    public void validarPosicion(){
        if(posicionX + 100 > panelHabitat.getWidth()){
            posicionX = panelHabitat.getWidth() - 100;
        }
        if(posicionY + 100 > panelHabitat.getHeight()){
            posicionY = panelHabitat.getHeight() - 100;
        }
    }
}
