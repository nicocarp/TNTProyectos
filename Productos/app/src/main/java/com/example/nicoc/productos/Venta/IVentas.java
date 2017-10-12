package com.example.nicoc.productos.Venta;

import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.Database.Usuario;
import com.example.nicoc.productos.Database.Venta;

/**
 * Created by nicoc on 11/10/17.
 */

public interface IVentas {
    interface View{
        public void mostrarError(String error);
        public void comprar(Producto producto, Integer cantidad);
        public void onCompraRealizada(Venta venta);
    }

    interface Presenter{
        public void mostrarError(String error);
        public void comrpar(Producto producto, Integer cantidad);
        public void compraRealizada(Venta venta);
    }

    interface Model{
        public void comprar(Usuario usuario, Producto producto, Integer cantidad);
        public Usuario getUsuarioById(Long id);
    }

}
