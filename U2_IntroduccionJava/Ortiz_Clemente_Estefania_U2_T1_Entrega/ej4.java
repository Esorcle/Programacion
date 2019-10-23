package com.company;

//Crear programa que pinte una flecha doble hacia la izquierda. Se pide al usuario la altura de la figura,
// que debe ser un número impar mayor o igual que 3. La distancia entre cada flecha de asteriscos es siempre de 5
// espacios. Si la altura introducida por el usuario no es un número impar mayor o igual que 3, el programa debe
// mostrar un mensaje de error

import java.util.Scanner;

public class ej4 {
    public static void main(String[] args) {

        int altura;
        Scanner sc = new Scanner(System.in);

        System.out.println("Dame la altura de la figura");
        altura = sc.nextInt();

        while (altura < 3 || altura % 2 == 0) {
            System.out.println("Error, dame un número par y mayor a 3");
            System.out.println("Dame la altura de la figura");
            altura = sc.nextInt();
        }
        //Pinto parte de arriba
        for (int i = 0; i < (altura / 2) + 1; i++) {
            //Pintar los espacios
            for (int j = 0; j < (altura / 2) - i; j++) {
                System.out.print(" ");
            }
            //Pintar los asteriscos
            for (int j = 0; j <= i * 2; j++) {

                if (j == 0) {
                    System.out.print("*     *");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
        //Parte de abajo
        for (int i = 1; i < (altura / 2) + 1; i++) {
            //Pinto espacios
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            //Pinto asteriscos
            for (int j = 0; j < altura - i; j++) {
                if (j == 0) {
                    System.out.print("*     *");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

