package com.example.nicoc.productos.Producto.Agregar;

/**
 * Created by nicoc on 25/09/17.
 */

public class AgregarProductoPresenter implements IProducto.Presenter{

    private IProducto.View view;
    private IProducto.Model model;

    public AgregarProductoPresenter(IProducto.View view) {
        this.view = view;
        this.model = new AgregarProductoModel(this);
    }

    @Override
    public void mostrarError(String error) {
        this.view.mostrarError(error);
    }

    @Override
    public void agregarProducto(String codigo, String nombre, String descripcion, Double precio, Integer stock, String imagen) {
        this.model.agregarProducto(codigo, nombre, descripcion, precio, stock, imagen);
    }

    @Override
    public void productoAgregado(Long id_producto) {
        this.view.productoAgregado(id_producto);
    }
}
