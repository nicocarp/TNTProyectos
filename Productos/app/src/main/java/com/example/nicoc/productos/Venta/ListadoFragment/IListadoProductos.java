package com.example.nicoc.productos.Venta.ListadoFragment;

import com.example.nicoc.productos.Database.Producto;

import java.util.List;

/**
 * Created by nicoc on 08/10/17.
 */

public interface IListadoProductos {

    interface View {
        public void getItems();
        public void mostrarError(String error);
        public void setItems(List<Producto> productos);
    }
    interface Presenter {
        public void getItems();
        public void setItems(List<Producto> productos);
        public void mostrarError(String error);
    }
    interface Model{
        public void getProductos();
    }
}
