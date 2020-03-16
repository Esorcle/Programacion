package com.fany;

import java.io.Serializable;

public class Perro implements Serializable {

    /**atributos clase Perro
     *
     */
    private String nombre;
    private int edad;
    private double peso;
    public enum Vacuna {SI,NO}
    private Vacuna vacuna;
    private Propietario propietario;
    public enum Raza {PASTORALEMAN, LABRADOR,HUSKY}
    private Raza raza;

    /**
     * Constructor
     * @param nombre
     * @param edad
     * @param peso
     * @param vacuna
     * @param propietario
     */
    public Perro(String nombre, int edad, double peso, Vacuna vacuna, Propietario propietario, Raza raza) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.vacuna = vacuna;
        this.propietario = propietario;
        this.raza = raza;
    }



    @Override
    public String toString() {
        return "Perro{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", vacuna=" + vacuna +
                ", propietario=" + propietario +
                ", raza=" + raza +
                '}';
    }

    //SETTER Y GETTER//
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }
}
