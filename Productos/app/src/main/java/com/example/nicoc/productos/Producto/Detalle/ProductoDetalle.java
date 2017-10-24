package com.example.nicoc.productos.Producto.Detalle;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.R;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductoDetalle extends AppCompatActivity {

    public static final String EXTRA_REPOSITORY = "PRODUCTO";

    private TextView txtCodigo, txtNombre,  txtDescripcion, txtPrecio, txtStock, txtImagen;
    @BindView(R.id.imagenProducto) ImageView imagenProducto;

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


        Producto producto= getIntent().getParcelableExtra(EXTRA_REPOSITORY);

        this.iniciarView(producto);

    }

    private void setImagen(Producto producto){
        File file_base = android.os.Environment.getExternalStorageDirectory();
        file_base =  new File(file_base, "imagenes");
        if (producto.getImagen() != null){
            File imgFile = new  File(file_base.getAbsolutePath()+File.separator+producto.getImagen() +".jpg");
            if(imgFile.exists())
            {

                imagenProducto.setImageURI(Uri.fromFile(imgFile));
                Toast.makeText(getApplicationContext(), "imagen cargada", Toast.LENGTH_SHORT).show();


            }
        }

    }

    private void iniciarView(Producto producto) {
        this.setImagen(producto);
        this.txtCodigo.setText(producto.getCodigo());
        this.txtNombre.setText(producto.getNombre());
        this.txtDescripcion.setText(producto.getDescripcion());
        this.txtPrecio.setText(((Double)producto.getPrecio()).toString());
        this.txtStock.setText(((Integer) producto.getStock()).toString());
        this.txtImagen.setText(producto.getImagen());
    }

}
