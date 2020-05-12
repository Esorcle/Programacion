package com.company;

public class Enano extends Personaje implements Atacar {
    /**
     * Atributos clase Enano
     */
    private double altura;

    /**
     * Construtor
     *
     * @param nombre
     * @param energia
     * @param dmg
     * @param defensa
     */
    public Enano(String nombre, int energia, int dmg, int defensa, double altura) {
        super(nombre, energia, dmg, defensa);
        this.altura = altura;
    }

    @Override
    public String toString() {
        return super.toString() +  '\t' +
                "altura=" + altura + '\n';
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
