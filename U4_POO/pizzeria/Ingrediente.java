package pizzeria;

/**
 *
 */
public class Ingrediente {
    private String nombre;
    private double caloria;

    /**
     *
     * @param nombre
     * @param caloria
     */
    public Ingrediente(String nombre, double caloria) {
        this.nombre = nombre;
        this.caloria = caloria;
    }

    /**
     *
     */
    public Ingrediente() {
        this.nombre = "Queso";
        this.caloria = 250;
    }

    /**
     *
     * @return
     */
    public double getCaloria() {
        return caloria;
    }

    public String getNombre() {
        return nombre;
    }
}
