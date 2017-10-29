package com.example.nicoc.productos.Producto.Listado;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.Producto.Agregar.AgregarProductoView;
import com.example.nicoc.productos.Producto.Detalle.ProductoDetalle;
import com.example.nicoc.productos.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;
import butterknife.OnTextChanged;

public class ListadoView extends AppCompatActivity implements IListado.View {

    private IListado.Presenter presenter;

    @BindView(R.id.listaProductos)
    ListView listaProductos;
    @BindView(R.id.txtFiltroCodigo)
    EditText txtFiltroCodigo;
    @BindView(R.id.txtFiltroNombre)
    EditText txtFiltroNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_view);

        ButterKnife.bind(this);

        this.presenter = new ListadoPresenter(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        this.getItems();
    }

    @OnTextChanged(R.id.txtFiltroCodigo)void onFiltroCodigo(){
        filtrar();
    }
    @OnTextChanged(R.id.txtFiltroNombre)void onFiltroNombre(){
        filtrar();
    }

    private void filtrar(){
        ListadoAdapter adapter = (ListadoAdapter)this.listaProductos.getAdapter();
        adapter.filtrado(this.txtFiltroCodigo.getText().toString(), this.txtFiltroNombre.getText().toString());
    }

    @OnClick(R.id.btnNuevoProducto) void lanzarAgregarProducto(){
        Intent intent = new Intent(ListadoView.this, AgregarProductoView.class);
        startActivity(intent);
    }

    @OnItemClick(R.id.listaProductos) void itemClick(int position){
        Producto producto = (Producto)listaProductos.getAdapter().getItem(position);
        presenter.lanzarProductoDetalle(producto);
    }

    @OnItemLongClick(R.id.listaProductos) boolean itemLongClick(int position){
        final EditText txtNuevoStock = new EditText(this);
        txtNuevoStock.setInputType(InputType.TYPE_CLASS_NUMBER);
        final Producto p = (Producto)listaProductos.getAdapter().getItem(position);
        new AlertDialog.Builder(this)
                .setTitle("Actualizacion de stock")
                .setMessage("Ingrese nuevo stock")
                .setView(txtNuevoStock)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Integer stock =Integer.valueOf(txtNuevoStock.getText().toString());
                        actualizarStock(p, stock);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.dismiss();
                    }
                })
                .show();
        return true;
    }
    private void actualizarStock(Producto p , Integer cantidad){
        this.presenter.actualizarStock(p, cantidad);
        this.getItems();

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
        intent.putExtra(ProductoDetalle.EXTRA_REPOSITORY, producto);
        startActivity(intent);
    }


}
