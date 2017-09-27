package com.example.nicoc.productos.Producto.Agregar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.nicoc.productos.R;
import com.google.common.collect.Range;

public class AgregarProductoView extends AppCompatActivity implements IProducto.View {

    private IProducto.Presenter presenter;
    private AwesomeValidation validator;

    private EditText txtCodigo, txtNombre, txtDescripcion, txtPrecio, txtStock, txtImagen;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto_view);

        this.presenter = new AgregarProductoPresenter(this);

        this.validator = new AwesomeValidation(ValidationStyle.BASIC);

        this.inicarView();

    }

    public void inicarView(){

        // Iputs
        this.txtCodigo = (EditText)findViewById(R.id.txtCodigo);
        this.txtNombre = (EditText)findViewById(R.id.txtNombre);
        this.txtDescripcion= (EditText)findViewById(R.id.txtDescripcion);
        this.txtPrecio= (EditText)findViewById(R.id.txtPrecio);
        this.txtStock= (EditText)findViewById(R.id.txtStock);
        this.txtImagen = (EditText)findViewById(R.id.txtImagen);

        // Reglas de validacion
        validator.addValidation(this.txtCodigo, "[a-zA-Z\\s]+", "Ingrese codigo valido");
        validator.addValidation(this.txtNombre, RegexTemplate.NOT_EMPTY, "Requerido");
        validator.addValidation(this.txtNombre, "[a-zA-Z\\s]+", "Ingrese nombre");
        validator.addValidation(this.txtDescripcion, RegexTemplate.NOT_EMPTY, "Ingrese descripcion");
        validator.addValidation(this.txtPrecio, Range.greaterThan(0), "Precio mayor a 0");
        validator.addValidation(this.txtPrecio, RegexTemplate.NOT_EMPTY, "Precio requerido");
        validator.addValidation(this.txtStock, Range.greaterThan(-1), "Stock 0 o mayor");
    }

    /**
     * Se ejecuta ante el evento clikc en boton btnAgregarProducto. Se valida formulario
     *  y luego se agregamos producto al repositorio.
     * @param v
     */
    public void eventoAgregarProducto(View v){
        if (!this.validator.validate())
            return;
        this.validator.clear();
        agregarProducto();
    }

    @Override
    public void mostrarError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }

    /**
     * Leemos los inputs y creamos un nuevo producto
     * Prec: los campos deben estar validados NOT_NULL excepto txtImagen
     */
    @Override
    public void agregarProducto() {
        String codigo = this.txtCodigo.getText().toString();
        String nombre = this.txtNombre.getText().toString();
        String descripcion = this.txtDescripcion.getText().toString();
        String imagen = this.txtImagen.getText().toString();
        double precio = Double.valueOf(this.txtPrecio.getText().toString());
        int stock = Integer.valueOf(this.txtStock.getText().toString());

        this.presenter.agregarProducto(
                codigo, nombre, descripcion, precio, stock, imagen
        );
    }

    @Override
    public void productoAgregado(Long id) {
        Toast.makeText(getApplicationContext(), "Producto agregado "+id, Toast.LENGTH_SHORT).show();
        // ir a otra activity o lo que sea
    }
}
