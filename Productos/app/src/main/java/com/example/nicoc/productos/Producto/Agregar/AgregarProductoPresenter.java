package com.example.nicoc.productos.Producto.Agregar;

import android.graphics.Bitmap;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public void agregarProducto(String codigo, String nombre, String descripcion, Double precio, Integer stock, Bitmap bitmap_imagen) {
        String nombre_imagen = null;
        if (bitmap_imagen != null){
            SimpleDateFormat format = new SimpleDateFormat("yyyymmsshhmmss");
            String date = format.format(new Date());
            nombre_imagen = "img" + date;
            this.model.guardarImagen(bitmap_imagen, nombre_imagen);
        }
        this.model.agregarProducto(codigo, nombre, descripcion, precio, stock, nombre_imagen);
    }


    @Override
    public void productoAgregado(Long id_producto) {
        this.view.productoAgregado(id_producto);
    }
}
