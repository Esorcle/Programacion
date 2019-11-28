package com.jdperez;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {

        //Variables
        Scanner sc = new Scanner(System.in);

        int[] lado = {0, 1, 2, 3, 4, 5, 6, 7};
        char[] top = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        String posicion = "";
        int fila = 0;
        char posi = 'a';
        int col = 0;

        System.out.println("Introduzca la posición del alfil: ");
        posicion = sc.nextLine();

        //Divido la posición
        fila = Integer.parseInt(String.valueOf((posicion.charAt(1))));
        posi = posicion.charAt(0);

        for (int i = 0; i < top.length; i++) {
            if (posi == top[i]) {
                col = i;
                break;
            }
        }

        System.out.println("El afil puede moverse a las siguientes posiciones:");
        int k = 0;
        int l = 0;

        for (int i = 0; i < lado.length; i++) {
            for (int j = 0; j < top.length; j++) {
                if ((i > fila - 1 && j < col && (i + j) == 7) ||
                        (i > fila - 1 && j > col && j == i - 1) ||
                        (i < fila - 1 && j > col && (i + j) == 7) ||
                        (i < fila - 1 && j < col && j == i - 1)) {
                    System.out.print(top[j] + "," + (1+i)  + " | ");
                }
            }

        }
    }
}
