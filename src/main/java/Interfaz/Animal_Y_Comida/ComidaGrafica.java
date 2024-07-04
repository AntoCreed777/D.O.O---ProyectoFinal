package Interfaz.Animal_Y_Comida;

import Interfaz.imagenes.GeneradorImagen;
import Interfaz.Habitat.PanelHabitat;
import Logica.Comida;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que muestra de forma grafica la comida
 */
public class ComidaGrafica implements GeneradorImagen, Runnable{
    private final PanelHabitat panelHabitat;
    private JLabel label;
    private final Comida comida;
    private int posicionX;
    private int posicionY;
    private final int Max = 100;
    private final int Min = 80;
    private Boolean running = true;

    /**
     * Contructor en donde se inician variables
     * @param comida    Comida que representara al instanciarse
     * @param posicionX Posicion X en donde se mostrara el accesorio
     * @param posicionY Posicion Y en donde se mostrara el accesorio
     * @param panelHabitat  Panel en donde se mostrara este accesorio
     */
    public ComidaGrafica(Comida comida, int posicionX, int posicionY, PanelHabitat panelHabitat){
        this.panelHabitat = panelHabitat;
        this.comida = comida;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.label = GeneradorImagen.ImageLabel(comida.getImagen(), posicionX, posicionY,Min,Min);
    }

    /**
     * Funcion que muestra la caida de la Comida y su posterior muestra estatica en el panel
     */
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
        synchronized (panelHabitat.getHabitat().getListaComida()) {
            panelHabitat.getHabitat().getListaComida().add(this);    //Cuando llega al suelo se agrega a la lista
        }

        while(running){
            label.setBounds(this.posicionX,this.posicionY,Max,Max);
            try{
                Thread.sleep(1);
            }
            catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }

    /**
     * Funcion que se encarga de redimensionar y rePosicionar el label segun los limites del panel
     * al que pertenece
     * @param maximizado    Limite maximo del panel
     * @param minimizado    Limite minimo del panel
     */
    public void rePosicionarDimencionar(Rectangle maximizado, Rectangle minimizado) {
        panelHabitat.remove(label);
        if (maximizado.width == panelHabitat.getWidth()) { // Si se maximizó
            posicionX = (int)(((double) posicionX / (double) minimizado.width) * maximizado.width);
            posicionY = (int)(((double) posicionY / (double) minimizado.height) * maximizado.height);

            label = GeneradorImagen.ImageLabel(comida.getImagen(), posicionX, posicionY,Max,Max);

        }
        else { // Si se minimizó
            posicionX = (int)(((double) posicionX / (double) maximizado.width) * minimizado.width);
            posicionY = (int)(((double) posicionY / (double) maximizado.height) * minimizado.height);
            if(posicionX + Max > minimizado.width){posicionX = minimizado.width - Max;}
            if(posicionY + Max > minimizado.height){posicionY = minimizado.height - Max;}

            label = GeneradorImagen.ImageLabel(comida.getImagen(), posicionX, posicionY,Min,Min);
        }
        panelHabitat.add(label);
    }

    /**
     * Funcion que valida que la Comida se encuentre dentro de los limites del panel en que
     * se muestra
     */
    public void validarPosicion(){
        if(posicionX + 100 > panelHabitat.getWidth()){
            posicionX = panelHabitat.getWidth() - 100;
        }
        if(posicionY + 100 > panelHabitat.getHeight()){
            posicionY = panelHabitat.getHeight() - 100;
        }
    }

    /**
     * Getter
     * @return  Se retorna la label que contiene la clase
     */
    public JLabel getLabel() {return this.label;}

    /**
     * Getter
     * @return  Retorna la Comida que contiene
     */
    public Comida getComida() {return this.comida;}

    /**
     * Getter
     * @return  Retorna la Posicion X del Label
     */
    public int getPosicionX() {return this.posicionX;}

    /**
     * Getter
     * @return  Retorna la Posicion Y del Label
     */
    public int getPosicionY() {return this.posicionY;}

    /**
     * Getter
     * @return  Se retorna el panel en que se muestra/pertenece el accesorio
     */
    public PanelHabitat getPanelHabitat() {return panelHabitat;}

    /**
     * Setter
     * @param running   Estado que se desea implementar en el hilo
     */
    public void setRunning(Boolean running){this.running = running;}

}
