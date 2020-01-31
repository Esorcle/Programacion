package garaje;

public class Coche extends Terrestre {
    /**
     * Constructor de la clase Terrestre para coche
     *
     * @param nombre
     * @param numPlazas
     * @param matricula
     * @param aniomatricula
     * @param color
     */
    public Coche(String nombre, int numPlazas, String matricula, int aniomatricula, Color color) {
        super(nombre, numPlazas, matricula, aniomatricula, color);
    }

}
