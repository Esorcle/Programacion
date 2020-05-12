package com.company;

public interface Magia {

    default void encantar(Personaje p) {
        p.setEncantar(Personaje.Encantado.SI);
    }

    default void desencantar(Personaje p) {p.setEncantar(Personaje.Encantado.NO);;
}
