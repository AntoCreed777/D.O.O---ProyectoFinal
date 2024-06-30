package Logica;

/**
 * Enumeracion que contiene todos los tipos de Habitats disponibles y las imagenes que las representan
 */
public enum TipoHabitat {
    DESERTICO(""),
    POLAR("src/main/java/Interfaz/imagenes/habitat_polar_1.jpg"),
    JUNGLA("");

    private final String imagen;

    /**
     * Constructor privado que asigna las direcciones de las imagenes de cada habitat al habitat
     * @param imagen
     */
    private TipoHabitat(String imagen) {this.imagen = imagen;}

    /**
     * Getter
     * @return  Funcion para retornar la imagen del habitat
     */
    public String getImagen(){return imagen;}
}
