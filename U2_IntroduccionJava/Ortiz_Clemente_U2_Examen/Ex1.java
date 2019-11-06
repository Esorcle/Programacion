package com.company;

import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {

        //Declaración de variables
        Scanner sc = new Scanner(System.in);
        int altura = 0;

        //Pido altura del número
        System.out.println("Por favor, introduzca la altura (número impar mayor o igual a 5)");
        altura = sc.nextInt();

        //Condición de límites para la altura
        while (altura < 5 || altura % 2 == 0) {
            System.out.println("La altura introducida no es correcta");
            System.out.println("Por favor, introduzca la altura (número impar mayor o igual a 5)");
            altura = sc.nextInt();
        }

        //Recorro altura introducida y ancho de 6 según específica el enunciado
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < 6; j++) {
                //Condición de pintar el carácter
                if (i == 0 || i == altura - 1 || j == 0 || j == 5 || i == altura / 2) {
                    System.out.print("M");
                } else {
                    System.out.print(" ");
                }
            }
            //Salto de línea
            System.out.println();
        }
    }
}

