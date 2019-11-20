package com.company;

import java.util.Scanner;
//Escribe un programa que pida un número entero positivo por teclado y que muestre a continuación los 5 números
// consecutivos a partir del número introducido. Al lado de cada número se debe indicar si se trata de un primo o no.
//Ejemplo:
//Por favor, introduzca un número entero positivo: 17
//17 es primo
//18 no es primo
//19 es primo
//20 no es primo
//21 no es primo
public class Ej4 {
    public static void main(String[] args) {
        //Declaración variables
        Scanner sc = new Scanner(System.in);
        int num = 0;
        boolean esPrimo = true;

        //Petición número
        System.out.println("Por favor, introduzca un número entero positivo:");
        num = sc.nextInt();

        //Restricción número
        while (num < 0) {
            System.out.println("Por favor, introduzca un número entero positivo:");
            num = sc.nextInt();
        }

        //Ejecuto
        for (int i = num; i < num + 5; i++) {
            esPrimo = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    esPrimo = false;
                    break;
                }
            }

            //Resultado
            if (esPrimo == false) {
                System.out.println(i + " no es primo");
            } else {
                System.out.println(i + " es primo");
            }

        }
    }
}
