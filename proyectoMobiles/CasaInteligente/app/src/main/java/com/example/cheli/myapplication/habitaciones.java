package com.example.cheli.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ToggleButton;

public class habitaciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habitaciones);
        ToggleButton toggleButton=(ToggleButton)findViewById(R.id.toggleButtonPuerta);
        ToggleButton toggleButton1=(ToggleButton)findViewById(R.id.toggleButtonhabfoto);
        final ImageView imageView1=(ImageView)findViewById(R.id.imageViewPuertaHab);
        final ImageView imageView =(ImageView)findViewById(R.id.imageViewhaboitacionfoco);

        toggleButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    Log.e("e","checked"+checked);
                    imageView.setImageResource(R.drawable.foco);

                }else{
                    imageView.setImageResource(R.drawable.focooff2);
                }
            }
        });
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    Log.e("e","checked"+checked);
                    imageView1.setImageResource(R.drawable.puerta);

                }else{
                    imageView1.setImageResource(R.drawable.puertaabierta);
                }
            }
        });
    }

    public void abrirMenuFocoHabitacion(View view){{

        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(android.view.MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.apagarFocoCocinaHabitacion:
                        return false;

                    case R.id.encenderFocoHabitacion:
                        return true;

                    default:
                        return false;
                }

            }
        });

        popupMenu.inflate(R.menu.menu_foco_habitacion);
        popupMenu.show();
    }
    }


    public void abrirPuertaHabitacion (View view){{

        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(android.view.MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.abrirPuertaHabitacion:
                        return false;

                    case R.id.cerrarPuertaHabitacion:
                        return true;

                    default:
                        return false;
                }

            }
        });

        popupMenu.inflate(R.menu.menu_puerta_habitacion);
        popupMenu.show();
    }
    }
}
