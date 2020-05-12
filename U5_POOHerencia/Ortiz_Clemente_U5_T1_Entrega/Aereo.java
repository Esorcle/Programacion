package garaje;

abstract class Aereo extends Vehiculo {

    /**
     * Atributos
     */
    private float altitud;
    private String oaci;

    /**
     * Constructor
     * @param nombre
     * @param numPlazas
     * @param oaci
     */
    public Aereo(String nombre, int numPlazas, String oaci) {
        super(nombre, numPlazas);
        this.altitud = 0;
        this.oaci = oaci;
    }

    /**
     * Método para obtener información sobre un vehículo aéreo
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + " altitud = " + altitud +
                ", oaci = " + oaci + '\'' +
                '}';
    }

    //Getter y Setter
    public float getAltitud() {
        return altitud;
    }

    public void setAltitud(float altitud) {
        this.altitud = altitud;
    }

    public String getOaci() {
        return oaci;
    }

    public void setOaci(String oaci) {
        this.oaci = oaci;
    }
}
