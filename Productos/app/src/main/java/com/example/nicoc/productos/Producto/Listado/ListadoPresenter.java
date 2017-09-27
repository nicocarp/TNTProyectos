package com.example.nicoc.productos.Producto.Listado;

import com.example.nicoc.productos.Database.Producto;

import java.util.ArrayList;
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
    public void getProductos() {
        this.model.getProductos();
    }

    @Override
    public void listadoProductos(List<Producto> productos) {
        List<String> nombres =  new ArrayList<String>();;
        for (Producto p : productos){
            nombres.add(p.getNombre());
        }
        this.view.setListado(nombres);

    }

    @Override
    public void mostrarError(String error) {
        this.view.mostrarError(error);
    }
}
