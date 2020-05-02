public class Asignatura {

    private int id;
    private String nombre;
    private int alumnoId;

    public Asignatura(int id, String nombre, int alumnoId) {
        this.id = id;
        this.nombre = nombre;
        this.alumnoId = alumnoId;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", alumnoId=" + alumnoId +
                '}' + "\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(int alumnoId) {
        this.alumnoId = alumnoId;
    }
}
