package Interfaz.Animal_Y_Comida;

import Interfaz.GeneradorImagen;
import Interfaz.Habitat.HabitatGrafico;
import Interfaz.Habitat.PanelHabitat;
import Logica.Comida;

import javax.swing.*;

public class ComidaGrafica implements GeneradorImagen, Runnable{
    private final PanelHabitat panelHabitat;
    private final JLabel label;
    private final Comida comida;
    private int posicionX;
    private int posicionY;

    public ComidaGrafica(Comida comida, int posicionX, int posicionY, PanelHabitat panelHabitat){
        this.panelHabitat = panelHabitat;
        this.comida = comida;
        this.posicionX = posicionX - 50;
        this.posicionY = posicionY - 50;
        this.label = GeneradorImagen.ImageLabel(comida.getImagen(), posicionX, posicionY,100,100);
    }

    public JLabel getLabel() {return this.label;}
    public Comida getComida() {return this.comida;}
    public int getPosicionX() {return this.posicionX;}
    public int getPosicionY() {return this.posicionY;}
    public PanelHabitat getPanelHabitat() {return panelHabitat;}

    @Override
    public void run() {
        int posicionY = this.posicionY - 100;   //Lo muevo 100 pixeles arriba de donde debe aparecer

        while(this.posicionY != posicionY){
            this.label.setBounds(this.posicionX, posicionY, 100, 100);
            panelHabitat.repaint();
            posicionY++;

            try {Thread.sleep(10);}
            catch (InterruptedException e) {throw new RuntimeException(e);}

        }
        synchronized (panelHabitat.getContenidoComida()) {
            panelHabitat.getContenidoComida().add(this);    //Cuando llega al suelo se agrega a la lista
        }

    }
}
