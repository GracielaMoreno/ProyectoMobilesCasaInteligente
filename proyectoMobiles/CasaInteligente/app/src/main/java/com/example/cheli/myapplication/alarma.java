package com.example.cheli.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.ToggleButton;

public class alarma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarma);
       final ImageView imageView = (ImageView)findViewById(R.id.imageView9);
       ToggleButton toggleButton = (ToggleButton)findViewById(R.id.toggleButton3);
       toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
               if(checked){
                   imageView.setImageResource(R.drawable.alarma);
               }else{
                imageView.setImageResource(R.drawable.alarma2);
               }
           }
       });

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
