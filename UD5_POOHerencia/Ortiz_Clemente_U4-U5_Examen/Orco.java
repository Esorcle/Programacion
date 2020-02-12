package com.company;

public class Orco extends Personaje implements Atacar {
    /**
     * Atributo clase Orco
     */
    private double tonelaje;

    /**
     * Construtor
     *
     * @param nombre
     * @param energia
     * @param dmg
     * @param defensa
     */
    public Orco(String nombre, int energia, int dmg, int defensa, double tonelaje) {
        super(nombre, energia, dmg, defensa);
        this.tonelaje = tonelaje;
    }

    @Override
    public String toString() {
        return super.toString() + '\t' +
                "tonelaje = " + tonelaje + '\n';
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
