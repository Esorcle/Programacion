package com.company;

public class Mago extends Hombre implements Magia {
    /**
     * Atributos clase Mago
     */
    private double longBarba;

    /**
     * Construtor
     *
     * @param nombre
     * @param energia
     * @param dmg
     * @param defensa
     */
    public Mago(String nombre, int energia, int dmg, int defensa, double longBarba) {
        super(nombre, energia, dmg, defensa);
        this.longBarba = longBarba;
    }

    @Override
    public String toString() {
        return super.toString() + '\t' +
                "longBarba=" + longBarba + '\n';
    }

    @Override
    public void encantar(Personaje p) {
        this.setEncantado(Encantado.SI);
    }

    @Override
    public void desencantar(Personaje p) {
        this.setEncantado(Encantado.NO);

    }
}
