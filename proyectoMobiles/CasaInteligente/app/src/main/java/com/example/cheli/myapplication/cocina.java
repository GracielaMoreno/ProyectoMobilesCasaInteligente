package com.example.cheli.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import Modelos.id;
import Service.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class cocina extends AppCompatActivity{
    ApiService apiService;
    id idprueba;
    Retrofit cliente;

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
                    Log.e("e","checked"+checked);
                    imageView.setImageResource(R.drawable.foco);
                    id idp =new id("4");
                    apiService.createUser(idp).enqueue(new Callback<id>() {
                        @Override
                        public void onResponse(Call<id> call, Response<id> response) {
                            idprueba=response.body();

                            Log.e("bien", idprueba.toString());
                        }

                        @Override
                        public void onFailure(Call<id> call, Throwable t) {

                        }
                    });



                }else{
                    imageView.setImageResource(R.drawable.focooff2);
                    id idp =new id("4");
                    apiService.apagarCocina(idp).enqueue(new Callback<id>() {
                        @Override
                        public void onResponse(Call<id> call, Response<id> response) {
                            idprueba=response.body();

                            Log.e("bien", idprueba.toString());
                        }

                        @Override
                        public void onFailure(Call<id> call, Throwable t) {

                        }
                    });
                }
            }
        });
        toggleButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    Log.e("e","checked"+checked);
                    imageView2.setImageResource(R.drawable.cortina);

                    id idp =new id("4");
                    apiService.encenderMotor(idp).enqueue(new Callback<id>() {
                        @Override
                        public void onResponse(Call<id> call, Response<id> response) {
                            idprueba=response.body();

                            Log.e("bien", idprueba.toString());
                        }

                        @Override
                        public void onFailure(Call<id> call, Throwable t) {

                        }
                    });

                }else{
                    imageView2.setImageResource(R.drawable.persiana2);
                    id idp =new id("4");
                    apiService.apagarMotor(idp).enqueue(new Callback<id>() {
                        @Override
                        public void onResponse(Call<id> call, Response<id> response) {



                            Log.e("bien", "");
                        }

                        @Override
                        public void onFailure(Call<id> call, Throwable t) {

                        }
                    });
                }
            }
        });

    }


    public void abrirMenuFoco(View view){{

        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(android.view.MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.apagarFocoCocina:
                        return false;

                    case R.id.encenderFocoCocina:
                        return true;

                    default:
                        return false;
                }

            }
            });

                popupMenu.inflate(R.menu.menu_foco_cocina);
                popupMenu.show();
        }
    }

    public void abrirMenuCortina(View view){{

        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(android.view.MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.abrirCortinaCocina:
                        return false;

                    case R.id.cerrarCortinaCocina:
                        return true;

                    default:
                        return false;
                }

            }
        });

        popupMenu.inflate(R.menu.menu_cortina);
        popupMenu.show();
    }
    }


}

