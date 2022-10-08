package com.example.tarea_des_web;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tarea_des_web.utilidades.Assets;

import java.util.ArrayList;

public class ListarRecycleView extends AppCompatActivity {

    ArrayList<String> ListDatos;
    RecyclerView recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_recycle_view);


        try {
            recycler = (RecyclerView) findViewById(R.id.reciclerId);
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            ListDatos = new ArrayList<String>();


            Connection conexion = new Connection(this, Assets.DB_NAME, null, Assets.DB_VERSION);
            SQLiteDatabase sqLiteDatabase = conexion.getReadableDatabase();

            String query = "SELECT * FROM " + Assets.TABLA_PRODUCTO;


            Cursor result = sqLiteDatabase.rawQuery(query, null);

            while (result.moveToNext()) {

                ListDatos.add("\n Codigo:  " + result.getString(0) +
                        "\n Nombre:  " + result.getString(1) +
                        "\n Precio:  " + result.getString(2));
            }
            Toast.makeText(getApplicationContext(),"Lista Mostrada", Toast.LENGTH_LONG).show();

        }catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Error no se Puede mostrar lista",Toast.LENGTH_LONG).show();
        }


        AdapterDatos adapter =new AdapterDatos(ListDatos);
        recycler.setAdapter(adapter);
    }
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btnRegresar:
                intent = new Intent(this, MainActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}