package com.example.nicoc.productos.Database;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.nicoc.productos.Database.DaoMaster;

import org.greenrobot.greendao.database.Database;

import java.util.List;

public class ManagerDB extends DaoMaster.OpenHelper {

    private static DaoMaster.DevOpenHelper helper;
    private static Database db;
    private static DaoSession daoSession;

    public ManagerDB(Context context, String name){
        super(context, name);
        db = this.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession(){
        return this.daoSession;
    }

    public static long validarUsuario(String username, String password){
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
}