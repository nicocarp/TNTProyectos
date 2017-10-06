package com.example.nicoc.productos.Producto.Listado;

import com.example.nicoc.productos.Database.Producto;
import java.util.List;

/**
 * Created by nicoc on 26/09/17.
 */

public class ListadoPresenter implements IListado.Presenter{
    private IListado.View view;
    private IListado.Model model;

    public ListadoPresenter(IListado.View view) {
        this.view = view;
        this.model = new ListadoModel(this);
    }

    @Override
    public void getItems() {
        this.model.getProductos();
    }

    @Override
    public void setItems(List<Producto> items){
        this.view.setItems(items);
    }

    @Override
    public void lanzarProductoDetalle(Producto producto) {
        this.view.lanzarDetalleProducto(producto);
    }

    @Override
    public void mostrarError(String error) {
        this.view.mostrarError(error);
    }
}
