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
    public static final String URL="http://172.29.65.179:5000";

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
    @POST("/dormitorioled")
    Call<controladores> dormitorio(@Body Map<String, String> body);

    @Headers("Content-Type: application/json")
    @POST("/dormitorioledOff")
    Call<controladores> dormitorioOff(@Body Map<String, String> body);

    @Headers("Content-Type: application/json")
    @POST("/salaled")
    Call<controladores> sala(@Body Map<String, String> body);

    @Headers("Content-Type: application/json")
    @POST("/salaledOff")
    Call<controladores> salaOff(@Body Map<String, String> body);

    @Headers("Content-Type: application/json")
    @POST("/banioled")
    Call<controladores> banio(@Body Map<String, String> body);

    @Headers("Content-Type: application/json")
    @POST("/banioledOff")
    Call<controladores> banioOff(@Body Map<String, String> body);

    @Headers("Content-Type: application/json")
    @POST("/motorEncendido")
    Call<controladores> encenderMotor(@Body Map<String, String> body);

    @Headers("Content-Type: application/json")
    @POST("/motorApagado")
    Call<controladores> apagarMotor(@Body Map<String, String> body);

    @Headers("Content-Type: application/json")
    @POST("/puertaCerradaSala")
    Call<controladores> encenderMotorSala(@Body Map<String, String> body);

    @Headers("Content-Type: application/json")
    @POST("/puertaAbiertaSala")
    Call<controladores> apagarMotorSala(@Body Map<String, String> body);

    @Headers("Content-Type: application/json")
    @POST("/ventanaAbiertaCocina")
    Call<controladores> encenderMotorCocina(@Body Map<String, String> body);

    @Headers("Content-Type: application/json")
    @POST("/ventanaCerradaCocina")
    Call<controladores> apagarMotorCocina(@Body Map<String, String> body);

    @Headers("Content-Type: application/json")
    @POST("/Advertencia")
    Call<controladores> sensor(@Body Map<String, String> body);

    @Headers("Content-Type: application/json")
    @POST("//noAutorizacion")
    Call<controladores> sensorapagar(@Body Map<String, String> body);

}