package com.example.nicoc.productos.Venta.ListaVentasFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.Database.Venta;
import com.example.nicoc.productos.Producto.Listado.ListadoAdapter;
import com.example.nicoc.productos.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnTextChanged;


public class ListaVentasFragment extends Fragment implements IListaVentas.View{

    @BindView(R.id.listaVentas)ListView listaVentas;
    @BindView(R.id.txtFiltroCodigo)EditText txtFiltroCodigo;
    @BindView(R.id.txtFiltroFechaIni)EditText txtFiltroFechaIni;
    @BindView(R.id.txtFiltroFechaFin)EditText txtFiltroFechaFin;



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

    @OnTextChanged(R.id.txtFiltroCodigo)void filtroCodigo(){
        filtrado();
    }
    @OnTextChanged(R.id.txtFiltroFechaIni)void filtroFechaIni(){
        filtrado();
    }
    @OnTextChanged(R.id.txtFiltroFechaFin)void filtroFechaFin(){
        filtrado();
    }

    private void filtrado(){

        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date fecha_ini = format.parse(txtFiltroFechaIni.getText().toString());
            Date fecha_fin = format.parse(txtFiltroFechaFin.getText().toString());
            String c = txtFiltroCodigo.getText().toString();

            ListaVentasAdapter adapter = (ListaVentasAdapter)this.listaVentas.getAdapter();
            adapter.filtrado(c,fecha_ini, fecha_fin);
        } catch (ParseException e) {
            mostrarError(e.getMessage());
            e.printStackTrace();
        }

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
