package com.example.nicoc.productos.Venta.ListaVentasFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.Database.Venta;
import com.example.nicoc.productos.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;


public class ListaVentasFragment extends Fragment implements IListaVentas.View{

    @BindView(R.id.listaVentas)
    ListView listaVentas;

    private IListaVentas.Presenter presenter;

    public interface OnListaVentasFragmentInteraction{
        void onVentaSeleccionadaFragment(Venta venta);
        void mostrarError(String error);
    }
    private OnListaVentasFragmentInteraction mListener;

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        this.presenter = new ListaVentasPresenter(this);
        this.getItems();
    }

    @Override
    public void mostrarError(String error) {
        mListener.mostrarError(error);
    }

    public void getItems() {
        this.presenter.getItems();
    }

    @Override
    public void setItems(List<Venta > ventas) {
        listaVentas.setAdapter(new ListaVentasAdapter(this, ventas));
    }

    @OnItemClick(R.id.listaVentas) void itemClick(int position){
        Venta venta= (Venta)listaVentas.getAdapter().getItem(position);
        this.mListener.onVentaSeleccionadaFragment(venta);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_ventas, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListaVentasFragmentInteraction) {
            mListener = (OnListaVentasFragmentInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


}
