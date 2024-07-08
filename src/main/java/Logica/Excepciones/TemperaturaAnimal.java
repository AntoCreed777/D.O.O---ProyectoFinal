package Logica.Excepciones;

/**
 * TemperaturaAnimal es una subclase de Exception que ocurre
 * cuando se trata de ingresar un animal en un habitat con una temperatura inadecuada
 * @author Antonio Benavides
 */
public class TemperaturaAnimal extends Exception{

    /**
     * Constructor que ingresa el mensaje de error
     */
    public TemperaturaAnimal(String nombre){
        super("No se puede ingresar un \"" + nombre + "\" en este habitat por temperatura");
    }
}
