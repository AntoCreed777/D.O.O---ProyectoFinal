package Interfaz.ObjetosGraficos;

import Interfaz.imagenes.GeneradorImagen;
import Logica.Animales.*;
import Logica.Excepciones.FaltaComidaParaAnimal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;

/**
 * Clase que muestra de forma grafica un animal
 */
public class AnimalGrafico implements GeneradorImagen, Runnable {
    private final String imagen;
    private JLabel label;
    private final int widthMax;
    private final int heightMax;
    private final int widthMin;
    private final int heightMin;
    private final Animal animal;
    private Boolean running = true;

    private Timer timer;
    private TimerTask timerTask;
    private final int tiempoLimite = 10;
    private int tiempoFaltante;

    /**
     * Constructor en donde se carga la imagen que representa al animal y se guarda al animal
     * @param animal    Animal que representara esta clase
     */
    public AnimalGrafico(Animal animal){
        this.animal = animal;
        this.imagen = animal.getImagen();

        /*
        switch (animal) {
            case Leon leon -> {
                widthMax = 100;
                heightMax = 100;
                widthMin = 80;
                heightMin = 80;
            }
            case Pinguino pinguino -> {
                widthMax = 100;
                heightMax = 100;
                widthMin = 80;
                heightMin = 80;
            }
            case Vaca vaca -> {
                widthMax = 100;
                heightMax = 100;
                widthMin = 80;
                heightMin = 80;
            }
            case null, default -> {
                widthMax = 0;
                heightMax = 0;
                widthMin = 0;
                heightMin = 0;
            }
        }
         */
        // Tamaños estándar del animal
        widthMax = 100;
        heightMax = 100;
        widthMin = 80;
        heightMin = 80;

        label = GeneradorImagen.ImageLabel(imagen,animal.getPosicionX(),animal.getPosicionY(),
                widthMin, heightMin);

        animal.setAltoImg(heightMax);
        animal.setAnchoImg(widthMax);

        startTimer();
    }

    /**
     * Método que controla el movimiento del animal y su interacción con la comida en el panel de hábitat
     */
    @Override
    public void run() {
        try {
            while (running) {
                //Proceso de movimiento del Animal
                this.animal.Moverse();
                label.setBounds(animal.getPosicionX(),animal.getPosicionY(), widthMax, heightMax);
                this.animal.getPanelHabitat().repaint();

                //Zona en que alcanza la comida el animal (Su hitbox)
                Rectangle rectangleA = this.label.getBounds();

                //Lista de la comida disponible dentro del habitat
                List<ComidaGrafica> comidas = this.animal.getPanelHabitat().getHabitat().getListaComida();

                synchronized(comidas){
                    Iterator<ComidaGrafica> iterator = comidas.iterator();
                    while(iterator.hasNext()){
                        ComidaGrafica comida = iterator.next();
                        Rectangle rectangleC = comida.getLabel().getBounds();
                        if(rectangleC.intersects(rectangleA)){
                            //Come su comida
                            if(this.animal.Comer(comida.getComida())){
                                this.animal.MeterSonido();
                                this.animal.getPanelHabitat().remove(comida.getLabel());
                                iterator.remove();
                                resetTimer();
                            }
                            this.animal.getPanelHabitat().repaint();
                            break;
                        }
                    }
                }

                Thread.sleep(10);
            }
        }
        catch (InterruptedException e) {e.printStackTrace();}
    }

    /**
     * Funcion que se encarga de rePosicionar el label segun los limites del panel
     * al que pertenece
     * @param maximizado    Limite maximo del panel
     * @param minimizado    Limite minimo del panel
     */
    public void rePosicionar(Rectangle maximizado, Rectangle minimizado){animal.rePosicionar(maximizado, minimizado);}

    /**
     * Funcion que se encarga de redimensionar el label segun los limites del panel
     * al que pertenece
     * @param maximizado    Limite maximo del panel
     */
    public void reDimencionar(Rectangle maximizado){
        animal.getPanelHabitat().remove(label);
        if(maximizado.width == animal.getPanelHabitat().getWidth()) {    //Si se maximizo
            label = GeneradorImagen.ImageLabel(imagen, animal.getPosicionX(), animal.getPosicionY(), widthMax, heightMax);
        }
        else{   //Si se minimizo
            label = GeneradorImagen.ImageLabel(imagen, animal.getPosicionX(), animal.getPosicionY(), widthMin, heightMin);
        }
        animal.getPanelHabitat().add(label);
    }

    /**
     * Funcion que valida que el animal se encuentre dentro de los limites del panel en que
     * se muestra
     */
    public void validarPosicion(){animal.validarPosicion();}

    /**
     * getter para obtener la familia taxonómica a la que pertenece el animal
     * @return Retorna la familia taxonomica del animal
     */
    public Animal.FamiliaTaxonomica getFamiliaTaxonomica(){return animal.getFamiliaTaxonomica();}

    /**
     * Getter para obtener el JLabel que contiene la representación gráfica del animal
     * @return  Retorna la label que contiene esta clase
     */
    public JLabel getLabel(){return this.label;}

    /**
     * Setter establecer el estado del hilo de ejecución del animal
     * @param running   Estado que se desea implementar en el hilo
     */
    public void setRunning(Boolean running){this.running = running;}

    private void startTimer() {
        tiempoFaltante = tiempoLimite;

        timer = new Timer(1000, e -> {
            if (tiempoFaltante > 0) {tiempoFaltante--;}
            else {
                Exception exception = new FaltaComidaParaAnimal();
                JOptionPane.showMessageDialog(null, exception.getMessage());
                timer.stop();
            }
        });

        timer.setInitialDelay(0);
        timer.start();
    }

    private void resetTimer() {
        if (timer != null && timer.isRunning()) {timer.stop();}
        startTimer();
    }
}
