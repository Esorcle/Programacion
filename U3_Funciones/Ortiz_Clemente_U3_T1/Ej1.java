package com.company;

import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

public class Ej1 {

    public static void main(String[] args) {
        //Declaración de variables
        Scanner sc = new Scanner(System.in);

        int persona = 0;
        int[] ocupacion = {3, 2, 0, 2, 4, 1, 0, 2, 1, 1};
        int lleno=0;


        for (int i = 0; i < ocupacion.length; i++) {
            System.out.print(ocupacion[i] + " | ");
        }
        System.out.println();

        System.out.println("¿Cántos son? (Introduzca -1 para salir del programa)");
        persona = sc.nextInt();

        while (persona != -1) {
            boolean hueco = false;
            while (persona > 4) {
                System.out.println("Lo siento, no admitimos grupos de 6, haga grupos de 4 personas " +
                        "como máximo e intente de nuevo");
                System.out.println("¿Cántos son? (Introduzca -1 para salir del programa)");
                persona = sc.nextInt();
            }

            for (int i = 0; i < ocupacion.length; i++) {
                if (ocupacion[i] == 0) {
                    System.out.println("Por favor, siéntense en la mesa número " + (i + 1));
                    ocupacion[i] = persona;
                    hueco = true;
                    break;
                }
            }

            if (!hueco) {
                for (int i = 0; i < ocupacion.length; i++) {
                    if (ocupacion[i] + persona <= 4) {
                        System.out.println("Tendrán que compartir mesa. Por favor, siéntense en la mesa número " + (i + 1));
                        ocupacion[i] += persona;
                        break;
                    }
                }
            }

            for (int i = 0; i < ocupacion.length; i++) {
                System.out.print(ocupacion[i] + " | ");
            }


            System.out.println("¿Cántos son? (Introduzca -1 para salir del programa)");
            persona = sc.nextInt();
        }

        System.out.println("Gracias. Hasta pronto");
    }
}


