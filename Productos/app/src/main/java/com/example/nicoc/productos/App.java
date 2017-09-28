package com.example.nicoc.productos;
import android.app.Application;
import android.widget.Toast;
import com.example.nicoc.productos.Database.ManagerDB;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        try {
            // inicio base de datos.
            new ManagerDB(this, "notes-db");
            //this.deleteDatabase("notes-db");

        } catch (Exception e){
            // SIN BD SE ROMPE LA APP. sacar trucatch despues
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}