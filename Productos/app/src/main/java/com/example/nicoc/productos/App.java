package com.example.nicoc.productos;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.example.nicoc.productos.Database.DaoMaster;
import com.example.nicoc.productos.Database.DaoSession;
import com.example.nicoc.productos.Database.ManagerDB;

import org.greenrobot.greendao.database.Database;

public class App extends Application {
    /** A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher. */
    public static final boolean ENCRYPTED = false;

    private ManagerDB managerDB;
    @Override
    public void onCreate() {
        super.onCreate();

        try {
            //DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
            //Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
            //this.daoSession = new DaoMaster(db).newSession();
            this.managerDB = new ManagerDB(this, "notes-db");
            //this.deleteDatabase("notes-db");
            //this.managerDB.generar_usuario();
            //this.managerDB.generar_productos_ventas();


        } catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    //public DaoSession getDaoSession() {return this.daoSession;    }
    public ManagerDB getManagerDB() {
        return this.managerDB;
    }



}