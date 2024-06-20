package Interfaz;

import Logica.Comida;

import javax.swing.*;

public class ComidaGrafica implements GeneradorImagen, Runnable{
    private final PanelPrincipal panelHabitat;
    private final JLabel label;
    private final Comida comida;
    private int posicionX;
    private int posicionY;

    public ComidaGrafica(Comida comida, int posicionX, int posicionY, PanelPrincipal panelHabitat){
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
    public JPanel getPanelHabitat() {return panelHabitat;}

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
        panelHabitat.getContenidoComida().add(this);    //Cuando llega al suelo se agrega a la lista
    }
}
