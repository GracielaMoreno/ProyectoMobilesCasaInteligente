package com.example.cheli.myapplication;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
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

public class sala extends AppCompatActivity {
    ApiService apiService;
    Retrofit cliente;
    HashMap<String, String> bodyrequest = new HashMap<String, String>();
    Modelos.controladores controladores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala);

        ToggleButton toggleButton1=(ToggleButton)findViewById(R.id.toggleButtonSalaPuerta);
        ToggleButton toggleButton= (ToggleButton)findViewById(R.id.toggleButtonSalaFoco);
        final ImageView imageView = (ImageView)findViewById(R.id.imageViewSalaFoCo);
        final ImageView imageView1 = (ImageView)findViewById(R.id.imageViewSalaPuerta);
        cliente = new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService = cliente.create(ApiService.class);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    imageView.setImageResource(R.drawable.foco);
                    bodyrequest.put("id", "sala");
                    bodyrequest.put("tipo", "foco");
                    bodyrequest.put("accion", "encender");
                    apiService.sala(bodyrequest).enqueue(new Callback<controladores>() {
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
                    bodyrequest.put("accion", "apagar");

                    apiService.salaOff(bodyrequest).enqueue(new Callback<controladores>() {
                        @Override
                        public void onResponse(Call<controladores> call, Response<controladores> response) {
                            Toast.makeText(sala.this, ""+response.body().toString(), Toast.LENGTH_SHORT).show();
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
        toggleButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    Log.e("e","checked"+checked);
                    imageView1.setImageResource(R.drawable.puertaabierta);
                    bodyrequest.put("id", "sala");
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
                    imageView1.setImageResource(R.drawable.puerta);
                    bodyrequest.put("id", "sala");
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

        setTitle("Sala");

    }


}
