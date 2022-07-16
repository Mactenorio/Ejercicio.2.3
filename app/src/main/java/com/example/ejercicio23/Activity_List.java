package com.example.ejercicio23;

import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ejercicio23.transacciones.Transacciones;

import java.util.ArrayList;

public class Activity_List extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView simpleGridView = (ListView) findViewById(R.id.listView);
        SQLiteConexion help = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        ArrayList<Fotos> listaImagenes = new ArrayList<>();
        Cursor c= help.getAll();
        int i=0;
        if(c.getCount()>0)
        {
            c.moveToFirst();
            while(c.isAfterLast()==false)
            {
                byte[] bytes=c.getBlob(c.getColumnIndexOrThrow(Transacciones.blobImagen));
                String descripcion = c.getString(c.getColumnIndexOrThrow(Transacciones.descripcion));

                Fotos fotografia = new Fotos(BitmapFactory.decodeByteArray(bytes, 0, bytes.length), descripcion);
                listaImagenes.add(fotografia);
                c.moveToNext();
                i++;
            }

            Adapter myAdapter=new Adapter(this,R.layout.data_grid,listaImagenes);
            simpleGridView.setAdapter(myAdapter);
        }
    }
}