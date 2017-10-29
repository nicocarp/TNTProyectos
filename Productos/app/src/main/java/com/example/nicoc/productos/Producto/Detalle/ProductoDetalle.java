package com.example.nicoc.productos.Producto.Detalle;

import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nicoc.productos.Database.ManagerFile;
import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.R;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductoDetalle extends AppCompatActivity {

    public static final String EXTRA_REPOSITORY = "PRODUCTO";

    private TextView txtCodigo, txtNombre,  txtDescripcion, txtPrecio, txtStock, txtImagen;
    @BindView(R.id.imagenProducto) ImageView imagenProducto;
    Producto producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_detalle);

        ButterKnife.bind(this);
        this.txtCodigo = (TextView)findViewById(R.id.txtCodigo);
        this.txtNombre= (TextView)findViewById(R.id.txtNombre);
        this.txtDescripcion= (TextView)findViewById(R.id.txtDescripcion);
        this.txtPrecio= (TextView)findViewById(R.id.txtPrecio);
        this.txtStock = (TextView)findViewById(R.id.txtStock );
        this.txtImagen = (TextView)findViewById(R.id.txtImagen );

        this.producto= getIntent().getParcelableExtra(EXTRA_REPOSITORY);

        this.iniciarView();
    }

    private void iniciarView() {
        File file_image = new ManagerFile().getFileImagenByName(producto.getImagen());
        if (file_image != null)
            imagenProducto.setImageURI(Uri.fromFile(file_image));
        this.txtCodigo.setText(producto.getCodigo());
        this.txtNombre.setText(producto.getNombre());
        this.txtDescripcion.setText(producto.getDescripcion());
        this.txtPrecio.setText(((Double)producto.getPrecio()).toString());
        this.txtStock.setText(((Integer) producto.getStock()).toString());
        this.txtImagen.setText(producto.getImagen());


    }
}
