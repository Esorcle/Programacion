package com.company;

public class Elfo extends Personaje implements Atacar {

    /**
     * Atributos clase Elfo
     */
    public enum Tipo {BOSQUE, COSTA}

    ;
    private Tipo tipo;

    /**
     * Construtor
     *
     * @param nombre
     * @param energia
     * @param dmg
     * @param defensa
     */
    public Elfo(String nombre, int energia, int dmg, int defensa, Tipo tipo) {
        super(nombre, energia, dmg, defensa);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString()  + "tipo = " + tipo + '\n';
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
