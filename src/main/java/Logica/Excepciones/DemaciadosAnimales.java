package Logica.Excepciones;

import Logica.Animales.Animal;

/**
 * DemaciadosAnimales es una subclase de Exception que ocurre
 * cuando se trata de ingresar un animal dentro de un habitat lleno
 * @author Antonio Benavides
 */
public class DemaciadosAnimales extends Exception{

    /**
     * Se asigna el nombre de la familia de animales que se pueden colocar en el habitat
     */
    public DemaciadosAnimales(){
        super("No se pueden colocar mas de 20 animales en un solo habitat, este habitat ya se lleno");
    }
}
