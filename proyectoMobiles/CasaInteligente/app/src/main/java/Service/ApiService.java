package Service;

import java.util.List;
import java.util.Map;

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

    @Headers("Content-Type: application/json")
    @GET("/controladores")
    Call<List<controladores>>listaUsuarios();

    @Headers("Content-Type: application/json")
    @POST("/led")
    Call<controladores> encenderLed(@Body Map<String, String> body);

    @Headers("Content-Type: application/json")
    @POST("/ledOff")
    Call<controladores> apagarCocina(@Body Map<String, String> body);

    @Headers("Content-Type: application/json")
    @POST("/motorEncendido")
    Call<controladores> encenderMotor(@Body Map<String, String> body);

    @Headers("Content-Type: application/json")
    @POST("/motorApagado")
    Call<controladores> apagarMotor(@Body Map<String, String> body);
}