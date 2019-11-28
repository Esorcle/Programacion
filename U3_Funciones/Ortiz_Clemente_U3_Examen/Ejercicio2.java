package com.jdperez;

import java.util.Scanner;

public class Ejercicio2 {

    //Función insertar valor en vector
    public static int[] insertaValor(int vect[], int valor, int pos) {
        int[] vectNuevo = new int[vect.length + 1];
        int k = 0;
        for (int i = 0; i < vectNuevo.length; i++) {
            if (i == pos) {
                vectNuevo[i] = valor;
                i++;
            }
            vectNuevo[i] = vect[k];
            k++;

        }
        return vectNuevo;
    }

    public static void main(String[] args) {
        //Variables
        Scanner sc = new Scanner(System.in);
        int[] vect = {1, 2, 3, 4, 5};
        int posicion = 3;
        int valor = 8;

        //Requisito de número de la posición
        while (posicion > vect.length) {
            System.out.println("Deme una posición menor o igual a la longitud del vector");
            posicion = sc.nextInt();
        }

        //Muestro nuevo vector
        int[] vectNuevo = insertaValor(vect, valor, posicion);
        for (int i = 0; i < vectNuevo.length; i++) {
            System.out.print(vectNuevo[i]+", ");
        }
    }
}
