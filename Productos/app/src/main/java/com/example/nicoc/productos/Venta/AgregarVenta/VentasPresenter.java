package com.example.nicoc.productos.Venta.AgregarVenta;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.Database.Usuario;
import com.example.nicoc.productos.Database.Venta;
import com.example.nicoc.productos.MainActivity;

/**
 * Created by nicoc on 11/10/17.
 */

class VentasPresenter implements IVentas.Presenter {
    IVentas.Model model;
    IVentas.View view;

    public VentasPresenter(IVentas.View view){
        this.view = view;
        this.model = new VentasModel(this);
    }

    @Override
    public void mostrarError(String error) {
        this.view.mostrarError(error);
    }

    @Override
    public void comrpar(Producto producto, Integer cantidad) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences((Context) this.view);
        String id_usuario = preferences.getString(MainActivity.USER_ID, null);
        Usuario usuario = this.model.getUsuarioById(Long.valueOf(id_usuario));
        this.model.comprar(usuario, producto, cantidad);
    }

    @Override
    public void compraRealizada(Venta venta) {
        this.view.onCompraRealizada(venta);
    }
}
