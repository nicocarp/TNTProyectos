package com.example.nicoc.productos.Producto.Listado;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nicoc.productos.Database.ManagerDB;
import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.Producto.Detalle.ProductoDetalle;
import com.example.nicoc.productos.R;

import java.util.Collections;
import java.util.List;

public class ListadoView extends AppCompatActivity implements IListado.View{

    private IListado.Presenter presenter;
    IListado.Presenter presenter2;
    private ListView listaProductos;
    private List<Producto> items;
    private  ListadoAdapter adaptador;
    private EditText txtFiltroCodigo, txtFiltroNombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_view);

        this.presenter = new ListadoPresenter(this);

        this.txtFiltroCodigo = (EditText)findViewById(R.id.txtFiltroCodigo);
        this.txtFiltroNombre = (EditText)findViewById(R.id.txtFiltroNombre);


        this.listaProductos = (ListView)findViewById(R.id.listaProductos);

        this.items = Collections.emptyList();

        //this.items = ManagerDB.getInstance().getProductos();
        this.adaptador = new ListadoAdapter(this, this.items);

        this.listaProductos.setAdapter(this.adaptador);

        this.getItems();

        this.listaProductos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Producto producto = (Producto)listaProductos.getAdapter().getItem(position);
                presenter.lanzarProductoDetalle(producto);
            }
        });

    }



    public void filtrar(View v){
        this.adaptador.filtrado(this.txtFiltroCodigo.getText().toString(), this.txtFiltroNombre.getText().toString());
    }

    @Override
    public void getItems() {
        this.presenter.getItems();
    }

    @Override
    public void setItems(List<Producto> items) {
        this.items = items;
        this.adaptador.setData(this.items);

    }

    @Override
    public void mostrarError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void lanzarDetalleProducto(Producto producto) {
        Intent intent = new Intent(ListadoView.this, ProductoDetalle.class);
        intent.putExtra(ProductoDetalle.EXTRA_REPOSITORY, (Parcelable) producto);
        startActivity(intent);
    }


}
