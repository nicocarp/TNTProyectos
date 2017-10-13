package com.example.nicoc.productos.Venta.ListadoProductoFragment;

import com.example.nicoc.productos.Database.ManagerDB;
import com.example.nicoc.productos.Database.Producto;

import java.util.List;

/**
 * Created by nicoc on 08/10/17.
 */

class ListadoProductoModel implements IListadoProductos.Model {

    private IListadoProductos.Presenter presenter;
    private ManagerDB managerDB;

    public ListadoProductoModel(IListadoProductos.Presenter presenter) {
        this.presenter = presenter;
        this.managerDB = ManagerDB.getInstance();
    }


    /**
     * Recuperamos los objetos Productos para venderse.
     */
    @Override
    public void getProductos() {
        List<Producto> productos = managerDB.getProductos();
        if  (productos.size() > 0)
            presenter.setItems(productos);
        else
            presenter.mostrarError("Sin productos");
    }
}
