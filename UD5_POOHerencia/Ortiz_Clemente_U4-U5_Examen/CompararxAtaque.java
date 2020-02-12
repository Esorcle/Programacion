package com.company;

import java.util.Comparator;

public class CompararxAtaque implements Comparator {
    @Override
    public int compare(Object o, Object t1) {
        Personaje p2 = (Personaje) t1;
        return ((Personaje) o).getDmg() - p2.getDmg();
    }
}
