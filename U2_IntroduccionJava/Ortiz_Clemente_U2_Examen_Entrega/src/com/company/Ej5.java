package com.company;

import java.util.Scanner;

//Escribir un programa que incremente la hora de un reloj tantos segundos como le solicitemos mostrando cada vez la
// hora nueva. Se solicitará al usuario por teclado las horas, los minutos y los segundos y el número de segundos que
// se quiere aumentar la hora. Supondremos que el usuario siempre introduce valores correctos.
//Ejemplo 1:
//Introduzca horas: 13
//Introduzca minutos: 59
//Introduzca segundos: 51
//Introduzca segundos a incrementar: 10
public class Ej5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hora = 0;
        int min = 0;
        int seg = 0;
        int segAum = 0;

        System.out.println("Introduzca horas:");
        hora = sc.nextInt();
        System.out.println("Introduzca minutos:");
        min = sc.nextInt();
        System.out.println("Introduzca segundos:");
        seg = sc.nextInt();
        System.out.println("Introduzca segundos a incrementar:");
        segAum = sc.nextInt();

        System.out.println("Aumentando la hora...");
        for (int i = 0; i < segAum; i++) {
            seg++;
            if (seg == 60) {
                seg = 00;
                min++;
            }
            if (min == 60) {
                min = 00;
                hora++;
            }
            if (hora == 24) {
                hora = 00;
            }
            System.out.println(hora + ":" + min + ":" + seg);
        }

    }
}
