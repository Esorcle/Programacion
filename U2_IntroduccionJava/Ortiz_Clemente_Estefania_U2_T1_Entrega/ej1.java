package com.company;

import java.util.Scanner;

public class ej1 {
    public static void main(String[] args) {
        float subject1;
        float subject2;
        float subject3;
        float notaMEdia = 0;
        int recuper;

        Scanner sc = new Scanner(System.in);


        System.out.println("Deme la nota del primer examen");
        subject1 = sc.nextFloat();
        System.out.println("Deme la nota del segundo examen");
        subject2 = sc.nextFloat();

        notaMEdia = ((subject1 + subject2) / 2);

        if (notaMEdia >= 5 && notaMEdia < 6) {
            System.out.println("Tu nota de programación es: " + notaMEdia + "-Suficiente");
        } else if (notaMEdia >= 6 && notaMEdia < 7) {
            System.out.println("Tu nota de programación es: " + notaMEdia + "-Bien");
        } else if (notaMEdia >= 7 && notaMEdia < 9) {
            System.out.println("Tu nota de programación es: " + notaMEdia + "-Notable");
        } else if (notaMEdia >= 9) {
            System.out.println("Tu nota de programación es: " + notaMEdia + "-Sobresaliente");
        } else {
            System.out.println("¿Cuál ha sido el resultado de la recuperación?\n1.-Apto, 2.-No apto");
            recuper = sc.nextInt();
            if (recuper == 2) {
                System.out.println("Tu nota de programación es: " + notaMEdia + "-Suspenso");
            } else {
                System.out.println("Tu nota de programación es 5 " + "-Aprobado");

            }

        }
    }
}
