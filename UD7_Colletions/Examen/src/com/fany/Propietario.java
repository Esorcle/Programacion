package com.fany;

import java.io.Serializable;

public class Propietario implements Serializable {

    /**
     * Atributos clase Propietario
     */
    private String nombre;
    private String apellidos;
    private final int numsocio;
    private String pais;

    /**
     * Constructor
     * @param nombre
     * @param apellidos
     * @param numsocio
     * @param pais
     */
    public Propietario(String nombre, String apellidos, int numsocio, String pais) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numsocio = numsocio;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Propietario {" +
                "nombre =' " + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", numsocio=" + numsocio +
                ", pais='" + pais + '\'' +
                '}';
    }

// SETTER Y GETTER //
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getNumsocio() {
        return numsocio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


}
