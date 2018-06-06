package com.example.cheli.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.PopupMenu;

public class sala extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala);
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
