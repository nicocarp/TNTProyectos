package com.example.nicoc.productos.Venta.ListadoProductoFragment;

import com.example.nicoc.productos.Database.Producto;

import java.util.List;

/**
 * Created by nicoc on 08/10/17.
 */

class ListadoProductosPresenter implements IListadoProductos.Presenter {

    private IListadoProductos.View view;
    private IListadoProductos.Model model;

    public ListadoProductosPresenter(IListadoProductos.View view) {
        this.view = view;
        this.model = new ListadoProductoModel(this);
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
