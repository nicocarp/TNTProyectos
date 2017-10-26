package com.example.nicoc.productos.Producto.Agregar;

import com.example.nicoc.productos.Database.ManagerDB;
import com.example.nicoc.productos.Database.ManagerFile;
import com.example.nicoc.productos.Database.Producto;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by nicoc on 25/09/17.
 */

public class AgregarProductoModel implements IProducto.Model{

    private final static String BASE_PATH = "imagenes";
    private final static String EXT_IMAGEN = ".jpg";

    private IProducto.Presenter presenter;
    private ManagerDB manager;
    private ManagerFile managerFile;

    public AgregarProductoModel(IProducto.Presenter presenter) {
        this.presenter = presenter;
        this.manager = ManagerDB.getInstance();
        this.managerFile = ManagerFile.getInstance();
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

    @Override
    public void guardarImagen(Bitmap bitmap, String nombre) {
        try {
            this.managerFile.guardarImagen(bitmap, nombre);
            this.presenter.mostrarError("Imagen guardada");
        } catch (FileNotFoundException e) {
            // debug borrar despues
            this.presenter.mostrarError(e.getMessage().toString());
        }

    }

}
