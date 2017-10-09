package com.example.nicoc.productos.Venta.ListadoFragment;

import com.example.nicoc.productos.Database.Producto;

import java.util.List;

/**
 * Created by nicoc on 08/10/17.
 */

class VentasPresenter implements IVentas.Presenter {

    private IVentas.View view;
    private IVentas.Model model;

    public VentasPresenter(IVentas.View view) {
        this.view = view;
        this.model = new VentasModel(this);
    }

    @Override
    public void getItems() {
        this.model.getProductos();
    }

    @Override
    public void setItems(List<Producto> productos) {
        this.view.setItems(productos);
    }

    @Override
    public void mostrarError(String error) {
        this.view.mostrarError(error);

    }
}
