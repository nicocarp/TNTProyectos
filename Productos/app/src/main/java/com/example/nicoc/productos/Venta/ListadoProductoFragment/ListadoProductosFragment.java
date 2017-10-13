package com.example.nicoc.productos.Venta.ListadoProductoFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;


public class ListadoProductosFragment extends Fragment implements IListadoProductos.View {

    private IListadoProductos.Presenter presenter;

    @BindView(R.id.listProductos) ListView listProductos;

    public interface onProductoSeleccionadoListener {
        void onProductoSeleccionadoFragment(Producto uri);
    }

    private onProductoSeleccionadoListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_listado_productos, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);

        this.presenter = new ListadoProductosPresenter(this);
        this.getItems();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onProductoSeleccionadoListener) {
            mListener = (onProductoSeleccionadoListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @OnItemClick(R.id.listProductos) void itemClick(int position){
        Producto producto = (Producto)listProductos.getAdapter().getItem(position);
        this.mListener.onProductoSeleccionadoFragment(producto);
    }

    @Override
    public void getItems() {
        this.presenter.getItems();
    }

    @Override
    public void mostrarError(String error) {

    }

    @Override
    public void setItems(List<Producto> productos) {
        listProductos.setAdapter(new ListadoProductoAdapter(this, productos));
    }



}
