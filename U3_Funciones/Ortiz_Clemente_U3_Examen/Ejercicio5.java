package com.jdperez;

public class Ejercicio5 {

    public static String[] unirVect(String[] vect1, String[] vect2) {
        String[] vectResult = new String[vect1.length + vect2.length];
        int k = 0;

        for (int i = 0; i < vectResult.length; i++) {
            if (i < vect2.length) {
                vectResult[i] = vect2[i];
            } else {
                vectResult[i] = vect1[k];
                k++;
            }
        }
        return vectResult;
    }

    public static String[] rotarVect(String[] vect, int pos) {
        String[] vectResult = new String[vect.length];

        for (int i = 0; i < vect.length; i++) {
            if (pos > vect.length - 1) {
                pos = 0;
            }
            vectResult[pos] = vect[i];
            pos++;
        }
        return vectResult;
    }

    public static void main(String[] args) {
        String[] vect1 = {"Hola", "Caracola"};
        String[] vect2 = {"Adios", "Babosa"};
        String[] v1 = {"a", "b", "c", "d", "e", "f"};
        int pos = 3;

        //String[] vectResul = unirVect(vect1, vect2);
        String[] vectResul = rotarVect(v1, pos);

        for (int i = 0; i < vectResul.length; i++) {
            System.out.print(vectResul[i] + " | ");
        }

    }
}

