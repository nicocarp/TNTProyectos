package com.example.nicoc.productos.Venta.ListadoFragment;

import com.example.nicoc.productos.Database.ManagerDB;
import com.example.nicoc.productos.Database.Producto;

import java.util.List;

/**
 * Created by nicoc on 08/10/17.
 */

class VentasModel implements IVentas.Model {

    private IVentas.Presenter presenter;
    private ManagerDB managerDB;

    public VentasModel(IVentas.Presenter presenter) {
        this.presenter = presenter;
        this.managerDB = ManagerDB.getInstance();
    }

    @Override
    public void getProductos() {
        List<Producto> productos = managerDB.getProductos();
        if  (productos.size() > 0)
            presenter.setItems(productos);
        else
            presenter.mostrarError("Sin productos");
    }
}
