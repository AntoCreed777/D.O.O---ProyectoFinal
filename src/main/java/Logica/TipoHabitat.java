package Logica;

public enum TipoHabitat {
    DESERTICO(""),
    POLAR("src/main/java/Interfaz/imagenes/habitat_polar_1.jpg"),
    JUNGLA("");

    private final String imagen;
    private TipoHabitat(String imagen) {this.imagen = imagen;}

    public String getImagen(){return imagen;}
}
