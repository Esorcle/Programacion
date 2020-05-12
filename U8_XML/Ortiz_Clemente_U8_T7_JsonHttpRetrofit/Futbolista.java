import java.util.List;

public class Futbolista {

    private int id;
    private String nombre;
    private String equipo;
    private Estadistica estadisticas;

    public Futbolista(int id, String nombre, String equipo, Estadistica estadistica) {
        this.id = id;
        this.nombre = nombre;
        this.equipo = equipo;
        this.estadisticas = estadistica;
    }

    @Override
    public String toString() {
        return "Futbolista{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", equipo='" + equipo + '\'' +
                ", estadistica=" + estadisticas +
                '}';
    }

    public Estadistica getEstadistica() {
        return estadisticas;
    }

    public void setEstadistica(Estadistica estadistica) {
        this.estadisticas = estadistica;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
}

