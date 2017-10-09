package com.example.nicoc.productos.Venta.InforProductoFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class InforProductoFragment extends Fragment {


    @BindView(R.id.txtCodigo) TextView txtCodigo;
    @BindView(R.id.txtNombre) TextView txtNombre;
    @BindView(R.id.txtDescripcion) TextView txtDescripcion;
    @BindView(R.id.txtPrecio) TextView txtPrecio;
    @BindView(R.id.txtStock) TextView txtStock;
    @BindView(R.id.txtImagen) TextView txtImagen;

    private onInforProductoFragmentListener mListener;


    public interface onInforProductoFragmentListener{
        void mostrarError(String error);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_infor_producto, container, false);
        ButterKnife.bind(this, view);
        return view;
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

    public void setInfoProducto(Producto producto){
        this.txtCodigo.setText(producto.getCodigo());
        this.txtNombre.setText(producto.getNombre());
        this.txtDescripcion.setText(producto.getDescripcion());
        this.txtPrecio.setText(((Double)producto.getPrecio()).toString());
        this.txtStock.setText(((Integer) producto.getStock()).toString());
        this.txtImagen.setText(producto.getImagen());
    }

}
