import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Objeto Retrofit para las peticiones http
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://my-json-server.typicode.com/chemaduran/json_entrega1/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        //Variables a usar
        CentroAlumnos service = retrofit.create(CentroAlumnos.class);
        Alumno alumno = null;

        System.out.println("Listado de alumnos");
        try  {

            //La devolución de la petición
            Response<List<Alumno>> response = service.listAlumnos().execute();

            //Comprobamos que se ejecuta correctamente
            if(response.isSuccessful()) {
                List<Alumno> alumnoList = response.body();
                System.out.println(alumnoList);

            }else  {
                System.out.println("Petición no válida: " + response.message());
            }

        }catch (IOException e) {
            System.out.println("Error en la petición " + e.getMessage());
        }
    }
}
