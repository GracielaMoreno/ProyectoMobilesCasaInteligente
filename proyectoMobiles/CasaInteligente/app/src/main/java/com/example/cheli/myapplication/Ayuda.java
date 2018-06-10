package com.example.cheli.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Modelos.Persona;
import Modelos.controladores;
import Service.ApiService;
import retrofit2.Retrofit;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class Ayuda extends AppCompatActivity {

    List<controladores> listaPersonas;
    Retrofit cliente;
    ApiService apiService;
    ListView lista;
    int contador=0;
    ArrayAdapter<controladores> adapter;
    private ArrayList<controladores> controladores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        lista = (ListView) findViewById(R.id.listaEventos);
        controladores=new ArrayList<controladores>();

        cliente= new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.listaUsuarios().enqueue(new Callback<List<controladores>>() {
            @Override
            public void onResponse(Call<List<controladores>> call, Response<List<controladores>> response) {
                Log.i("Cliente","Cliente Android");
                if (response.isSuccessful()){
                    listaPersonas =response.body();
                    for (controladores controlador: listaPersonas){
                        contador++;
                        controladores.add(contador, new controladores(+controlador.getId(),""+controlador.getTipo(),""+controlador.getAccion()));

                    }
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<controladores>> call, Throwable t) {
                Log.i("Error",t.getMessage());

            }
        });




            controladores.add(0, new controladores(1, "dsd", "sdddd"));
            adapter = new ArrayAdapter<controladores>(getApplicationContext(),
                    R.layout.support_simple_spinner_dropdown_item, controladores);
            lista.setAdapter(adapter);




    }


}
