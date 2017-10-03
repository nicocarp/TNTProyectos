package com.example.nicoc.productos.Producto.Agregar;

import com.example.nicoc.productos.Database.ManagerDB;
import com.example.nicoc.productos.Database.Producto;

/**
 * Created by nicoc on 25/09/17.
 */

public class AgregarProductoModel implements IProducto.Model{

    private IProducto.Presenter presenter;
    private ManagerDB manager;

    public AgregarProductoModel(IProducto.Presenter presenter) {
        this.presenter = presenter;
        this.manager = ManagerDB.getInstance();
    }

    @Override
    public void agregarProducto(String codigo, String nombre, String descripcion, Double precio, Integer stock, String imagen) {
        Producto producto = new Producto();
        producto.setCodigo(codigo);
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setStock(stock);
        producto.setImagen(imagen);

        try{
            this.presenter.productoAgregado(this.manager.agregarProducto(producto));
        }
        catch (Exception e){
            // mostramos el error a modo de debug no mas cambiar
            this.presenter.mostrarError(e.getMessage().toString());
        }
    }
}
