package garaje;

abstract class Vehiculo {
    /**
     * Atributos de la clase Vehículo
     */
    private String nombre;
    private int numPlazas;
    private int numPersonas;

    /**
     * Constructor
     * @param nombre
     * @param numPlazas
     */
    public Vehiculo(String nombre, int numPlazas) {
        this.nombre = nombre;
        this.numPlazas = numPlazas;
        this.numPersonas = 0;
    }

    /**
     * Método que muestra la información de los vehículos
     * @return
     */
    @Override
    public String toString() {
        return   '\n' + "Tipo = " + getClass().getSimpleName() + " nombre = " + nombre + '\'' +
                ", numPersonas = " + numPlazas ;
    }

    /**
     * Método para ver si se pueden transportar los pasajeros
     * @param numPersonas
     * @return
     */
    public String transportar(int numPersonas){
        if(numPersonas > this.numPlazas) {
            return "No pueden ir todos";
        } else {
            this.numPersonas = numPersonas;
            return "¡Vamonos de viaje!";
        }
    }

    //Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumPersonas() {
        return numPlazas;
    }

    public void setNumPersonas(int numPlazas) {
        this.numPlazas = numPlazas;
    }
}
