package org.example.Logica;

import java.util.ArrayList;

public class Habitat {

    private TipoHabitat tipoHabitat;
    private int[] temperatura;
    private ArrayList<Object> animalesResidentes;
    private ArrayList<Object> accesorios;
    private ArrayList<Object> depositoComida;

    public Habitat(TipoHabitat tipo){
        tipoHabitat = tipo;
        animalesResidentes = new ArrayList<Object>();
    }

    public void agregarAnimales(Object animales){
        animalesResidentes.add(animales);
    }
    public Object sacarAnimales(Object animal){
        int index = animalesResidentes.indexOf(animal); // requiere un equals bien definido en animal
        return animalesResidentes.get(index);
    }
}
