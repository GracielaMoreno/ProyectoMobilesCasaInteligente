package com.example.cheli.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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

public class alarma extends AppCompatActivity {
    ApiService apiService;
    Retrofit cliente;
    HashMap<String, String> bodyrequest = new HashMap<String, String>();
    Modelos.controladores controladores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarma);
        cliente = new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService = cliente.create(ApiService.class);

       final ImageView imageView = (ImageView)findViewById(R.id.imageView9);
       ToggleButton toggleButton = (ToggleButton)findViewById(R.id.toggleButton3);
       toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
               if(checked){
                   imageView.setImageResource(R.drawable.alarma);
                   bodyrequest.put("id", "casa");
                   bodyrequest.put("tipo", "sensor");
                   bodyrequest.put("accion", "sensando");

                   imageView.setImageResource(R.drawable.foco);
                   apiService.sensor(bodyrequest).enqueue(new Callback<controladores>() {
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
                imageView.setImageResource(R.drawable.alarma2);
                   bodyrequest.put("id", "casa");
                   bodyrequest.put("tipo", "sensor");
                   bodyrequest.put("accion", "detenido");

                   imageView.setImageResource(R.drawable.foco);
                   apiService.sensorapagar(bodyrequest).enqueue(new Callback<controladores>() {
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


        setTitle("Alarma");

    }

    public void abrirMenuAlarma(View view){{

        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(android.view.MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.activarAlarma:
                        return false;

                    case R.id.desactivarAlarma:
                        dialogAlert();
                        return true;

                    default:
                        return false;
                }

            }
        });

        popupMenu.inflate(R.menu.menu_alarma);
        popupMenu.show();

    }
    }
    public void dialogAlert(){
        AlertDialog.Builder alerDialog = new AlertDialog.Builder(this);
        alerDialog.setTitle("Confirmación");
        alerDialog.setMessage("Esta seguro que desea apagar la alarma?");
        alerDialog.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Si", Toast.LENGTH_LONG).show();
            }
        });

        alerDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "No", Toast.LENGTH_LONG).show();
            }
        });

        alerDialog.setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Cancelar", Toast.LENGTH_LONG).show();
            }
        });

        alerDialog.setCancelable(true); //aplastar la flecha del celular y sale del dialogo si pongo false obligo a que se aplaste el boton

        alerDialog.create();
        alerDialog.show();



    }

}
