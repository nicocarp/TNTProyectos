package com.example.nicoc.productos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nicoc.productos.Producto.Agregar.AgregarProductoView;
import com.example.nicoc.productos.Producto.Listado.ListadoView;
import com.example.nicoc.productos.Venta.ListadoVentas;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.btnAgregarProducto) void lanzarAgregarProducto(){
        startActivity(new Intent(MainActivity.this, AgregarProductoView.class));
    }

    @OnClick(R.id.btnListadoProductos) void lanzarListadoProductos(){
        startActivity(new Intent(MainActivity.this, ListadoView.class));
    }

    @OnClick(R.id.btnListadoVentas) void lanzarListadoVentas(){
        startActivity(new Intent(MainActivity.this, ListadoVentas.class));
    }
}
