package com.company;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {

        //Declaración de variables
        Scanner sc = new Scanner(System.in);
        int num = 0;
        int posicion = 0;

        //Pido número
        System.out.println("Por favor, introduzca un número entero positivo:");
        num = sc.nextInt();
        int aux = num;

        //Saco las cifras del número introducido. Le sumo 1 ya que los números < 10 su potencia es 0
        double cifras = Math.floor(Math.log10(Math.abs(num)) + 1);

        //Pido posición
        System.out.println("Introduzca la posición a partir de la cual quiere partir el número:");
        posicion = sc.nextInt();
        while (posicion<2 || posicion > cifras) {
            System.out.println("La posición introducida no es válida.\nTiene que ser  mayor a 2 o menor "+
                    "números de cifras del número");
            System.out.println("Vuelva a introducir la posición a partir de la cual quiere partir el número:");
            posicion = sc.nextInt();
        }

        //Posibilidades
       if (posicion == cifras) {
            System.out.println(num);
        } else {
            for (int i = 0; i <= cifras - posicion; i++) {
                aux = aux / 10;
            }
            System.out.println("Los números partidos son el " + aux);

            for (int i = 0; i <= cifras - posicion; i++) {
               aux = aux * 10;

            }
            System.out.println("Y el " +(num - aux));
        }
    }
}
