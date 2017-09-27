package com.example.nicoc.productos.Producto.Listado;

import com.example.nicoc.productos.Database.Producto;

import java.util.List;

/**
 * Created by nicoc on 26/09/17.
 */

public interface IListado {

    interface View {
        public void getProductos();
        public void setListado(List<String> listado);

        public void sinProductos();
        public void mostrarError(String error);
    }
    interface Presenter{
        public void getProductos();
        public void listadoProductos(List<Producto> productos);
        public void mostrarError(String error);
    }
    interface Model {
        public void getProductos();
        public void getProductos(String nombre, String codigo);
    }
}
