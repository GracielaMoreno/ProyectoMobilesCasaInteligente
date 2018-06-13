package com.example.cheli.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

public class cocina extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocina);
        ToggleButton toggleButton=(ToggleButton)findViewById(R.id.toggleButtonFoco);

        final ImageView imageView=(ImageView)findViewById(R.id.imageFoco);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    Log.e("e","checked"+checked);
                    imageView.setImageResource(R.drawable.alarma1);

                }else{
                    imageView.setImageResource(R.drawable.foco);
                }
            }
        });

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

                popupMenu.inflate(R.menu.menu_foco_cocina);
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

