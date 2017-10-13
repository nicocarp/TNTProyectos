package com.example.nicoc.productos.Venta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.nicoc.productos.Database.Venta;
import com.example.nicoc.productos.R;
import com.example.nicoc.productos.Venta.ListaVentasFragment.ListaVentasFragment;

public class VentasMainActivity extends AppCompatActivity implements
        ListaVentasFragment.OnListaVentasFragmentInteraction {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas_main);
    }

    @Override
    public void onVentaSeleccionadaFragment(Venta venta) {
        String mje = "Venta seleccionada"+venta.getProducto().getNombre();
        Toast.makeText(getApplicationContext(), mje, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }
}
