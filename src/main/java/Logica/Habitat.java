package Logica;

import Interfaz.Animal_Y_Comida.AccesorioGrafico;
import Interfaz.Animal_Y_Comida.AnimalGrafico;
import Interfaz.Animal_Y_Comida.ComidaGrafica;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Habitat {

    protected Color backgroundColor;
    protected Color editPanelColor;
    protected Color btnColor ;
    protected Color btnMarginColor;
    protected String backgroundImg;

    protected final ArrayList<AnimalGrafico> listaAnimales;
    protected final List<ComidaGrafica> listaComida;
    protected final List<AccesorioGrafico> listaAccesorios;

    public Habitat(){
        listaAnimales = new ArrayList<AnimalGrafico>();
        this.listaComida = Collections.synchronizedList(new ArrayList<>());
        this.listaAccesorios = Collections.synchronizedList(new ArrayList<>());
    }



    public Color getBackgroundColor() {return backgroundColor;}
    public Color getEditPanelColor(){return editPanelColor;}
    public Color getBtnColor(){return btnColor;}
    public Color getBtnMarginColor(){return btnMarginColor;}
    public String getBackgroundImg(){return backgroundImg;}
    public List<AnimalGrafico> getListaAnimales(){return listaAnimales;}

    public synchronized List<ComidaGrafica> getListaComida() {return listaComida;}
    public synchronized List<AccesorioGrafico> getListaAccesorios() { return listaAccesorios;}

}
