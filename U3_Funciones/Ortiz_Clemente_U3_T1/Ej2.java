package com.company;

import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] mat = new int[4][5];
        int[][] matRellena = new int[5][6];

        //Rellenar matriz
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.println("Deme el número de la posición " + (i + 1) + ", " + (j + 1));
                mat[i][j] = sc.nextInt();
                matRellena[i][j] = mat[i][j];
                matRellena[i][matRellena.length - 1] += matRellena[i][j];
            }
            matRellena[i][matRellena.length - 1] = matRellena[i][matRellena.length - 1] / matRellena.length;
        }

        //Recorro por columnas
        for (int j = 0; j < matRellena[0].length; j++) {
            int suma_colum = 0;
            for (int i = 0; i < matRellena.length - 1; i++) {
                suma_colum += matRellena[i][j];
            }

            matRellena[matRellena.length - 1][j] = suma_colum / (j + 1);
            matRellena[matRellena.length - 1][matRellena.length - 1] += suma_colum / (j + 1);

        }
        //Muestro
        for (int i = 0; i < matRellena.length; i++) {
            for (int j = 0; j < matRellena[i].length; j++) {
                System.out.print(matRellena[i][j]);
            }
            System.out.println(1);
        }
    }
}