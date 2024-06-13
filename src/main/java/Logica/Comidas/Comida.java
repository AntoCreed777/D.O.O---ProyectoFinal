package Logica.Comidas;

public abstract class Comida {
    private final int id;

    public Comida(){
        this.id = this.hashCode();
    }

    public int getId() {return this.id;}
}
