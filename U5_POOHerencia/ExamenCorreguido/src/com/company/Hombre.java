package com.company;

abstract class Hombre extends Personaje {

    /**
     * Construtor
     *
     * @param nombre
     * @param energia
     * @param dmg
     * @param defensa
     */
    public Hombre(String nombre, int energia, int dmg, int defensa) {
        super(nombre, energia, dmg, defensa);
    }
}
