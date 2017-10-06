package com.example.nicoc.productos.Producto.Agregar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.nicoc.productos.Producto.Listado.ListadoView;
import com.example.nicoc.productos.R;
import com.google.common.collect.Range;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AgregarProductoView extends AppCompatActivity implements IProducto.View {

    private IProducto.Presenter presenter;

    private AwesomeValidation validator;

    @BindView(R.id.txtCodigo) EditText txtCodigo;
    @BindView(R.id.txtNombre) EditText txtNombre;
    @BindView(R.id.txtDescripcion) EditText txtDescripcion;
    @BindView(R.id.txtPrecio) EditText txtPrecio;
    @BindView(R.id.txtStock) EditText txtStock;
    @BindView(R.id.txtImagen) EditText txtImagen;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto_view);

        ButterKnife.bind(this);

        this.presenter = new AgregarProductoPresenter(this);

        this.validator = new AwesomeValidation(ValidationStyle.BASIC);

        this.inicarView();

    }

    public void inicarView(){

        // Reglas de validacion
        validator.addValidation(txtCodigo, "[a-zA-Z\\s]+", "Ingrese codigo valido");
        validator.addValidation(txtNombre, RegexTemplate.NOT_EMPTY, "Requerido");
        validator.addValidation(txtNombre, "[a-zA-Z\\s]+", "Ingrese nombre");
        validator.addValidation(txtDescripcion, RegexTemplate.NOT_EMPTY, "Ingrese descripcion");
        validator.addValidation(txtPrecio, Range.greaterThan(0.0f), "Precio mayor a 0");
        validator.addValidation(txtPrecio, RegexTemplate.NOT_EMPTY, "Precio requerido");
        validator.addValidation(txtStock, Range.greaterThan(-1), "Stock 0 o mayor");
    }

    @OnClick(R.id.btnAgregarProducto)@Override public void agregarProducto(){
        this.validator.clear();
        if (!this.validator.validate())
            return;

        String codigo = txtCodigo.getText().toString();
        String nombre = txtNombre.getText().toString();
        String descripcion = txtDescripcion.getText().toString();
        String imagen = txtImagen.getText().toString();
        Double precio = Double.valueOf(txtPrecio.getText().toString());
        Integer stock = Integer.valueOf(txtStock.getText().toString());

        this.presenter.agregarProducto(
                codigo, nombre, descripcion, precio, stock, imagen
        );
    }

    @Override
    public void mostrarError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void productoAgregado(Long id) {
        Toast.makeText(getApplicationContext(), "Producto agregado "+id, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AgregarProductoView.this, ListadoView.class);
        startActivity(intent);
    }
}
