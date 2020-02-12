package com.company;

import java.util.Arrays;
import java.util.Objects;

public class RPG {

    /**
     * Atributos
     */
    private Personaje[] personajes;
    private int numPersonaje;

    /**
     * Constructor clase RPG
     */
    public RPG() {
        this.numPersonaje = 0 ;
        this.personajes = new Personaje[numPersonaje];

    }



    /**
     * Método para añadir personaje
     *
     * @param p
     * @return
     */
    public String addPersonaje(Personaje p) {
        if (this.numPersonaje < 10) {
            personajes = Arrays.copyOf(personajes, numPersonaje+1);
            this.personajes[this.numPersonaje] = p;
            this.numPersonaje++;
            return "Se ha ingresado un personaje";
        } else {
            return "No se ha podido ingresar el personaje ya que tienes le máximo permitido";
        }
    }

    /**
     * Método para eliminar personajes muertos de la lista
     *
     * @return
     */
    public void borrarMuertos() {
        for (int i = 0; i < this.numPersonaje; i++) {
            if (this.personajes[i].getEnergia() <= 0)  {
                this.personajes[i] = this.personajes[i + 1];
                this.numPersonaje--;
                if (this.numPersonaje == 1) {
                    hayGanador();
                }
            }
        }
    }

    public String hayGanador() {
        return "El ganador es " + RPG.this.personajes.toString();
    }

    public String mostarEstado() {
        return  Arrays.toString(personajes);
    }

    @Override
    public String toString() {
        return "RPG { " +
                "personajes = " + Arrays.toString(personajes) +
                '}';
    }

    public String mostrarxAtaque() {
        Arrays.sort(personajes, new CompararxAtaque());
        return personajes.toString();
    }


    public String mostrarxDefensa() {
        Arrays.sort(personajes, new CompararxDefensa());
        return personajes.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RPG rpg = (RPG) o;
        return numPersonaje == rpg.numPersonaje &&
                Arrays.equals(personajes, rpg.personajes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numPersonaje);
        result = 31 * result + Arrays.hashCode(personajes);
        return result;
    }

    //SETTER Y GETTER
    public Personaje[] getPersonajes() {
        return personajes;
    }

    public void setPersonajes(Personaje[] personajes) {
        this.personajes = personajes;
    }

    public int getNumPersonaje() {
        return numPersonaje;
    }

}
