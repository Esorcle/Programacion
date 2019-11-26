package com.company;

public class Ej4 {

    public static String convierteArrayEnString(int[] a) {
        String cad = "";

        for (int i = 0; i < a.length; i++) {
             cad = cad + a[i];

        }
        return cad;

    }

    public static void main(String[] args) {
        int[] num = {1, 5, 8, 7};

        System.out.println(convierteArrayEnString(num));
    }


}
