package com.example.nicoc.productos.Producto.Listado;

import com.example.nicoc.productos.Database.Producto;

import java.util.List;

/**
 * Created by nicoc on 26/09/17.
 */

public interface IListado {

    interface View {
        public void getItems();
        public void setItems(List<Producto> items);
        public void mostrarError(String error);
        public void lanzarDetalleProducto(Producto producto);
    }
    interface Presenter{
        public void getItems();
        public void mostrarError(String error);
        public void setItems(List<Producto> items);
        public void lanzarProductoDetalle(Producto producto);
    }
    interface Model {
        public void getProductos();
        public void getProductos(String nombre, String codigo);
    }
}
