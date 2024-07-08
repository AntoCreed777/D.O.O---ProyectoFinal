package Logica.Excepciones;

/**
 * DemaciadosAnimales es una subclase de Exception que ocurre
 * cuando se trata de ingresar un animal dentro de un habitat lleno
 * @author Antonio Benavides
 */
public class DemasiadosAnimales extends Exception{

    /**
     * Constructor que ingresa el mensaje de error
     */
    public DemasiadosAnimales(){
        super("No se pueden colocar mas de 20 animales en un solo habitat, este habitat ya se lleno");
    }
}
