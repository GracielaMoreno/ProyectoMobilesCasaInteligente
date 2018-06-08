package com.example.cheli.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import Modelos.Persona;

public class MainActivity extends AppCompatActivity {
    private GoogleApiClient googleApiClient;
    private final int CODERC = 9001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SignInButton botongoogle = (SignInButton) findViewById(R.id.logeogmail);
        botongoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logeoGmail();
            }
        });
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

        Intent intent = new Intent(getApplicationContext(), Menu.class);
        startActivity(intent);
    }

}
