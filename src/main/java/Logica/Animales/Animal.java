package Logica.Animales;

import java.awt.*;
import java.util.Random;

import Interfaz.Habitat.PanelHabitat;
import Interfaz.Sonidos.Sonido;
import Logica.Comida;

import javax.sound.sampled.Clip;

/**
 * Clase que representa a un Animal
 */
public abstract class Animal implements Sonido {
    private final FamiliaTaxonomica familiaTaxonomica;
    private int posicionX;
    private int posicionY;
    private int anchoImg;
    private int altoImg;
    private final PanelHabitat panelHabitat; //Panel del habitat al que pertenece el animal
    private int direccion = -1; //Pueden ser 8 direcciones
    //Norte=0, NorOeste=1, Oeste=2, SurOeste=3,
    //Sur=4, SurEste=5, Este=6, NorEste=7
    private final Clip sonido;
    private final String imagen;
    private final Comida comida;

  /**
     * Constructor que inicia las variables
     * @param posicionXinicial  Posicion X en que aparecera el animal
     * @param posicionYinicial  Posicion Y en que aparecera el animal
     * @param panelHabitat      Panel al que pertenecera el animal
     * @param familiaTaxonomica Familia taxonomica a la que pertenece el Animal
     * @param comida            Tipo de comida que consume el animal
     * @param imagen            Imagen que representa al animal
     * @param sonido            Sonido que emite el animal
     */
    public Animal(int posicionXinicial, int posicionYinicial, PanelHabitat panelHabitat, FamiliaTaxonomica familiaTaxonomica, Comida comida,Imagenes imagen ,Sonidos sonido) {
        this.panelHabitat = panelHabitat;
        this.posicionX = posicionXinicial;
        this.posicionY = posicionYinicial;
        this.familiaTaxonomica = familiaTaxonomica;
        this.comida = comida;
        this.imagen = imagen.getImagen();
        this.sonido = sonido.getSonido();
    }

    /**
     * numeración que representa las imágenes de los animales
     */
    public enum Imagenes{
        Caballo("src/main/java/Interfaz/imagenes/Animales/Tierra/Caballo.png"),
        Leon("src/main/java/Interfaz/imagenes/Animales/Tierra/Leon.png"),
        Nutria("src/main/java/Interfaz/imagenes/Animales/Tierra/Nutria.png"),
        Pinguino("src/main/java/Interfaz/imagenes/Animales/Tierra/Pinguino.png"),
        Tigre("src/main/java/Interfaz/imagenes/Animales/Tierra/Tigre.png"),
        Vaca("src/main/java/Interfaz/imagenes/Animales/Tierra/Vaca.png"),
        AlienX("src/main/java/Interfaz/imagenes/Animales/Marte/AlienX.png"),
        Aracne("src/main/java/Interfaz/imagenes/Animales/Marte/Aracne.png"),
        AsgardianoSG1("src/main/java/Interfaz/imagenes/Animales/Marte/AsgardianoSG1.png"),
        Depredador("src/main/java/Interfaz/imagenes/Animales/Marte/Depredador.png"),
        Goauld("src/main/java/Interfaz/imagenes/Animales/Marte/Goauld.png"),
        ReplicanteSG1("src/main/java/Interfaz/imagenes/Animales/Marte/ReplicanteSG1.png");

        private final String imagen;
        private Imagenes(String imagen) {this.imagen = imagen;}

        public String getImagen() {return imagen;}
    }

    /**
     * Enumeración que representa los sonidos de los animales
     */
    protected enum Sonidos{
        Caballo("src/main/java/Interfaz/Sonidos/Tierra/Caballo.wav"),
        Leon("src/main/java/Interfaz/Sonidos/Tierra/Leon.wav"),
        Nutria("src/main/java/Interfaz/Sonidos/Tierra/Nutria.wav"),
        Pinguino("src/main/java/Interfaz/Sonidos/Tierra/Pinguino.wav"),
        Tigre("src/main/java/Interfaz/Sonidos/Tierra/Tigre.wav"),
        Vaca("src/main/java/Interfaz/Sonidos/Tierra/Vaca.wav"),
        AlienX("src/main/java/Interfaz/Sonidos/Marte/AlienX.wav"),
        Aracne("src/main/java/Interfaz/Sonidos/Marte/Aracne.wav"),
        AsgardianoSG1("src/main/java/Interfaz/Sonidos/Marte/AsgardianoSG1.wav"),
        Depredador("src/main/java/Interfaz/Sonidos/Marte/Depredador.wav"),
        Goauld("src/main/java/Interfaz/Sonidos/Marte/Goauld.wav"),
        ReplicanteSG1("src/main/java/Interfaz/Sonidos/Marte/ReplicanteSG1.wav");

        private final Clip sonido;
        private Sonidos(String direccion) {this.sonido = Sonido.cargarSonido(direccion);}

        public Clip getSonido() {return sonido;}
    }

    /**
     * Enumeración que representa las familias taxonómicas de los animales
     */
    public enum FamiliaTaxonomica{
        Campo(),
        Felino(),
        Acuatico(),
        RazaSuperior(),
        RazaInteligente(),
        InsectoAnsestral();
    }
    /**
     * Funcion que mueve al animal calculando la posicion en el tiempo t+1
     */
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

    /**
     * Funcion que reposiciona al Animal dependiendo de los límites del habitat al que pertenece
     * @param maximizado    Limite maximo del habitat
     * @param minimizado    Limite minimo del habitat
     */
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

    /**
     * Setter para el ancho de la imagen que representa al animal
     * @param anchoImg  Ancho de la imagen
     */
    public void setAnchoImg(int anchoImg){this.anchoImg = anchoImg;}

    /**
     * Setter para el alto de la imagen que representa al animal
     * @param altoImg  Alto de la imagen
     */
    public void setAltoImg(int altoImg){this.altoImg = altoImg;}

    /**
     * Funcion que valida que el animal no se encuentre fuera del habitat
     */
    public void validarPosicion(){
        if(posicionX + anchoImg > panelHabitat.getWidth()){
            posicionX = panelHabitat.getWidth() - anchoImg;
        }
        if(posicionY + altoImg > panelHabitat.getHeight()){
            posicionY = panelHabitat.getHeight() - altoImg;
        }
    }

    /**
     * Funcion que permite emitir sonidos al animal
     */
    public void MeterSonido(){Sonido.reproducirSonido(sonido,() -> {});}

    /**
     * Funcion que permite que el animal coma
     * @param comida    Comida que trata de comer
     * @return  Retorna si se comio o no la comida (True or False)
     */
    public boolean Comer(Comida comida){return comida == this.comida;}

    /**
     * Getter para la familia taxonómica a la que pertenece el Animal
     * @return Retorna la familia Taxonomica
     */
    public FamiliaTaxonomica getFamiliaTaxonomica(){return familiaTaxonomica;}

    /**
     * Getter para el panelHabitaten que se muestra al animal
     * @return  Retorna el panelHabitat
     */
    public PanelHabitat getPanelHabitat() {return panelHabitat;}

    /**
     * Getter para la posición X en que se encuentra el animal
     * @return  Retorna la posicion X
     */
    public int getPosicionX() {return posicionX;}

    /**
     * Getter  para la posición y en que se encuentra el animal
     * @return  Retorna la posicion Y
     */
    public int getPosicionY() {return posicionY;}

    /**
     * Getter para la imagen que representa a este animal
     * @return Retorna la imagen
     */
    public String getImagen(){return imagen;}

    /**
     * Getter para la comida que consume este animal
     * @return Retorna la comida
     */
    public Comida getComida(){return comida;}
}
