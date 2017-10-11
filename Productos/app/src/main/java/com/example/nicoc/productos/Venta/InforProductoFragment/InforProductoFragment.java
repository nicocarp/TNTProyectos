package com.example.nicoc.productos.Venta.InforProductoFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.R;
import com.google.common.collect.Range;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @BindView(R.id.txtImagen) TextView txtImagen;

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
        this.producto = producto ;
        this.txtCodigo.setText(producto.getCodigo());
        this.txtNombre.setText(producto.getNombre());
        this.txtDescripcion.setText(producto.getDescripcion());
        this.txtPrecio.setText(((Double)producto.getPrecio()).toString());
        this.txtStock.setText(((Integer) producto.getStock()).toString());
        this.txtImagen.setText(producto.getImagen());
    }

}
