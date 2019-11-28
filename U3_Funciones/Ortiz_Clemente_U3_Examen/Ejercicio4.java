package com.jdperez;

public class Ejercicio4 {

    public static int[] filtraPrimos(int[] vect) {
        int cont = 0;
        boolean esPrimo = true;

        for (int i = 0; i < vect.length; i++) {
            esPrimo = true;
            for (int j = 2; j < vect[i]; j++) {
                if (vect[i] % j == 0) {
                    esPrimo = false;
                    break;
                }
            }
            if (esPrimo) {
                cont++;
            }
        }

        int[] vectPrimos = new int[cont+1];
        if (cont==0){
           vectPrimos [0] = -1;
            return vectPrimos;
        } else {
            vectPrimos = new int [cont];
        }

        cont = 0;
        for (int i = 0; i < vect.length; i++) {
            esPrimo = true;
            for (int j = 2; j < vect[i]; j++) {
                if (vect[i] % j == 0) {
                    esPrimo = false;
                    break;
                }
            }
            if (esPrimo) {
                vectPrimos[cont]=vect[i];
                cont++;
            }
        }
        return vectPrimos;
    }

    public static void main(String[] args) {
        int[] vect = {17, 2, 11, 36, 55, 46};
        //int[] vect = {36, 55, 46};
        int[] vectPrimos = filtraPrimos(vect);

        for (int i = 0; i < vectPrimos.length; i++) {
            System.out.print(vectPrimos[i]+" | ");
        }

    }
}
