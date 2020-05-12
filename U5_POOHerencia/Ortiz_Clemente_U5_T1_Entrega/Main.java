package garaje;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        //Creo variables
        Coche coche1 = new Coche("Seat",4,"46354SDF", 2017, Terrestre.Color.AZUL);
        Coche coche2 = new Coche("Ford",5,"2454CRF", 2018, Terrestre.Color.AMARILLO);
        Coche coche3 = new Coche("Mazda",4,"16454KLF", 2019, Terrestre.Color.ROJO);

        Coche[] coches = new Coche[3];
        coches[0] = coche1;
        coches[1] = coche2;
        coches[2] = coche3;

        //Ordeno por defecto. Matrícula
        System.out.println("Ordenación de coches por matrícula");
        Arrays.sort(coches);

        System.out.println(Arrays.deepToString(coches));

        Motocicleta[] motocicletas = new Motocicleta[3];
        motocicletas[0] = new Motocicleta("Yamaha", 2,"9865GHY", 2020, Terrestre.Color.VERDE);
        motocicletas[1] = new Motocicleta("Honda", 2,"1245JHY", 2017, Terrestre.Color.AZUL);
        motocicletas[2] = new Motocicleta("Aprilia", 2,"4665PSY", 2019, Terrestre.Color.VERDE);

        System.out.println();
        //Ordeno por matrícula
        System.out.println("Ordenación de motocicletas por matrícula");
        Arrays.sort(motocicletas);
        System.out.println(Arrays.deepToString(motocicletas));

        System.out.println();
        //Método transportar;
        System.out.println("Prueba si caben 4 personas en el coche 1");
        System.out.println(coche1.transportar(4));
        System.out.println();

        //Clase anonima para ordenar por año de matriculación
        Arrays.sort(coches, new Comparator<Coche>() {
            @Override
            public int compare(Coche coche, Coche t1) {
                return coche.getAniomatricula() - t1.getAniomatricula();
            }
        });

        //Lo compruebo
        System.out.println("Ordenación de coches por número de matriculación");
        System.out.println(Arrays.deepToString(coches));

        Helicoptero helicoptero = new Helicoptero("Volador", 9,"UP-A300I");

        System.out.println();
        //Transporta 9 personas
        System.out.println("Prueba si caben 9 personas en el helicoptero");
        System.out.println(helicoptero.transportar(9));
        System.out.println();

        //Lo hago volar
        helicoptero.setAltitud(1500);

        //Mostrar contenido del helicoptero
        System.out.print("La información del helicoptero es: ");
        System.out.printf(helicoptero.toString());
    }
}
