package com.example.cheli.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import BD.AdminSQLiteOpenHelper;
import Modelos.Persona;

public class MainActivity extends AppCompatActivity {
    private GoogleApiClient googleApiClient;
    private final int CODERC = 9001;
    EditText nombre, contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Inicio");

        SignInButton botongoogle = (SignInButton) findViewById(R.id.logeogmail);
        botongoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logeoGmail();
            }
        });

        nombre=findViewById(R.id.editTextUsuario);
        contrasena=findViewById(R.id.editText2Password);



    }

    public void logeoGmail() {

        if (googleApiClient != null) {
            googleApiClient.disconnect();
        }
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions).build();
        Intent signIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(signIntent, CODERC);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODERC) {

            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);

            if (result.isSuccess()) {

                GoogleSignInAccount acc = result.getSignInAccount();

                Intent intent = new Intent(getApplicationContext(), Menu.class);

                Persona persona = new Persona(acc.getDisplayName(), acc.getEmail(), "+++");

                startActivity(intent);



            } else {

                Toast.makeText(this, "Error en ingreso con GMAIl", Toast.LENGTH_LONG).show();





            }

        }

    }



    public void pantallaMenus(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "casaInteligente", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();
        String dni = nombre.getText().toString();

        if(nombre.getText().toString().equals("") || contrasena.getText().toString().equals("")){

            Toast.makeText(getApplicationContext(),"Ingrese los datos",Toast.LENGTH_LONG).show();
        }
        else {
            Cursor fila = bd.rawQuery("select nombre, contrasena from usuario where nombre='"+dni+"'", null);
            if (fila.moveToFirst()) {

                do {
                    String nombreBD= fila.getString(0);
                    String contBD= fila.getString(1);
                    boolean existe=(nombreBD.equals(nombre.getText().toString()) && contBD.equals(contrasena.getText().toString()));
                    if(existe){
                        Intent intent = new Intent(getApplicationContext(), Menu.class);
                        startActivity(intent);
                        nombre.setText("");
                        contrasena.setText("");

                    }else {

                        Toast.makeText(getApplicationContext(), "No registrado", Toast.LENGTH_LONG).show();
                    }

                } while(fila.moveToNext());

            }else{

                Toast.makeText(getApplicationContext(), "No registrado", Toast.LENGTH_LONG).show();

            }

            bd.close();

        }

    }
    public void pantallaRegistro(View view){
        Intent intent = new Intent(getApplicationContext(), Registro.class);
        startActivity(intent);
    }


}
