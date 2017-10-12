package com.example.nicoc.productos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nicoc.productos.Producto.Agregar.AgregarProductoView;
import com.example.nicoc.productos.Producto.Listado.ListadoView;
import com.example.nicoc.productos.Venta.VentasView;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    public static final String USER_ID = "id_usuario_logueado";

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
        startActivity(new Intent(MainActivity.this, VentasView.class));
    }
}
