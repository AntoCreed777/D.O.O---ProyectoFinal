package Logica;

public enum Accesorios {
    ARBOL(""),
    ROCA("src/main/java/Interfaz/imagenes/accesorio_roca_1.jpg"),
    PLANTA("");

    private final String imagen;
    private Accesorios(String imagen) {this.imagen = imagen;}

    public String getImagen(){return imagen;}
}
