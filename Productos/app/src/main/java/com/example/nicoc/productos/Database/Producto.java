package com.example.nicoc.productos.Database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

import java.text.DecimalFormat;

/**
 * Created by nicoc on 23/09/17.
 */
@Entity
public class Producto {
    @Id(autoincrement=true) private Long id;
    @NotNull@Unique private String codigo;
    @NotNull private String nombre;
    @NotNull private String descripcion;
    @NotNull private double precio;
    @NotNull private int stock;
    private String imagen;
    @Generated(hash = 1754718403)
    public Producto(Long id, @NotNull String codigo, @NotNull String nombre,
            @NotNull String descripcion, double precio, int stock, String imagen) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.imagen = imagen;
    }
    @Generated(hash = 549390722)
    public Producto() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCodigo() {
        return this.codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPrecio() {
        return this.precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        if ((this.stock - stock) < 0)
            return; // LANZAR EXCEPCION
        this.stock = stock;
    }
    public String getImagen() {
        return this.imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
