package com.example.nicoc.productos.Database;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.nicoc.productos.Database.DaoMaster;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;

import java.sql.Date;
import java.util.List;

public class ManagerDB extends DaoMaster.OpenHelper {

    private static Database db;
    private static DaoSession daoSession;
    private static ManagerDB instance = null;


    public ManagerDB(Context context, String name){
        super(context, name);

        db = this.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
        instance = this;

        if (daoSession.getProductoDao().queryBuilder().list().isEmpty())
            this.generar_usuario();
    }

    public static ManagerDB getInstance(){

        if (instance == null)
            throw new RuntimeException("Sin conexion a con bd");
        return instance;
    }

    public DaoSession getDaoSession(){
        return this.daoSession;
    }

    public long validarUsuario(String username, String password){
        UsuarioDao usuarioDao = daoSession.getUsuarioDao();
        List<Usuario> listado = usuarioDao.queryBuilder()
                .where (UsuarioDao.Properties.Username.eq(username),
                        UsuarioDao.Properties.Password.eq(password))
                .list();
        if (listado.isEmpty())
            return -1;
        else
            return listado.get(0).getId();
    }

    public List<Producto> getProductosAll(){
        List<Producto> productos = daoSession.getProductoDao().queryBuilder().list();
        return productos;
    }

    public List<Producto> getProductosFilter(String codigo, String nombre){
        QueryBuilder query = daoSession.getProductoDao().queryBuilder();
        query.where(ProductoDao.Properties.Codigo.eq(codigo),
                    ProductoDao.Properties.Nombre.eq(nombre)
                );
        return query.list();
    }

    public List<Producto> getProductos(){
        return daoSession.getProductoDao().queryBuilder().list();
    }

    public Long agregarProducto(Producto producto){
        Long id = this.getDaoSession().getProductoDao().insert(producto);
        return id;
    }


    public void updateProducto(Producto producto){
        daoSession.getProductoDao().update(producto);
    }

    /* Meter algo de info a la bd de arranque */
    public long generar_usuario(){
        UsuarioDao usuarioDao = daoSession.getUsuarioDao();
        Usuario usuario = new Usuario();
        usuario.setUsername("nicoc");
        usuario.setNombre("Nicolas calfuquir");
        usuario.setPassword("1234");
        return usuarioDao.insert(usuario);

    }

    //public Venta agregarVenta(Usuario usuario, Producto producto, Integer cantidad)
    public Venta agregarVenta(Producto producto, Integer cantidad){
        Venta venta = new Venta();
        venta.setFecha(new java.util.Date());
        venta.setMonto_total((long) 23000);
        venta.setCantidad(cantidad);
        venta.setProducto(producto);
        daoSession.getVentaDao().insert(venta);
        return venta;
    }

    public void generar_productos_ventas(){
        ProductoDao productoDao = daoSession.getProductoDao();
        VentaDao ventaDao = daoSession.getVentaDao();
        for (int i=0; i < 5; i++){
            Producto producto = new Producto();
            producto.setNombre("Un Producto"+i);
            producto.setCodigo("Un_codigo"+i);
            producto.setDescripcion("Una descripcion");
            producto.setImagen("Una_imagen");
            producto.setPrecio(Double.valueOf(20));
            producto.setStock(0);

            Long clave = productoDao.insert(producto);

            Venta venta= new Venta();
            venta.setFecha(Date.valueOf("2017-01-01"));
            venta.setMonto_total((long) 20);
            venta.setProducto(producto);
            ventaDao.insert(venta);
        }
    }

    public Usuario getUserById(Long id){
        UsuarioDao usuarioDao = daoSession.getUsuarioDao();
        Usuario u = usuarioDao.queryBuilder().where(UsuarioDao.Properties.Id.eq(id)).unique();
        return u;
    }
}