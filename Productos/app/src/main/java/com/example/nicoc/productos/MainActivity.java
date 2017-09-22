package com.example.nicoc.productos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.nicoc.productos.Database.DaoSession;
import com.example.nicoc.productos.Database.Usuario;
import com.example.nicoc.productos.Database.UsuarioDao;

import java.util.List;



public class MainActivity extends AppCompatActivity {

    private UsuarioDao usuarioDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the note DAO
        /*DaoSession daoSession = ((App) getApplication()).getDaoSession();
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
        Toast.makeText(this, "usuario creado ", Toast.LENGTH_SHORT).show();
    }
}
