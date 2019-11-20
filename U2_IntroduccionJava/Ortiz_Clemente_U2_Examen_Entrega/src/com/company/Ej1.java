package com.company;

import java.util.Scanner;

//Escribe un programa que pinte por pantalla un par de calcetines, de los que se ponen al lado del árbol de Navidad
//para que Papá Noel deje sus regalos. El usuario debe introducir la altura. Suponemos que el usuario introduce una
//altura mayor o igual a 4. Observa que la talla de los calcetines y la distancia
//que hay entre ellos (dos espacios) no cambia, lo único que varía es la altura.
/*Ejemplo 1:
        Introduzca la altura de los calcetines: 6

        ***     ***
        ***     ***
        ***     ***
        ***     ***
        ******  ******
        ******  ******
        */
public class Ej1 {

    public static void main(String[] args) {
        //Declaración variables
        Scanner sc = new Scanner(System.in);
        int altura = 0;

        //Se pide altura
        System.out.println("Dame la altura");
        altura = sc.nextInt();

        //Restricción de altura
        while (altura < 4) {
            System.out.println("Error, Dame la altura < 4 ");
            altura = sc.nextInt();
        }

        //Pinta
        for (int i = 0; i < altura; i++) {
            if (i < altura - 2) {
                System.out.print("***     ***");
            } else {
                System.out.print("******  ******");
            }
            System.out.println();
        }
    }
}
