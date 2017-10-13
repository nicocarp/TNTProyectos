package com.example.nicoc.productos.Venta.ListaVentasFragment;

import com.example.nicoc.productos.Database.ManagerDB;
import com.example.nicoc.productos.Database.Venta;

import java.util.List;

/**
 * Created by nicoc on 12/10/17.
 */

class ListaVentasModel implements IListaVentas.Model {

    private IListaVentas.Presenter presenter;
    private ManagerDB manager;

    public ListaVentasModel(IListaVentas.Presenter presenter) {
        this.presenter=presenter;
        this.manager = ManagerDB.getInstance();
    }

    @Override
    public void getVentas() {
        try{
            this.presenter.onReturnItems(manager.getVentas());
        }
        catch(Exception e){
            this.presenter.onError(e.getMessage().toString());
        }
    }
}
