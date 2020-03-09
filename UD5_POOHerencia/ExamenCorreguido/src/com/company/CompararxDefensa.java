package com.company;

import java.util.Comparator;

public class CompararxDefensa implements Comparator {
    @Override
    public int compare(Object o, Object t1) {
        Personaje p2 = (Personaje) t1;
        return ((Personaje) o).getDefensa() - p2.getDefensa();
    }
}
