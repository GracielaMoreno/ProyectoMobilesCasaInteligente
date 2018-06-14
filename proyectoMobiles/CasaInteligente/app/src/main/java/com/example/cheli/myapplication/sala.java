package com.example.cheli.myapplication;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ToggleButton;

public class sala extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala);
        ToggleButton toggleButton1=(ToggleButton)findViewById(R.id.toggleButtonSalaPuerta);
        ToggleButton toggleButton= (ToggleButton)findViewById(R.id.toggleButtonSalaFoco);
        final ImageView imageView = (ImageView)findViewById(R.id.imageViewSalaFoCo);
        final ImageView imageView1 = (ImageView)findViewById(R.id.imageViewSalaPuerta);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
        toggleButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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

    public void abrirMenuFocoSala(View view){{

        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(android.view.MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.encenderFocoSala:
                        return false;

                    case R.id.apagarFocoSala:
                        return true;

                    default:
                        return false;
                }

            }
        });

        popupMenu.inflate(R.menu.menu_foco_sala);
        popupMenu.show();
    }
    }

    public void abrirPuertaSala (View view){{

        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(android.view.MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.abrirPuertaSala:
                        return false;

                    case R.id.cerrarPuertaSala:
                        return true;

                    default:
                        return false;
                }

            }
        });

        popupMenu.inflate(R.menu.menu_puerta_sala);
        popupMenu.show();
    }
    }
}
