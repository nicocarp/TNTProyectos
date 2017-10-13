package com.example.nicoc.productos.Venta.ListaVentasFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nicoc.productos.Database.Venta;
import com.example.nicoc.productos.R;

import java.util.List;

/**
 * Created by nicoc on 12/10/17.
 */

public class ListaVentasAdapter extends BaseAdapter{

    private Context context;
    private List<Venta> items;
    private List<Venta> items_all;

    public ListaVentasAdapter(ListaVentasFragment fragment, List<Venta> items){
        this.context = fragment.getActivity();
        this.items_all = items;
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
            LayoutInflater inf = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate (R.layout.item_venta, null);
        }
        ImageView view_img_producto = (ImageView) v.findViewById(R.id.imagenProducto);
        TextView view_txt_fechaVenta= (TextView) v.findViewById(R.id.txtFechaVenta);
        TextView view_txt_monto= (TextView) v.findViewById(R.id.txtMonto);

        // cargamos los datos
        Venta venta = this.items.get(position);

        // view_img_producto.setImageDrawable(p.getImagen()); ARREGLAR LO DE IMAGEN
        view_txt_fechaVenta.setText(venta.getFecha().toString());
        view_txt_monto.setText("$"+venta.getMonto_total().toString());

        return v;
    }

}
