package com.company;

abstract class Personaje implements Comparable {
    /**
     * Atributos clase Personaje
     */
    private String nombre;
    private int energia;
    private int dmg;
    private int defensa;

    public enum Encantado {SI, NO}

    ;
    private Encantado encantado;

    /**
     * Construtor
     *
     * @param nombre
     * @param energia
     * @param dmg
     * @param defensa
     */
    public Personaje(String nombre, int energia, int dmg, int defensa) {
        this.nombre = nombre;
        this.energia = energia;
        this.dmg = dmg;
        this.defensa = defensa;
        this.encantado = Encantado.NO;
    }

    /**
     * Método para sacar por pantalla la información de personaje
     *
     * @return
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + " nombre = " + nombre + '\'' +
                ", energia = " + energia +
                ", dmg = " + dmg +
                ", defensa = " + defensa +
                ", encantado = " + encantado +'\t';
    }

    /**
     * Método por defecto para ordenar por energía los personajes
     *
     * @param o
     * @return
     */
    public int compareTo(Object o) {
        Personaje p = (Personaje) o;
        return this.energia - p.getEnergia();
    }


    //SETTER Y GETTER
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public Encantado getEncantado() {
        return encantado;
    }

    public void setEncantado(Encantado encantado) {
        this.encantado = encantado;
    }
}
