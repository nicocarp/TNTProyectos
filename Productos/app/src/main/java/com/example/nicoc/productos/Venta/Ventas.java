package com.example.nicoc.productos.Venta;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.R;
import com.example.nicoc.productos.Venta.InforProductoFragment.InforProductoFragment;
import com.example.nicoc.productos.Venta.ListadoFragment.ListadoProductosFragment;

public class Ventas extends AppCompatActivity
        implements ListadoProductosFragment.onProductoSeleccionadoListener,
        InforProductoFragment.onInforProductoFragmentListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_ventas);
    }

    @Override
    public void onProductoSeleccionadoFragment(Producto producto) {
        InforProductoFragment frag = ((InforProductoFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentInfoProducto));
        frag.setInfoProducto(producto);
    }

    @Override
    public void mostrarError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }
}
