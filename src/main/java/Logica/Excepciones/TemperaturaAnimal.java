package Logica.Excepciones;

import Logica.Animales.Animal;

/**
 * TemperaturaAnimal es una subclase de Exception que ocurre
 * cuando se trata de ingresar un animal en un habitat con una temperatura inadecuada
 * @author Antonio Benavides
 */
public class TemperaturaAnimal extends Exception{

    /**
     * Se asigna el nombre de la familia de animales que se pueden colocar en el habitat
     */
    public TemperaturaAnimal(String nombre){
        super("No se puede ingresar un \"" + nombre + "\" en este habitat por temperatura");
    }
}
