package com.company;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        //Declaración de variables
        Scanner sc = new Scanner(System.in);
        long num = 0;
        String contiene = "";
        String noContiene = "";

        //Pido número
        System.out.println("Introduzca un número entero:");
        num = sc.nextLong();

        //Confirmo que introducide un entero
        if (num < 0) {
            System.out.println("Por favor, Introduzca un número entero:");
            num = sc.nextInt();
        }

        //Paso número a string
        String numOriginal = String.valueOf(num);

        //Recorro un bucle para los dígitos
        for (int i = 0; i <= 9; i++) {
            if (numOriginal.contains(String.valueOf(i))) {
                contiene += i + " ";
            } else {
                noContiene += i + " ";
            }
        }
        System.out.println("Dígitos que aparecen en el número: " + contiene);
        System.out.println("Dígitos que no aparecen: " + noContiene);
    }

}
