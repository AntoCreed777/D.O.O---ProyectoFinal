package Interfaz;

import java.util.ArrayList;

public class HebraAnimales implements Runnable{
    private final ArrayList<AnimalGrafico> animales;
    private volatile boolean running;
    private final int sleep;

    public HebraAnimales(int sleep){
        animales = new ArrayList<>();
        running = true;
        this.sleep = sleep;
    }

    public void addAnimal(AnimalGrafico animal){animales.add(animal);}

    public ArrayList<AnimalGrafico> getAnimal(){return animales;}

    public void run(){
        try {
            while (running) {
                for (AnimalGrafico animal : animales) {
                    animal.Moverse();
                }
                Thread.sleep(sleep);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop(){running = false;}
}
