package com.example.nicoc.productos.Producto.Listado;

import com.example.nicoc.productos.Database.ManagerDB;
import com.example.nicoc.productos.Database.Producto;

import java.util.List;

/**
 * Created by nicoc on 26/09/17.
 */

public class ListadoModel implements IListado.Model {

    private IListado.Presenter presenter;
    private ManagerDB manager;

    public ListadoModel(IListado.Presenter presenter) {
        this.presenter = presenter;
        this.manager = ManagerDB.getInstance();
    }

    @Override
    public void getProductos() {
        List<Producto> productos = this.manager.getProductos();
        if  (productos.size() > 0)
            this.presenter.setItems(productos);
        else
            this.presenter.mostrarError("Sin productos");
    }

    @Override
    public void actualizarProducto(Producto p) {
        try {
            this.manager.updateProducto(p);
        }catch (Exception e){
            this.presenter.mostrarError("Ocurrio un error al actualizar el producto");
        }

    }

}
