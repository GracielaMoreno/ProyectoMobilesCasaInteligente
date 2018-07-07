package com.example.cheli.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Modelos.Persona;
import Modelos.controladores;
import Modelos.id;
import Service.ApiService;
import retrofit2.Retrofit;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class Ayuda extends AppCompatActivity {

    List<controladores> listaPersonas;
    List<Persona> listaP;
    Retrofit cliente;
    ApiService apiService;
    ListView lista;
    int contador = 0;
    AdapterListaEventos adapter;
    private ArrayList<controladores> controladores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
        setTitle("Registro de Eventos");


        lista = (ListView) findViewById(R.id.listaEventos);
        controladores = new ArrayList<controladores>();

        cliente = new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService = cliente.create(ApiService.class);

        apiService.listaUsuarios().enqueue(new Callback<List<controladores>>() {
            @Override
            public void onResponse(Call<List<controladores>> call, Response<List<controladores>> response) {
                if (response.isSuccessful()) {
                    listaPersonas = response.body();
                    Log.e("error", ""+response.body().toString());
                    for (controladores controlador : listaPersonas) {
                        contador++;
                        controladores.add(contador, new controladores(""+ controlador.getTipo(), "" +controlador.getId(), ""+ controlador.getAccion()));

                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<controladores>> call, Throwable t) {
                Log.i("Error", t.getMessage());

            }
        });

        controladores.add(0, new controladores("foco", "cocina", "desactivada"));

        adapter = new AdapterListaEventos(this, controladores);
        lista.setAdapter(adapter);




    }



}
