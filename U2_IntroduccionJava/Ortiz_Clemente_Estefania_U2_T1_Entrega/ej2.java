package com.company;

import java.util.Scanner;

public class ej2 {
    public static void main(String[] args) {


        System.out.println("Introduce un número");
        Scanner sc = new Scanner(System.in);
        long numeroIntro = sc.nextInt();
        long numero = numeroIntro;
        long volteado = 0;

        while (numero > 0) {
            volteado = (volteado * 10) + (numero % 10);
            numero /= 10;
        }
        //System.out.println("El número al revés es: " + volteado);
        if (volteado == numeroIntro) {
            System.out.println("El número es capucúo");
        } else {
            System.out.println("el número no es capicúo");
        }
    }
}