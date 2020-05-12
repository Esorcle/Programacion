import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Futbolista> futbolistas = new ArrayList<>();

        Futbolista fut1 = new Futbolista(1, "Casillas", new ArrayList<>(Arrays.asList("Portero")), "Real Madrid");
        Futbolista fut2 = new Futbolista(15, "Ramos", new ArrayList<>(Arrays.asList("Lateral derecho", "Medio centro")), "Real Madrid");
        Futbolista fut3 = new Futbolista(3, "Pique", new ArrayList<>(Arrays.asList("Central")), "FC Barcelona");
        Futbolista fut4 = new Futbolista(5, "Puyol", new ArrayList<>(Arrays.asList("Central")), "FC Barcelona");
        Futbolista fut5 = new Futbolista(11, "Capdevila", new ArrayList<>(Arrays.asList("Lateral izquierdo")), "Villareal");
        Futbolista fut6 = new Futbolista(14, "Xabi Alonso", new ArrayList<>(Arrays.asList("Defensa mediocampo", "Mediocampo")), "Real Madrid");
        Futbolista fut7 = new Futbolista(16, "Busquets", new ArrayList<>(Arrays.asList("Defensa mediocampo")), "FC Barcelona");
        Futbolista fut8 = new Futbolista(8, "Xavi Hernandez", new ArrayList<>(Arrays.asList("Mediocampo")), "FC Barcelona");
        Futbolista fut9 = new Futbolista(18, "Pedrito", new ArrayList<>(Arrays.asList("Extremo izquierdo", "Falso extremo")), "FC Barcelona");
        Futbolista fut10 = new Futbolista(6, "Iniesta", new ArrayList<>(Arrays.asList("Extremo derecho", "Mediocampo")), "FC Barcelona");
        Futbolista fut11 = new Futbolista(7, "Villa", new ArrayList<>(Arrays.asList("Delantero centro")), "FC Barcelona");

        futbolistas.add(fut1);
        futbolistas.add(fut2);
        futbolistas.add(fut3);
        futbolistas.add(fut4);
        futbolistas.add(fut5);
        futbolistas.add(fut6);
        futbolistas.add(fut7);
        futbolistas.add(fut8);
        futbolistas.add(fut9);
        futbolistas.add(fut10);
        futbolistas.add(fut11);

        //System.out.println(futbolistas);

        //Creamos un objeto tipo Gson
        Gson gson = new Gson();
        String futbolistaJason = gson.toJson(futbolistas);
        System.out.println(futbolistaJason);


    }
}

