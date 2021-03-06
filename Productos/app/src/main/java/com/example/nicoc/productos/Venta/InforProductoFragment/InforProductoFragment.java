package com.example.nicoc.productos.Venta.InforProductoFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.nicoc.productos.Database.ManagerFile;
import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.R;
import com.google.common.collect.Range;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * Fragment que muestra la informacion de un producto, un input para ingresar
 *  la cantidad a comprar, y boton Comprar. Click en btnComprar pasamos Producto
 *   y cantidad a la activity contenedora.
 */
public class InforProductoFragment extends Fragment {

    @BindView(R.id.txtCodigo) TextView txtCodigo;
    @BindView(R.id.txtNombre) TextView txtNombre;
    @BindView(R.id.txtDescripcion) TextView txtDescripcion;
    @BindView(R.id.txtPrecio) TextView txtPrecio;
    @BindView(R.id.txtStock) TextView txtStock;
    @BindView(R.id.imagenProducto)ImageView imagenProducto;
    @BindView(R.id.btnComprar)Button btmComprar;
    @BindView(R.id.txtPrecioTotal)TextView txtPrecioTotal;


    private AwesomeValidation validator;
    @BindView(R.id.txtCantidad) EditText txtCantidad;

    private Producto producto = null;
    private onInforProductoFragmentListener mListener;


    public interface onInforProductoFragmentListener{
        void mostrarError(String error);
        void onClickComprar(Producto producto, Integer cantidad);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_infor_producto, container, false);
        ButterKnife.bind(this, view);
        this.validator = new AwesomeValidation(ValidationStyle.BASIC);

        this.iniciarVista();
        return view;
    }
    private void iniciarVista(){
        btmComprar.setEnabled(false);
        txtCantidad.setEnabled(false);
        txtPrecioTotal.setText("Total $0");
        validator.addValidation(txtCantidad, Range.greaterThan(0), "Cantidad mayor a 0");
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onInforProductoFragmentListener) {
            mListener = (onInforProductoFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @OnTextChanged(R.id.txtCantidad) void msotrarPrecioTotal(){
        actualizarPrecioTotal();
    }

    private void actualizarPrecioTotal(){
        if (this.producto == null || txtCantidad.getText().toString().isEmpty())
            return;
        Integer cantidad = Integer.valueOf(txtCantidad.getText().toString());
        String string_precio = String.valueOf("Total $"+cantidad * this.producto.getPrecio());
        txtPrecioTotal.setText(string_precio );
    }

    @OnClick(R.id.btnComprar) public void comprar(){
        this.validator.clear();

        if (!this.validator.validate())
            return;
        if (this.producto == null){
            mListener.mostrarError("Seleccione un producto");
            return;
        }
        Integer cantidad = Integer.valueOf(txtCantidad.getText().toString());
        mListener.onClickComprar(this.producto, cantidad);
    }

    public void setInfoProducto(Producto producto){
        if (producto == null)
            return;
        btmComprar.setEnabled(true);
        txtCantidad.setEnabled(true);
        this.producto = producto;
        actualizarPrecioTotal();
        this.txtCodigo.setText("Cod: "+ producto.getCodigo());
        this.txtNombre.setText("Nombre: "+producto.getNombre());
        this.txtDescripcion.setText("Descr: "+producto.getDescripcion());
        this.txtPrecio.setText("Precio $"+((Double)producto.getPrecio()).toString());
        this.txtStock.setText("Stock "+((Integer) producto.getStock()).toString());

        File file_image = new ManagerFile().getFileImagenByName(producto.getImagen());
        if (file_image != null)
            imagenProducto.setImageURI(Uri.fromFile(file_image));
        else
            imagenProducto.setImageDrawable(null);

    }

}
