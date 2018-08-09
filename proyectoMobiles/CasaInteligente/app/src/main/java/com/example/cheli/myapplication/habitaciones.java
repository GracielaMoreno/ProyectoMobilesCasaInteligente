package com.example.cheli.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.HashMap;

import Modelos.controladores;
import Service.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class habitaciones extends AppCompatActivity {
    HashMap<String, String> bodyrequest = new HashMap<String, String>();
    ApiService apiService;
    Retrofit cliente;
    Modelos.controladores controladores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habitaciones);

        ToggleButton toggleButton=(ToggleButton)findViewById(R.id.toggleButtonPuerta);
        ToggleButton toggleButton1=(ToggleButton)findViewById(R.id.toggleButtonhabfoto);
        final ImageView imageView1=(ImageView)findViewById(R.id.imageViewPuertaHab);
        final ImageView imageView =(ImageView)findViewById(R.id.imageViewhaboitacionfoco);

        cliente = new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService = cliente.create(ApiService.class);
        toggleButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    bodyrequest.put("id", "dormitorio");
                    bodyrequest.put("tipo", "foco");
                    bodyrequest.put("accion", "encender");

                    imageView.setImageResource(R.drawable.foco);

                    apiService.dormitorioOff(bodyrequest).enqueue(new Callback<controladores>() {
                        @Override
                        public void onResponse(Call<controladores> call, Response<controladores> response) {

                            controladores= new controladores(""+response.body().getTipo(), ""+response.body().getId(),
                                    ""+response.body().getAccion());

                        }

                        @Override
                        public void onFailure(Call<controladores> call, Throwable t) {
                            Log.e("error", ""+t.getMessage());
                        }
                    });


                }else{
                    imageView.setImageResource(R.drawable.focooff2);
                    bodyrequest.put("id", "sala");
                    bodyrequest.put("tipo", "foco");
                    bodyrequest.put("accion", "encender");
                    apiService.dormitorio(bodyrequest).enqueue(new Callback<controladores>() {
                        @Override
                        public void onResponse(Call<controladores> call, Response<controladores> response) {

                            controladores= new controladores(""+response.body().getTipo(), ""+response.body().getId(),
                                    ""+response.body().getAccion());

                        }

                        @Override
                        public void onFailure(Call<controladores> call, Throwable t) {
                            Log.e("error", ""+t.getMessage());
                        }
                    });

                }
            }
        });
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    Log.e("e","checked"+checked);
                    imageView1.setImageResource(R.drawable.puertaabierta);
                    bodyrequest.put("id", "habitacion");
                    bodyrequest.put("tipo", "puerta");
                    bodyrequest.put("accion", "abierta");
                    apiService.encenderMotorSala(bodyrequest).enqueue(new Callback<controladores>() {
                        @Override
                        public void onResponse(Call<controladores> call, Response<controladores> response) {

                            controladores= new controladores(""+response.body().getTipo(), ""+response.body().getId(),
                                    ""+response.body().getAccion());

                        }

                        @Override
                        public void onFailure(Call<controladores> call, Throwable t) {
                            Log.e("error", ""+t.getMessage());
                        }
                    });

                }else{
                    imageView1.setImageResource(R.drawable.puerta2);
                    bodyrequest.put("id", "habitacion");
                    bodyrequest.put("tipo", "foco");
                    bodyrequest.put("accion", "encender");
                    apiService.apagarMotorSala(bodyrequest).enqueue(new Callback<controladores>() {
                        @Override
                        public void onResponse(Call<controladores> call, Response<controladores> response) {

                            controladores= new controladores(""+response.body().getTipo(), ""+response.body().getId(),
                                    ""+response.body().getAccion());

                        }

                        @Override
                        public void onFailure(Call<controladores> call, Throwable t) {
                            Log.e("error", ""+t.getMessage());
                        }
                    });

                }
            }
        });

        setTitle("Habitacion");

    }


}
