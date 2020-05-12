import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        //Instanciamos objeto Retrofit para las peticiones https
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://my-json-server.typicode.com/chemaduran/futbolistas_api_demo/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        //Variables a usar
        PlantillaFutbolistas service = retrofit.create(PlantillaFutbolistas.class);
        Futbolista futbolista = null;

        System.out.println("Listado completo de futbolistas");
        try{
            //Lo que nos devuelve la petición
            Response<List<Futbolista>> response = service.listJugadores().execute();
            //Comprobamos que se haya ejecutado correctamente
            if(response.isSuccessful()) {
                //Guardamos el cuerpo de Json, gracias a retrofit sin parsear
                List<Futbolista> futbolistaList = response.body();
                System.out.println(futbolistaList);
            } else {
                System.out.println("Petición no válida: " + response.message());
            }

        } catch (IOException e) {
            System.out.println("Error en la petición " + e.getMessage());
        }
    }
}
