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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;
import butterknife.OnItemSelected;

public class ListadoView extends AppCompatActivity implements IListado.View{

    private IListado.Presenter presenter;

    @BindView(R.id.listaProductos) ListView listaProductos;
    @BindView(R.id.txtFiltroCodigo) EditText txtFiltroCodigo;
    @BindView(R.id.txtFiltroNombre) EditText txtFiltroNombre;

    private List<Producto> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_view);

        ButterKnife.bind(this);

        this.presenter = new ListadoPresenter(this);

        //this.iniciarVista();

    }

    private void iniciarVista(){
        this.getItems();
    }

    @OnClick(R.id.btnFiltrar)
    public void filtrar(){
        ListadoAdapter adapter = (ListadoAdapter)this.listaProductos.getAdapter();
        adapter.filtrado(this.txtFiltroCodigo.getText().toString(), this.txtFiltroNombre.getText().toString());
    }

    @OnItemClick(R.id.listaProductos) void itemClick(int position){
        Producto producto = (Producto)listaProductos.getAdapter().getItem(position);
        presenter.lanzarProductoDetalle(producto);
    }

    @Override
    public void getItems() {
        this.presenter.getItems();
    }

    @Override
    public void setItems(List<Producto> items) {
        listaProductos.setAdapter(new ListadoAdapter(this, items));
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
