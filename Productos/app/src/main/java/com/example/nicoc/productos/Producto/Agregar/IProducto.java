package com.example.nicoc.productos.Producto.Agregar;

/**
 * Created by nicoc on 25/09/17.
 */

public interface IProducto {

    interface View {
        public void mostrarError(String error);
        public void agregarProducto();
        public void productoAgregado(Long id);
    }

    interface Presenter {
        public void mostrarError(String error);
        public void agregarProducto(String codigo, String nombre, String descripcion,
                                    double precio, int stock, String imagen);
        public void productoAgregado(Long id_producto);
    }

    interface Model {
        public void agregarProducto(String codigo, String nombre, String descripcion,
                                    double precio, int stock, String imagen);

    }
}
