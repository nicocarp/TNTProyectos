package com.example.nicoc.productos.Producto.Listado;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.R;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by nicoc on 27/09/17.
 */

public class ListadoAdapter extends BaseAdapter  {

    private Activity activity;
    private  List<Producto> items = Collections.emptyList();
    private  List<Producto> items_all = Collections.emptyList();


    public ListadoAdapter(Activity activity, List<Producto> items){
        this.activity = activity;
        this.items = items;
        this.items_all = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.items.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = view;
        if (view == null){
            LayoutInflater inf = (LayoutInflater) this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate (R.layout.item_producto, null);
        }
        ImageView view_img_producto = (ImageView) v.findViewById(R.id.imagenProducto);
        TextView view_txt_nombre = (TextView) v.findViewById(R.id.txtNombre);
        TextView view_txt_codigo = (TextView) v.findViewById(R.id.txtCodigo);

        // cargamos los datos
        Producto p = this.items.get(position);

        // view_img_producto.setImageDrawable(p.getImagen()); ARREGLAR LO DE IMAGEN
        view_txt_codigo.setText(p.getCodigo());
        view_txt_nombre.setText(p.getNombre());

        return v;
    }

    /**
     * Setea los items que se muestran y los items_all del adaptador
     * @param items Listado de objetos Producto
     */
    public void setData(List<Producto> items){
        this.items.clear();
        this.items = items;
        this.items_all = items;
        notifyDataSetChanged();
    }

    /**
     * Setea un nuevo listado de items que se muestran, items_all permanece igual. Usado despues de filtros.
     * @param items Listados de objetos Producto
     */
    public void refreshData(List<Producto> items) {
        this.items.clear();
        this.items = items;
        notifyDataSetChanged();
    }

    /* Metodo personalizado para filtrar por nombre y codigo */
    public void filtrado(String codigo, String nombre){

        String filtro_nombre = nombre.toString().toLowerCase();
        String filtro_codigo = codigo.toString().toLowerCase();

        List<Producto> filtrado = new ArrayList<Producto>();

        for (Producto producto : this.items){

            if (producto.getNombre().toLowerCase().contains(filtro_nombre) &&
                    producto.getCodigo().toLowerCase().contains(filtro_codigo))
                filtrado.add(producto);
        }

        this.refreshData(filtrado);
    }



}
