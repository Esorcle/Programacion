package com.fany;

import java.io.*;
import java.util.*;

public class ConcursoCorreguido implements Serializable {
    /**
     * Atributos clase Concurso
     */
    private String nombre;
    private String localidad;
    private Map<Perro.Raza, Set<Perro>> concursoPerros;

    /**
     * Constructor simple sin conjunto de perro
     *
     * @param nombre
     * @param localidad
     */
    public ConcursoCorreguido(String nombre, String localidad) {
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
        String resultado;
        if (raza.equals(perro.getRaza())) {
            Set<Perro> perrosSet = concursoPerros.get(raza);
            if (perrosSet == null) { // Indica que no exite esa clave
                perrosSet = new HashSet<>();
            }
            perrosSet.add(perro);
            concursoPerros.put(perro.getRaza(), perrosSet);
            resultado = "Perro añadido";
        } else {
            resultado = "Error, el perro introducido no pertenece a esa raza";
        }
        return resultado;
    }

    /**
     * Método para eliminar un perro del concurso
     *
     * @param perro
     * @return
     */
    public String disqualifyDog(Perro perro) {
        String resultado;
        Set<Perro> setPerros = concursoPerros.get(perro.getRaza());
        if ((setPerros == null) || !setPerros.remove(perro)) {
            resultado = "Perro no inscrito";
        } else {
            resultado = "Perro eliminado del concurso";
        }
        return resultado;
    }

    /**
     * Método para ordenar por pesos los perros de una misma raza
     *
     * @param raza
     */
    public List<Perro> perrosPorPeso(Perro.Raza raza) {
        // List<Perro> aux = new ArrayList<>(concursoPerros.get(raza)); // En un paso
        List<Perro> aux = new ArrayList<>();
        aux.addAll(concursoPerros.get(raza));
        Collections.sort(aux, new Comparator<Perro>() {
            @Override
            public int compare(Perro perro, Perro t1) {
                return Double.compare(perro.getPeso(), t1.getPeso());
            }
        });
        return aux;
    }


    public List<Perro> perrosporEdad(Perro.Raza raza) {
        List<Perro> aux = new ArrayList<>(concursoPerros.get(raza));
        Collections.sort(aux, new Comparator<Perro>() {
            @Override
            public int compare(Perro perro, Perro t1) {
                return Integer.compare(perro.getEdad(), t1.getEdad());
            }
        });
        return aux;
    }


    public void guardarPerros() throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos  = new ObjectOutputStream(new FileOutputStream("perros.dat"));
            Set<Map.Entry<Perro.Raza, Set<Perro>>> escribir = concursoPerros.entrySet();

            Iterator<Map.Entry<Perro.Raza, Set<Perro>>> it = escribir.iterator();
            while (it.hasNext()) {
                Set<Perro> aux = it.next().getValue();
                for (Perro p : aux) {
                    oos.writeObject(p);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null ) {
                oos.close();
            }
        }

    }

    public void cargarPerros() throws IOException {
        ObjectInputStream ios = null;

        try {
            ios = new ObjectInputStream(new FileInputStream("perros.dat"));

            while (true) {
                Perro perro = ((Perro) ios.readObject());
                addDog(perro.getRaza(), perro);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ios != null) {
                ios.close();
            }
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
