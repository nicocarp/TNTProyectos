package com.example.nicoc.productos.Venta;

import com.example.nicoc.productos.Database.ManagerDB;
import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.Database.Usuario;
import com.example.nicoc.productos.Database.Venta;

/**
 * Created by nicoc on 11/10/17.
 */

class VentasModel implements IVentas.Model {
    private IVentas.Presenter presenter;
    private ManagerDB manager;

    public VentasModel(IVentas.Presenter presenter) {
        this.presenter = presenter;
        this.manager = ManagerDB.getInstance();
    }

    @Override
    public void comprar(Usuario usuario, Producto producto, Integer cantidad) {
        //this.manager.agregarVenta(usuario, producto, cantidad);
        try{
            Venta venta = this.manager.agregarVenta(producto, cantidad);
            this.presenter.compraRealizada(venta);
        }catch (Exception e){
            // MIODO DEBUG
            this.presenter.mostrarError(e.getMessage().toString());
        }
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return this.manager.getUserById(id);
    }
}
