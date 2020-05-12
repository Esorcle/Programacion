package u8_t2_ModArbolDOMsaveFichXML;

public class Animal extends ReinoAnimal {

    private String raza;

    public Animal(int id) {
        super(id);
    }

    public Animal(int id, String nombre, String raza) {
        super(id, nombre);
        this.raza = raza;
    }

    public Animal(int id, String nombre,String raza, int edad, String unidad) {
        super(id, nombre,edad, unidad);
        this.raza = raza;

    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}
