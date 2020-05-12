package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        RPG rpg = new RPG();
        Personaje p1 = new Elfo("Legolas", 70, 60, 40, Elfo.Tipo.BOSQUE);
        Personaje p2 = new Orco("GarraOscura", 20, 90, 80, 230);
        Personaje p3 = new Enano("BarbaTrenzada", 40, 90, 80, 120);
        Personaje p4 = new Guerreros("Paquito", 50, 70, 70, 35);
        Personaje p5 = new Mago("Gandalf", 100, 60, 60, 35);


        rpg.addPersonaje(p1);
        rpg.addPersonaje(p2);
        rpg.addPersonaje(p3);
        rpg.addPersonaje(p4);
        rpg.addPersonaje(p5);


        System.out.println(rpg.mostarEstado());


        System.out.println(rpg.mostrarxAtaque());


        //Arrays.sort(Personaje, new CompararxAtaque());






    }
}

