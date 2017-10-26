package com.example.nicoc.productos.Database;

import android.os.Parcel;
import android.os.Parcelable;

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
public class Producto implements Parcelable{
    @Id(autoincrement=true) private Long id;
    @NotNull@Unique private String codigo;
    @NotNull private String nombre;
    @NotNull private String descripcion;
    @NotNull private Double precio;
    @NotNull private Integer stock;
    private String imagen;
    @Generated(hash = 732148805)
    public Producto(Long id, @NotNull String codigo, @NotNull String nombre,
            @NotNull String descripcion, @NotNull Double precio,
            @NotNull Integer stock, String imagen) {
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

    protected Producto(Parcel in) {
        codigo = in.readString();
        nombre = in.readString();
        descripcion = in.readString();
        precio = in.readDouble();
        stock = in.readInt();
        imagen = in.readString();
    }

    public static final Creator<Producto> CREATOR = new Creator<Producto>() {
        @Override
        public Producto createFromParcel(Parcel in) {
            return new Producto(in);
        }

        @Override
        public Producto[] newArray(int size) {
            return new Producto[size];
        }
    };

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
    public Double getPrecio() {
        return this.precio;
    }

    public Integer getStock() {
        return this.stock;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public void setStock(Integer stock)  {
        this.stock = stock;
    }
    public String getImagen() {
        return this.imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(codigo);
        parcel.writeString(nombre);
        parcel.writeString(descripcion);
        parcel.writeDouble(precio);
        parcel.writeInt(stock);
        parcel.writeString(imagen);
    }

}
