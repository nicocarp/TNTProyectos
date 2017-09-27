package com.example.nicoc.productos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.nicoc.productos.Database.DaoSession;
import com.example.nicoc.productos.Database.UsuarioDao;
import com.example.nicoc.productos.Producto.Agregar.AgregarProductoView;
import com.example.nicoc.productos.Producto.Listado.ListadoView;


public class MainActivity extends AppCompatActivity {

    private UsuarioDao usuarioDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaoSession daoSession = ((App) getApplication()).getManagerDB().getDaoSession();
        //List<Producto> productos = daoSession.getProductoDao().queryBuilder().list();
        //List<Venta> ventas= daoSession.getVentaDao().queryBuilder().list();
        //((App) getApplication()).getManagerDB().generar_usuario();
        //((App) getApplication()).getManagerDB().generar_productos_ventas();
        // get the note DAO
        /*<DaoSession daoSession = ((App) getApplication()).getDaoSession();
        usuarioDao = daoSession.getUsuarioDao();
        Usuario usuario = new Usuario();
        usuario.setUsername("nicoc 2");
        usuario.setNombre("Nicolas calfuquir 2");
        usuario.setPassword("1234");
        //usuario.setId(null);
        long insertado = 0;
        try{
            insertado = usuarioDao.insert(usuario);
        } catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        List<Usuario> usuarios = usuarioDao.queryBuilder().list();*/
        //Log.d("DaoExample", "Inserted new note, ID: " + usuario.getId());

    }

    public void agregarProducto(View v){
        startActivity(new Intent(MainActivity.this, AgregarProductoView.class));
    }
    public void listadoProductos(View v){
        startActivity(new Intent(MainActivity.this, ListadoView.class));
    }
}
