package com.company;

public class Guerreros extends Hombre implements Atacar {
    /**
     * Atributo clase Guerrero
     */
    private int edad;

    /**
     * Construtor
     *
     * @param nombre
     * @param energia
     * @param dmg
     * @param defensa
     */
    public Guerreros(String nombre, int energia, int dmg, int defensa, int edad) {
        super(nombre, energia, dmg, defensa);
        this.edad = edad;
    }

    @Override
    public String toString() {
        return super.toString() + '\t' +
                "edad=" + edad + '\n';
    }

    @Override
    public String atacarPersonaje(Personaje p) {
        if (!(this.getClass().equals(p.getClass()))) {
            if (this.getEncantado() == Encantado.SI) {
                p.setEnergia(2 * (p.getEnergia() - (this.getDmg() - p.getDefensa())));
            } else {
                p.setEnergia(p.getEnergia() - (this.getDmg() - p.getDefensa()));
            }
        }
        return this.getNombre() + " ATACANDO";
    }
}
