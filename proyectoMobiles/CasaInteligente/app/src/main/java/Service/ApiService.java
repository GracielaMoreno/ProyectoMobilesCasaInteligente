package Service;

import java.util.List;

import Modelos.Persona;
import Modelos.controladores;
import Modelos.id;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface ApiService {
    public static final String URL="http://192.168.1.8:5000";

    @GET("/controladores")
    Call<List<controladores>>listaUsuarios();

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("/led")
    Call<id> createUser(@Body id id);

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("/ledOff")
    Call<id> apagarCocina(@Body id id);

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("/motorEncendido")
    Call<id> encenderMotor(@Body id id);

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("/motorApagado")
    Call<id> apagarMotor(@Body id id);
}