package com.example.cheli.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.PopupMenu;

public class habitaciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habitaciones);
        setTitle("Habitacion");
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
