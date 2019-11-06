package com.company;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        //Declaración de variables. Introduce vocales en minúsculas
        int cont = 0;
        String cad = "Hola tu";

        //Recorro cadena
        for (int i = 0; i < cad.length(); i++) {

            if (cad.charAt(i) == 'a' || cad.charAt(i) == 'e' || cad.charAt(i) == 'i' || cad.charAt(i) == 'o' ||
                    cad.charAt(i) == 'u') {
                cont++;
            }
        }
        System.out.println("La cantidad de vocales es " + cont);

    }
}
