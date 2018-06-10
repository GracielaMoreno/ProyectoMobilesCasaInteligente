package Service;

import java.util.List;

import Modelos.Persona;
import Modelos.controladores;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiService {
    public static final String URL="https://proy-moviles-caro2594.c9users.io/";

    @GET("controladores.json")
    Call<List<controladores>>listaUsuarios();
}