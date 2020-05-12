package garaje;

import java.util.Objects;

abstract class Terrestre extends Vehiculo implements Comparable {

    /**
     * Atributos clase Terrestre
     */
    private String matricula;
    private int aniomatricula;
    protected enum Color{AZUL, AMARILLO, ROJO, VERDE};
    private Color color;


    /**
     * Constructor de la clase Terrestre
     *
     * @param nombre
     * @param numPlazas
     * @param matricula
     * @param aniomatricula
     * @param color
     */
    public Terrestre(String nombre, int numPlazas, String matricula, int aniomatricula, Color color) {
        super(nombre, numPlazas);
        this.matricula = matricula;
        this.aniomatricula = aniomatricula;
        this.color = color;
    }

    /**
     * Método para obtener info
     *
     * @return
     */
    @Override
    public String toString() {
        return  super.toString() +
                "matricula = " + matricula + '\'' +
                ", aniomatricula = " + aniomatricula +
                ", color = " + color;
    }

    /**
     * Método para comparar por matrícula
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Terrestre terrestre = (Terrestre) o;
        return matricula.equals(terrestre.matricula);
    }

    /**
     * Método de la interfaz de la Comparable
     */
    public int compareTo(Object o) {
        // Terrestre t = (Terrestre) o;
        return (this.getMatricula().compareTo(((Terrestre) o).getMatricula()));
    }

    //Setter y Getter
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAniomatricula() {
        return aniomatricula;
    }

    public void setAniomatricula(int aniomatricula) {
        this.aniomatricula = aniomatricula;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

