package com.example.cheli.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupMenu;

public class cocina extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocina);

    }


    public void abrirMenuFoco(View view){{

        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(android.view.MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.apagarFocoCocina:
                        return false;

                    case R.id.encenderFocoCocina:
                        return true;

                    default:
                        return false;
                }

            }
            });

                popupMenu.inflate(R.menu.menu_foco);
                popupMenu.show();
        }
    }

    public void abrirMenuCortina(View view){{

        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(android.view.MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.abrirCortinaCocina:
                        return false;

                    case R.id.cerrarCortinaCocina:
                        return true;

                    default:
                        return false;
                }

            }
        });

        popupMenu.inflate(R.menu.menu_cortina);
        popupMenu.show();
    }
    }

}

