package com.jdperez;

import java.util.Scanner;

public class Ejercicio1 {

    //Función encontar max en matriz
    public static int maxMatriz(int mat[][]) {
        int mayor = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] > mayor) {
                    mayor = mat[i][j];
                }
            }
        }
        return mayor;
    }

    public static void main(String[] args) {
        //Variables
        Scanner sc = new Scanner(System.in);
        int fila = 0;
        int col = 0;

        //Petición de variables
        System.out.print("Por favor, deme el número de filas");
        fila = sc.nextInt();
        System.out.print("Por favor, deme el número de columnas");
        col = sc.nextInt();

        //Creo matriz
        int[][] mat = new int[fila][col];

        //Relleno con valores aleatorios
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = (int) (Math.random() * 1000);
                //System.out.print(mat[i][j] + "| ");
            }
            //System.out.println();
        }
        //Muestro por pantalla
        System.out.println("El valor máximo encontrado en la matriz es: " + maxMatriz(mat));
    }
}
