package u8_t2_ModArbolDOMsaveFichXML;


public abstract class ReinoAnimal implements Comparable{

    private int id;
    private String nombre;
    private int edad;
    private String unidad;

    public ReinoAnimal() {
    }

    public ReinoAnimal(int id) {
        this.id = id;
    }

    public ReinoAnimal(int id, String nombre) {
        this(id);
        this.nombre = nombre;
    }

    public ReinoAnimal(int id, String nombre, int edad, String unidad) {
        this(id);
        this.nombre = nombre;
        this.edad = edad;
        this.unidad = unidad;
    }

    @Override
    public int compareTo(Object o) {
        ReinoAnimal ra = (ReinoAnimal) o;
        return this.id - ra.getId();
    }

    @Override
    public String toString() {
        if (this instanceof Animal) {
            String raza = ((Animal) this).getRaza();
            return getClass().getSimpleName() +
                    " id=" + id + " raza= " + raza +
                    ", nombre='" + nombre + '\'' +
                    ", edad=" + edad +
                    ", unidad='" + unidad + '\'' +
                    '}' + "\n";
        } else {
            return getClass().getSimpleName() +
                    " id=" + id +
                    ", nombre='" + nombre + '\'' +
                    ", edad=" + edad +
                    ", unidad='" + unidad + '\'' +
                    '}' + "\n";
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

}
