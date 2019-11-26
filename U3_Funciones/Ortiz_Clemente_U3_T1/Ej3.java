package com.company;

import java.lang.reflect.Array;

public class Ej3 {

    public static void main(String[] args) {

        int[] x = {2,7,96,87,56,23,957,713,7561,5872};

        for (int i = 0; i < filtraCon7(x).length ; i++) {
            System.out.print(filtraCon7(x)[i] + " | ");
        }
    }

        public static int[] filtraCon7(int x[]) {

            int cont=0;

            for (int i = 0; i < x.length ; i++) {
                int aux = x[i];
                while (aux>0) {
                    int cifra = aux%10;
                    if (cifra==7) {
                       cont++;
                        break;
                    }
                        aux=aux/10;
                }
            }

            int[] solo7 = new int[cont];

           cont = 0;
            for (int i = 0; i < x.length ; i++) {
                int aux = x[i];
                while (aux>0) {
                    int cifra = aux%10;
                    if (cifra==7) {
                        solo7[cont] = x[i];
                        cont++;
                        break;
                    }
                    aux=aux/10;
                }
            }
            return solo7;
        }

    }

