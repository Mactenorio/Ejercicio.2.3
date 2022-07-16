package com.example.ejercicio23;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Fotos> {

    ArrayList<Fotos> listaImagenes = new ArrayList<>();

    public Adapter(Context context, int textViewResourceId, ArrayList<Fotos> objects) {
        super(context, textViewResourceId, objects);
        listaImagenes = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.data_grid, null);
        ImageView imageView = (ImageView) v.findViewById(R.id.imagenes);
        imageView.setImageBitmap(listaImagenes.get(position).getImagen());
        TextView textView = (TextView) v.findViewById(R.id.descripcion);
        textView.setText(listaImagenes.get(position).getDescripcion());
        return v;
    }

}
