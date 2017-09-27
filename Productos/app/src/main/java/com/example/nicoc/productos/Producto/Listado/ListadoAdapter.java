package com.example.nicoc.productos.Producto.Listado;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by nicoc on 27/09/17.
 */

public class ListadoAdapter extends BaseAdapter {

    private Activity activity;
    private List<Producto> items;

    public ListadoAdapter(Activity activity, List<Producto> items){
        this.activity = activity;
        this.items = items;
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
}
