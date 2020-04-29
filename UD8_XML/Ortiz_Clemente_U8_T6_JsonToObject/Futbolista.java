import java.util.List;

public class Futbolista {

        private int dorsal;
        private String nombre;
        private List<String> demarcaciones;
        private String equipo;

        public Futbolista(int dorsal, String nombre, List<String> demarcaciones, String equipo) {
            this.dorsal = dorsal;
            this.nombre = nombre;
            this.demarcaciones = demarcaciones;
            this.equipo = equipo;
        }

        @Override
        public String toString() {
            return "Futbolista{" +
                    "dorsal=" + dorsal +
                    ", nombre='" + nombre + '\'' +
                    ", demarcaciones=" + demarcaciones +
                    ", equipo='" + equipo + '\'' +
                    '}';
        }

        public int getDorsal() {
            return dorsal;
        }

        public void setDorsal(int dorsal) {
            this.dorsal = dorsal;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public List getDemarcaciones() {
            return demarcaciones;
        }

        public void setDemarcaciones(List demarcaciones) {
            this.demarcaciones = demarcaciones;
        }

        public String getEquipo() {
            return equipo;
        }

        public void setEquipo(String equipo) {
            this.equipo = equipo;
        }
    }

