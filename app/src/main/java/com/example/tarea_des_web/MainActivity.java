package com.example.tarea_des_web;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view){

        Intent intent = null;

        switch (view.getId()){
            case R.id.btnRegistrar:
                intent = new Intent(this, RegistroProducto.class);
                break;
            case R.id.btnListar:
                intent = new Intent(this, ListarProducto.class);
                break;
            case R.id.btnListarRV:
                intent = new Intent(this, ListarProductoRV.class);
                break;
        }
        if (intent!=null){
            startActivity(intent);
        }
    }
}