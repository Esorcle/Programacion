package com.company;

public class Ej5 {
    public static int aleatorioDeArray(int[] a) {

        int aleatorio = (int) (Math.random()*a.length);

        return a[aleatorio];
    }

    public static void main(String[] args) {

        int[] num = {1, 12, 40, 150, 7, 1005};

        System.out.println("el núemro aleatorio es: "+ aleatorioDeArray(num));
    }
}
