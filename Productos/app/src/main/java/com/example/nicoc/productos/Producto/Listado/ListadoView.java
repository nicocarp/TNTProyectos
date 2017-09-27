package com.example.nicoc.productos.Producto.Listado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nicoc.productos.Database.ManagerDB;
import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListadoView extends AppCompatActivity implements IListado.View{

    private ListView listaProductos;
    private IListado.Presenter presenter;
    private ArrayAdapter<String> adaptador;
    private List<Producto> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_view);

        this.presenter = new ListadoPresenter(this);

        this.listaProductos = (ListView)findViewById(R.id.listaProductos);
        this.items =  Collections.emptyList();

        this.items = ManagerDB.getManagerDBInstance().getProductos();
        //this.getProductos();

        ListadoAdapter adapter = new ListadoAdapter(this, this.items);

        this.listaProductos.setAdapter(adapter);

    }

    @Override
    public void getProductos() {
        this.presenter.getProductos();
    }

    @Override
    public void setListado(List<String> listado) {

        //this.adaptador.notifyDataSetChanged();
    }

    @Override
    public void sinProductos() {
        Toast.makeText(getApplicationContext(), "No hay productos para mostrar", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }
}
