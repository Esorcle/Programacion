package com.company;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        //Declaración de variables
        Scanner sc = new Scanner(System.in);
        boolean esPrimo = false;
        int cont = 0;
        int mayor = 0;
        int menor = 0;
        double suma = 0; //aux
        String numeros = "";
        int num = 0;

        //Pido números hasta que esPrimo=true
        while (!esPrimo) {
            System.out.println("Por favor, vaya introduciendo números enteros positivos. Para terminar,\n" +
                    "introduzca un número primo: ");
            num = sc.nextInt();

            //Compruebo si es primo
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    esPrimo = false;
                    //Suma para media
                    suma = suma + num;

                    //Meto los números en un String para luego mostrar la lista de números
                    String numIntro = Integer.toString(num);
                    numeros = numeros + numIntro + " ";

                    //Comparo los números para saber cual es el mayor y cual el menor
                    if (cont == 0) {
                        mayor = num;
                        menor = num;
                    } else {
                        if (num >= mayor) {
                            mayor = num;
                        }
                        if (num <= menor) {
                            menor = num;
                        }
                    }
                    //Cuento cantidad de numeros
                    cont++;
                    break;
                } else {
                    esPrimo = true;
                }
            }
        }
        System.out.println("Los números introducidos son: " + numeros);
        System.out.println("Ha introducido " + cont + " números no primos ");
        System.out.println("Máximo: " + mayor);
        System.out.println("Mínimo: " + menor);
        System.out.println("Media: " + suma / cont);
    }
}

