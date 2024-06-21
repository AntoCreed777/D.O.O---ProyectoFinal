package Logica;

import Logica.Animales.Animal;
import Logica.Comida;

import java.util.ArrayList;
import java.util.List;

public class Habitat {

    private final TipoHabitat tipoHabitat;
    private int[] temperatura;
    private ArrayList<Animal> animalesResidentes;
    private ArrayList<Comida> depositoComida;


    public Habitat(TipoHabitat tipo){
        tipoHabitat = tipo;
        animalesResidentes = new ArrayList<Animal>();
    }

    public void agregarAnimales(Animal animales){
        animalesResidentes.add(animales);
    }
    public Object sacarAnimales(Animal animal){
        int index = animalesResidentes.indexOf(animal); // requiere un equals bien definido en animal
        return animalesResidentes.get(index);
    }

    public List<Animal> getAnimalesResidentes(){
        return animalesResidentes;
    }

    public Comida comer(Comida comida){

        int index = depositoComida.indexOf(comida); // requiere un equals bien definido en animal
        return depositoComida.get(index);
    }
}
