package Logica;

/**
 * Enumeracion que representa todos los tipos de Accesorios y sus respectivas imagenes
 */
public enum Accesorios {
    ARBOL(""),
    ROCA("src/main/java/Interfaz/imagenes/accesorio_roca_1.jpg"),
    PLANTA("");

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
