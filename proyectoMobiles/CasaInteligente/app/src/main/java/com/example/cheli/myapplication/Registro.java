package com.example.cheli.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import BD.AdminSQLiteOpenHelper;
import Modelos.Persona;

public class Registro extends AppCompatActivity {

    EditText nombre, contrasena, verificacion, correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        setTitle("Registro");

        nombre=(EditText)findViewById(R.id.nombreRegistro);
        correo=(EditText)findViewById(R.id.correoRegistro);
        contrasena= (EditText)findViewById(R.id.contrasenaRegistro);
        verificacion=(EditText)findViewById(R.id.contrasena);

    }

    public void pantallaMenu(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "casaInteligente", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();

        if(contrasena.getText().toString().equals("") && verificacion.getText().toString().equals("") && correo.getText().toString().equals("") &&
                nombre.getText().toString().equals("")){
            Toast.makeText(this, "Ingrese sus datos", Toast.LENGTH_SHORT).show();

        }else{
            if(contrasena.getText().toString().equals(verificacion.getText().toString())){
                Persona persona = new Persona(nombre.getText().toString(), correo.getText().toString(), contrasena.getText().toString());
                registro.put("nombre", persona.getNombre());
                registro.put("correo",persona.getCorreo());
                registro.put("contrasena", persona.getContrasena());
                bd.insert("usuario", null, registro);
                bd.close();

                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);


                Toast.makeText(getApplicationContext(), "Datos del usuario cargados", Toast.LENGTH_LONG).show();

                nombre.setText("");
                correo.setText("");
                contrasena.setText("");
                verificacion.setText("");

                Toast.makeText(this, "Datos del usuario cargados", Toast.LENGTH_SHORT).show();


            }
            else{
                Toast.makeText(getApplicationContext(),"No coincide la contraseña", Toast.LENGTH_LONG).show();

            }
        }



    }
}
