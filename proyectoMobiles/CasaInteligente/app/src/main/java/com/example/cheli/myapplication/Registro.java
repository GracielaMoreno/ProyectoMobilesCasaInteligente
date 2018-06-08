package com.example.cheli.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Modelos.Persona;

public class Registro extends AppCompatActivity {

    EditText nombre, contrasena, verificacion, correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre=(EditText)findViewById(R.id.nombreRegistro);
        correo=(EditText)findViewById(R.id.correoRegistro);
        contrasena= (EditText)findViewById(R.id.contrasenaRegistro);
        verificacion=(EditText)findViewById(R.id.contrasena);




    }

    public void pantallaMenu(View view){

        if(contrasena.getText().toString().equals(verificacion.getText().toString())){
            Persona persona = new Persona(nombre.getText().toString(), correo.getText().toString(), contrasena.getText().toString());
            Intent intent = new Intent(getApplicationContext(), Menu.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),"No coincide la contraseña", Toast.LENGTH_LONG).show();

        }


    }
}
