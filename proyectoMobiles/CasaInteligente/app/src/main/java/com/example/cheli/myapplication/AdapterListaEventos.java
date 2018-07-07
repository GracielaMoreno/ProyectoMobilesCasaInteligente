package com.example.cheli.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import Modelos.controladores;


public class AdapterListaEventos extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<controladores> items;
    transient TextView title, descripcion, accion;

    public AdapterListaEventos (Activity activity, ArrayList<controladores> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public void addAll(ArrayList<controladores> category) {
        for (int i = 0; i < category.size(); i++) {
            items.add(category.get(i));
        }
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf =  (LayoutInflater) this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.elemento_lista, null);
        }

        controladores dir = items.get(position);

        title=(TextView) v.findViewById(R.id.titulo);

        title.setText("Lugar: "+String.valueOf(dir.getId()));

        descripcion = (TextView) v.findViewById(R.id.controladorDescripcion);
        descripcion.setText("Tipo: "+dir.getTipo());

        accion = (TextView) v.findViewById(R.id.accionControlador);
        accion.setText("Accion: "+dir.getAccion());

        return v;
    }
}