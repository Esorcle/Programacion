package com.company;

import java.util.Scanner;

//Realizar un programa que dado un número que se solicita la usuario por consola eliminará de ese número de ese número
//todos los 0 y todos los 8 indicando adicionalmente cuántos números ha eliminado. Deberá solicitar el número mientras
//que el número introducido no sea positivo.
//Ejemplo 1:
//Introduzca un número entero positivo: 34084091
//Número resultado: 34491
//Dígitos eliminados: 3
public class Ej2 {
    public static void main(String[] args) {
        //Declaración variables
        Scanner sc = new Scanner(System.in);

        int num = 0;
        int aux = 0;
        int cont = 0;
        int numResul = 0;
        int k = 1;

        //Petición número
        System.out.println("Introduzca un número entero positivo");
        num = sc.nextInt();

        //Restricción valor número
        while (num < 0) {
            System.out.println("Error. Introduzca un número entero positivo");
            num = sc.nextInt();
        }

        //Ejecuto
        while (num > 0) {
            aux = num % 10;
            if (aux == 0 || aux == 8) {
                cont++;
                num = num / 10;
            } else {
                num = num / 10;
                aux = aux * k;
                numResul = numResul + aux;
                k = k * 10;
            }
        }

        //Resultado
        System.out.println("Número resultado es: " + numResul);
        System.out.println("Dígitos eliminados: " + cont);

    }
}
