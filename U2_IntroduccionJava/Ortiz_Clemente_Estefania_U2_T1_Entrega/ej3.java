package com.company;

//Realiza un programa lea un número entero positivo de la pantalla y que lo pase a binario

import java.util.Scanner;

public class ej3 {
    public static void main(String[] args) {
        int num;

        Scanner sc = new Scanner(System.in);

        System.out.println("Dame un número en base a 10 positivo");
        num = sc.nextInt();

        while (num < 0) {
            System.out.println("Error, ingrese un número positivo\n");
            System.out.println("Dame un número en base a 10 positivo");
            num = sc.nextInt();
        }
            String binario = "";

            if (num > 0) {
                while (num > 0) {
                    if (num % 2 == 0) {
                        binario = "0" + binario;
                    } else {
                        binario = "1" + binario;
                    }
                    num = num / 2;
                }
            } else if (num == 0) {
                binario = "0";
            }
            System.out.println("El número convertido a binario es: " + binario);
        }
    }

