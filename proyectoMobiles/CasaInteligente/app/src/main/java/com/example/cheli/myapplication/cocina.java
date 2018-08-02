package com.example.cheli.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Modelos.controladores;
import Modelos.id;
import Service.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class cocina extends AppCompatActivity{
    ApiService apiService;
    Retrofit cliente;
    HashMap<String, String> bodyrequest = new HashMap<String, String>();
    controladores controladores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocina);
        setTitle("Cocina");

        ToggleButton toggleButton=(ToggleButton)findViewById(R.id.toggleButtonFoco);
        ToggleButton toggleButton2=(ToggleButton)findViewById(R.id.toggleButton2);
        final ImageView imageView=(ImageView)findViewById(R.id.imageFoco);
        final ImageView imageView2=(ImageView)findViewById(R.id.imageCortina);
        cliente = new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService = cliente.create(ApiService.class);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    bodyrequest.put("id", "cocina");
                    bodyrequest.put("tipo", "foco");
                    bodyrequest.put("accion", "encender");

                    imageView.setImageResource(R.drawable.foco);
                    apiService.encenderLed(bodyrequest).enqueue(new Callback<controladores>() {
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
                    bodyrequest.put("id", "cocina");
                    bodyrequest.put("tipo", "foco");
                    bodyrequest.put("accion", "apagar");

                    apiService.apagarCocina(bodyrequest).enqueue(new Callback<controladores>() {
                        @Override
                        public void onResponse(Call<controladores> call, Response<controladores> response) {
                            Toast.makeText(cocina.this, ""+response.body().toString(), Toast.LENGTH_SHORT).show();
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
        toggleButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    imageView2.setImageResource(R.drawable.cortina);
                    bodyrequest.put("id", "cocina");
                    bodyrequest.put("tipo", "persiana");
                    bodyrequest.put("accion", "abrir");

                    apiService.encenderMotor(bodyrequest).enqueue(new Callback<controladores>() {
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
                    imageView2.setImageResource(R.drawable.persiana2);
                   /* bodyrequest.put("id", "cocina");
                    bodyrequest.put("tipo", "persiana");
                    bodyrequest.put("accion", "cerrar");
                    apiService.apagarMotor(bodyrequest).enqueue(new Callback<controladores>() {
                        @Override
                        public void onResponse(Call<controladores> call, Response<controladores> response) {
                            controladores= new controladores(""+response.body().getTipo(), ""+response.body().getId(),
                                    ""+response.body().getAccion());
                        }

                        @Override
                        public void onFailure(Call<controladores> call, Throwable t) {
                            Log.e("error", ""+t.getMessage());


                        }
                    });*/
                }
            }
        });

    }



}

