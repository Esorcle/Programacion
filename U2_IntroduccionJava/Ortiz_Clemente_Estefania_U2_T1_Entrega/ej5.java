package com.company;

import java.util.Scanner;

public class ej5b {
    public static void main(String[] args) {
        String palabra = new String();

        Scanner sc = new Scanner(System.in);

        System.out.println("Dame la palabra");
        palabra = sc.nextLine();


        for (int i = 0; i < palabra.length(); i++) {
            //Pinto espacios
            for (int j = 0; j < palabra.length() - i - 1; j++) {
                System.out.print(" ");
            }

            //Pinto palabra
            for (int j = 0; j <= i * 2; j++) {

                if (j == 0 || j == i * 2) {
                    System.out.print(palabra.charAt(0));
                } else if (j == 1 || j < i * 2) {
                    System.out.print(palabra.charAt(1));
                }
            }
            System.out.println(" ");
        }
        //Parte de abajo
        for (int i = 1; i < (palabra.length() / 2) + 1; i++) {
            //Pinto espacios
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            //Pinto asteriscos
            for (int j = 0; j <= i * 2; j++) {

                if (j == 0 || j == i * 2) {
                    System.out.print(palabra.charAt(0));
                } else if (j == 1 || j < i * 2) {
                    System.out.print(palabra.charAt(1));
                }
            }
            System.out.println();
        }
    }
}