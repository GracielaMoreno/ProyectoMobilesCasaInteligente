package com.example.cheli.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void pantallaSala(View view){

        Intent intent = new Intent(getApplicationContext(), sala.class);
        startActivity(intent);
    }

    public void pantallaCocina(View view){

        Intent intent = new Intent(getApplicationContext(), cocina.class);
        startActivity(intent);
    }

    public void pantallaHabitacion(View view){

        Intent intent = new Intent(getApplicationContext(), habitaciones.class);
        startActivity(intent);
    }

    public void pantallaAlarma(View view){
        Intent intent = new Intent(getApplicationContext(), alarma.class);
        startActivity(intent);

    }

    public void pantallaAyuda(View view){
        Intent intent = new Intent(getApplicationContext(), Ayuda.class);
        startActivity(intent);

    }
}
