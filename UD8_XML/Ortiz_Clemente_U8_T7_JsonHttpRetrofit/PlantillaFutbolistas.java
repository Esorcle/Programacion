import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface PlantillaFutbolistas {

    //https://my-json-server.typicode.com/chemaduran/futbolistas_api_demo/jugadores
    @GET("jugadores")
    Call<List<Futbolista>> listJugadores();
}
