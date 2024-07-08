package Logica.Excepciones;

/**
 * FaltaComidaParaAnimal es una subclase de Exception que ocurre
 * cuando un animal lleva tiempo sin comer
 * @author Antonio Benavides
 */
public class FaltaComidaParaAnimal extends Exception{
    /**
     * Constructor que ingresa el mensaje de error
     */
    public FaltaComidaParaAnimal(){
        super("Un animal se esta quedando sin comida");
    }
}
