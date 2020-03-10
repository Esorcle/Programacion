package com.fany;

import java.io.*;
import java.util.*;

public class Concurso implements Serializable {

    /**
     * Atributos clase Concurso
     */
    private String nombre;
    private String localidad;
    private Set<Perro> conjuntoPerrosPastor;
    private Set<Perro> conjuntoPerrosLabrador;
    private Set<Perro> conjuntoPerrosHusky;
    private Map<Perro.Raza, Set> concursoPerros;

    /**
     * Constructor simple sin conjunto de perro
     *
     * @param nombre
     * @param localidad
     */
    public Concurso(String nombre, String localidad) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.concursoPerros = new HashMap<>();

    }

    /**
     * Método para sacar por pantalla la información de la clase
     *
     * @return
     */
    @Override
    public String toString() {
        return "Concurso{" +
                "nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                '}';
    }

    /**
     * Método para añadir un perro al conjunto determindado
     *
     * @param raza
     * @param perro
     * @return
     */
    public String addDog(Perro.Raza raza, Perro perro) {
        if (raza.equals(perro.getRaza())) {
            if (raza.equals(Perro.Raza.HUSKY)) {
                this.conjuntoPerrosHusky.add(perro);
                concursoPerros.put(Perro.Raza.HUSKY, conjuntoPerrosHusky);
            } else if (raza.equals(Perro.Raza.LABRADOR)) {
                this.conjuntoPerrosLabrador.add(perro);
                concursoPerros.put(Perro.Raza.LABRADOR, conjuntoPerrosLabrador);
            } else {
                this.conjuntoPerrosPastor.add(perro);
                concursoPerros.put(Perro.Raza.PASTORALEMAN, conjuntoPerrosPastor);
            }
            return "Perro añadido";
        }
        return "Error, el perro introducido no pertenece a esa raza";
    }

    /**
     * Método para eliminar un perro del concurso
     * @param perro
     * @return
     */
    public String disqualifyDog(Perro perro) {
        if (!(concursoPerros.containsValue(perro))) {
            return "Perro no inscrito";
        } else {
            if (perro.getRaza().equals(Perro.Raza.HUSKY)) {
                this.conjuntoPerrosHusky.remove(perro);
                concursoPerros.put(Perro.Raza.HUSKY, conjuntoPerrosHusky);
            } else if (perro.getRaza().equals(Perro.Raza.LABRADOR)) {
                this.conjuntoPerrosLabrador.remove(perro);
                concursoPerros.put(Perro.Raza.LABRADOR, conjuntoPerrosLabrador);
            } else {
                this.conjuntoPerrosPastor.remove(perro);
                concursoPerros.put(Perro.Raza.PASTORALEMAN, conjuntoPerrosPastor);
            }
            return "Perro eliminado del concurso";
        }
    }

    /**
     * Método para ordenar por pesos los perros de una misma raza
     *
     * @param raza
     */
    public void perrosporPeso(Perro.Raza raza) {
       ArrayList<Perro> aux = (ArrayList<Perro>) asignarSetRaza(raza);
        Collections.sort(aux, new Comparator<Perro>() {
            @Override
            public int compare(Perro perro, Perro t1) {
                return Double.compare(perro.getPeso(), t1.getPeso());
            }
        });
        }


    public void perrosporEdad(Perro.Raza raza) {
        ArrayList<Perro> aux = (ArrayList<Perro>)asignarSetRaza(raza);
        Collections.sort(aux, new Comparator<Perro>() {
            @Override
            public int compare(Perro perro, Perro t1) {
                return Integer.compare(perro.getEdad(), t1.getEdad());
            }
        });
    }


    public Set asignarSetRaza(Perro.Raza raza) {
        Set<Perro> aux;
        if (raza.equals(Perro.Raza.HUSKY)) {
            aux =  this.conjuntoPerrosHusky;
            concursoPerros.put(Perro.Raza.HUSKY, aux);
        } else if (raza.equals(Perro.Raza.LABRADOR)) {
            aux =  this.conjuntoPerrosLabrador;
            concursoPerros.put(Perro.Raza.LABRADOR, aux);
        } else {
            aux =  this.conjuntoPerrosPastor;
            concursoPerros.put(Perro.Raza.LABRADOR, aux);
        }
        return aux;
    }

    public void guardarPerros() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("perros.dat")) {
                Set<Map.Entry<Perro.Raza, Set>> escribir = concursoPerros.entrySet();

                Iterator it = escribir.iterator();
                while(it.hasnext) {
                    oos.writeObject(it.next);

                }

                oos.close;
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public void cargarPerros() {
                try {
                    ObjectInputStream ios = new ObjectInputStream( new FileInputStream("perros.dat")) {

                        while(true)

                        {
                            Perro perro = ((Perro) ios.readObject());
                            addDog(perro.getRaza(), perro);
                        }
                    }

                    ios.close();
            } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
    }



    // SETTER Y GETTER //
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

}
