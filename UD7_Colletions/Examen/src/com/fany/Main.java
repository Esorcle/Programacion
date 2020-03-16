package com.fany;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Propietario prop1 = new Propietario("Fany", "Ortiz", 3467, "España");
        Propietario prop2 = new Propietario("Jorge", "Collero", 7346, "Francia");
        Propietario prop3 = new Propietario("Abraham", "Perez", 25647, "Suecia");

        Perro perro1 = new Perro("Thais", 7, 22.10, Perro.Vacuna.SI, prop1, Perro.Raza.LABRADOR);
        Perro perro2 = new Perro("Zoe", 2, 23.56, Perro.Vacuna.NO, prop2, Perro.Raza.PASTORALEMAN);
        Perro perro3 = new Perro("Luna", 4, 43.7, Perro.Vacuna.SI, prop3, Perro.Raza.HUSKY);
        Perro perro4 = new Perro("Sol", 1, 56.43, Perro.Vacuna.SI, prop1, Perro.Raza.HUSKY);
        Perro perro5 = new Perro("Estrella", 5, 34.23, Perro.Vacuna.NO, prop2, Perro.Raza.PASTORALEMAN);
        Perro perro6 = new Perro("Poly", 4, 25.54, Perro.Vacuna.SI, prop3, Perro.Raza.LABRADOR);
        Perro perro7 = new Perro("Mika", 6, 12.78, Perro.Vacuna.SI, prop3, Perro.Raza.LABRADOR);
        Perro perro8 = new Perro("Lola", 10, 32.56, Perro.Vacuna.SI, prop2, Perro.Raza.PASTORALEMAN);
        Perro perro9 = new Perro("Leo", 8, 41.74, Perro.Vacuna.NO, prop1, Perro.Raza.LABRADOR);
        Perro perro10 = new Perro("Rudolf", 9, 21.54, Perro.Vacuna.SI, prop1, Perro.Raza.HUSKY);


        ConcursoCorreguido concurso = new ConcursoCorreguido("Velocity", "Sevilla");

        System.out.println(concurso.addDog(Perro.Raza.PASTORALEMAN, perro1));
        System.out.println(concurso.addDog(Perro.Raza.PASTORALEMAN, perro5));
        System.out.println(concurso.addDog(Perro.Raza.LABRADOR, perro7));
        System.out.println(concurso.addDog(Perro.Raza.HUSKY, perro10));

        System.out.println(concurso.disqualifyDog(perro7));

        System.out.println(concurso.perrosPorPeso(Perro.Raza.HUSKY));

        System.out.println(concurso.perrosporEdad(Perro.Raza.LABRADOR));


        concurso.guardarPerros();

        concurso.cargarPerros();

    }
}
