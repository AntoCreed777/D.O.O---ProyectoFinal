package Logica.Excepciones;

/**
 * FaltaComidaParaAnimal es una subclase de Exception que ocurre
 * cuando un animal lleva tiempo sin comer
 * @author Antonio Benavides
 */
public class FaltaComidaParaAnimal extends Exception{
    /**
     * Se asigna el nombre de la familia de animales que se pueden colocar en el habitat
     */
    public FaltaComidaParaAnimal(){
        super("Un animal se esta quedando sin comida");
    }
}
