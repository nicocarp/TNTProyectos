package com.example.nicoc.productos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.nicoc.productos.Producto.Agregar.AgregarProductoView;
import com.example.nicoc.productos.Producto.Listado.ListadoView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void agregarProducto(View v){
        startActivity(new Intent(MainActivity.this, AgregarProductoView.class));
    }
    public void listadoProductos(View v){
        startActivity(new Intent(MainActivity.this, ListadoView.class));
    }
}
