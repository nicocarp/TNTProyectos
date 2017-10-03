package com.example.nicoc.productos.Producto.Detalle;

import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.R;

public class ProductoDetalle extends AppCompatActivity {

    public static final String EXTRA_REPOSITORY = "PRODUCTO";

    private TextView txtCodigo, txtNombre,  txtDescripcion, txtPrecio, txtStock, txtImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_detalle);

        this.txtCodigo = (TextView)findViewById(R.id.txtCodigo);
        this.txtNombre= (TextView)findViewById(R.id.txtNombre);
        this.txtDescripcion= (TextView)findViewById(R.id.txtDescripcion);
        this.txtPrecio= (TextView)findViewById(R.id.txtPrecio);
        this.txtStock = (TextView)findViewById(R.id.txtStock );
        this.txtImagen = (TextView)findViewById(R.id.txtImagen );

        Producto producto= getIntent().getParcelableExtra(EXTRA_REPOSITORY);

        this.iniciarView(producto);

    }

    private void iniciarView(Producto producto) {
        this.txtCodigo.setText(producto.getCodigo());
        this.txtNombre.setText(producto.getNombre());
        this.txtDescripcion.setText(producto.getDescripcion());
        this.txtPrecio.setText(((Double)producto.getPrecio()).toString());
        this.txtStock.setText(producto.getStock());
        this.txtImagen.setText(producto.getImagen());
    }
}
