package com.example.cheli.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void pantallaMenu(View view){

            Intent intent = new Intent(getApplicationContext(), Menu.class);
            startActivity(intent);

    }
}
