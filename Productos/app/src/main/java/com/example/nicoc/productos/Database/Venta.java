package com.example.nicoc.productos.Database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by nicoc on 23/09/17.
 */

@Entity
public class Venta {
    @Id(autoincrement=true) private Long id;
    @NotNull private Date fecha;
    @NotNull private Integer cantidad;
    @NotNull private Double monto_total;

    @NotNull private Long producto_id;
    @ToOne(joinProperty = "producto_id") private Producto producto;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1340327861)
    private transient VentaDao myDao;
    
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getFecha() {
        return this.fecha;
    }
    public String getFechaString(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy/mm/ss");
        String date = format.format(this.getFecha());
        return date;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getMonto_total() {
        return this.monto_total;
    }
    public void setMonto_total(Double monto_total) {
        this.monto_total = monto_total;
    }
    public Long getProducto_id() {
        return this.producto_id;
    }
    public void setProducto_id(Long producto_id) {
        this.producto_id = producto_id;
    }
    @Generated(hash = 1163473062)
    private transient Long producto__resolvedKey;

    @Generated(hash = 243011124)
    public Venta(Long id, @NotNull Date fecha, @NotNull Integer cantidad, @NotNull Double monto_total,
            @NotNull Long producto_id) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.monto_total = monto_total;
        this.producto_id = producto_id;
    }
    @Generated(hash = 597866144)
    public Venta() {
    }
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1017687825)
    public Producto getProducto() {
        Long __key = this.producto_id;
        if (producto__resolvedKey == null || !producto__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ProductoDao targetDao = daoSession.getProductoDao();
            Producto productoNew = targetDao.load(__key);
            synchronized (this) {
                producto = productoNew;
                producto__resolvedKey = __key;
            }
        }
        return producto;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 278688721)
    public void setProducto(@NotNull Producto producto) {
        if (producto == null) {
            throw new DaoException(
                    "To-one property 'producto_id' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.producto = producto;
            producto_id = producto.getId();
            producto__resolvedKey = producto_id;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 475728722)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getVentaDao() : null;
    }

}
