package com.example.nicoc.productos.Venta.ListaVentasFragment;

import com.example.nicoc.productos.Database.Venta;

import java.util.List;

/**
 * Created by nicoc on 12/10/17.
 */

class ListaVentasPresenter implements IListaVentas.Presenter {

    private IListaVentas.View view;
    private IListaVentas.Model model;

    public ListaVentasPresenter(IListaVentas.View view) {
        this.view = view;
        this.model = new ListaVentasModel(this);
    }

    @Override
    public void onError(String error) {
        this.view.mostrarError(error);
    }

    @Override
    public void getItems() {
        this.model.getVentas();
    }

    @Override
    public void onReturnItems(List<Venta> ventas) {
        this.view.setItems(ventas);
    }
}
