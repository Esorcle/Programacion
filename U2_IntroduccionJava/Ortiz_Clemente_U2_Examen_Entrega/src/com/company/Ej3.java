package com.company;

import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        //Declaración variables
        Scanner sc = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int loteria = 0;
        int cont = 0;

        //Petición de variables
        System.out.println("Introduzca sus números favoritos:");
        num1 = sc.nextInt();
        System.out.println("Introduzca sus números favoritos:");
        num2 = sc.nextInt();
        System.out.println("Introduzca sus números favoritos:");
        num3 = sc.nextInt();
        System.out.println("Introduzca el número de la lotería:");
        loteria = sc.nextInt();

        //Cuento cifras del número loteria
        double cifras = Math.floor(Math.log10(Math.abs(loteria))) + 1;

        //Ejecuto
        for (int i = 0; i < cifras; i++) {
            int aux = loteria % 10;
            if (aux == num1 || aux == num2 || aux == num3) {
                cont++;
            }
            loteria = loteria / 10;
        }

        //Resultado
        if (cont > cifras / 2) {
            System.out.println("Ese número le va a dar suerte!");
        } else {
            System.out.println("Ese número no le va a dar suerte");
        }
    }
}

