package com.example.nicoc.productos.Venta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.R;
import com.example.nicoc.productos.Venta.ListadoFragment.ListadoProductosFragment;

public class ListadoVentas extends AppCompatActivity implements ListadoProductosFragment.onProductoSeleccionadoListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_ventas);
    }

    @Override
    public void onProductoSeleccionadoFragment(Producto producto) {

    }
}
