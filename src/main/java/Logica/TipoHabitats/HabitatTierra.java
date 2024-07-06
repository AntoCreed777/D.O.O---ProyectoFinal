package Logica.TipoHabitats;

import Logica.Animales.Animal;
import Logica.Habitat;
import static Logica.Animales.Animal.Imagenes.*;

import java.awt.*;

/**
 * SubClase que representa a un habitat del Planeta Tierra
 */
public class HabitatTierra extends Habitat {
    private int[] temperatura;

    /**
     * Constructor que configura las variables
     */
    public HabitatTierra(TipoHabitat tipoHabitat){
        super(tipoHabitat,
                new Animal.Imagenes[]{
                    Leon, Vaca, Nutria, Caballo, Pinguino, Tigre
                }
        );
        super.backgroundColor = new Color(0xF6FFEC);
        super.editPanelColor = new Color(0x68B0AB);
        super.btnColor = new Color(0xFAF3DD);
        super.btnMarginColor = new Color(0xBABABA);
        temperatura = new int[]{0, 100};
    }

    /**
     * Funcion que establece la Temperatura mminima y maxima dentro del habitat
     * @param minimo    Temperatura minima dentro del habitat
     * @param maximo    Temperatura maxima dentro del habitat
     */
    public void setTemperatura(int minimo, int maximo){
        temperatura[0] = minimo;
        temperatura[1] = maximo;
    }

    public enum TipoHabitat implements HabitatTipo {
        DESERTICO("src/main/java/Interfaz/imagenes/Habitats/Tierra/habitat_desertico_1.jpg"),
        POLAR("src/main/java/Interfaz/imagenes/Habitats/Tierra/habitat_polar_1.jpg"),
        JUNGLA("src/main/java/Interfaz/imagenes/Habitats/Tierra/habitat_jungla_1.jpg");

        private final String imagen;
        private TipoHabitat(String imagen) {this.imagen = imagen;}

        @Override
        public String getImagen(){return imagen;}
    }


    /**
     * Enumeracion que representa todos los tipos de Accesorios y sus respectivas imagenes
     */
    public enum Accesorios implements AccesoriosTipo {

        ARBOL("src/main/java/Interfaz/Imagenes/Accesorios/accesorio_tierra_arbol.png"),
        ROCA("src/main/java/Interfaz/Imagenes/Accesorios/accesorio_tierra_roca.png"),
        PLANTA("src/main/java/Interfaz/Imagenes/Accesorios/accesorio_tierra_planta.png");


        private final String imagen;

        /**
         * Constructor privado que asigna las imagenes a los Accesorios
         * @param imagen    Imagen que representa a los Accesorios
         */
        private Accesorios(String imagen) {this.imagen = imagen;}

        /**
         * Getter
         * @return  Retorna la imagen que representa a los Accesorios
         */
        public String getImagen(){return imagen;}
    }

}
