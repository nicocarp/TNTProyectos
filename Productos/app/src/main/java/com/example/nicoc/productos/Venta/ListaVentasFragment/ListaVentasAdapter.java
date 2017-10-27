package com.example.nicoc.productos.Venta.ListaVentasFragment;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nicoc.productos.Database.ManagerFile;
import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.Database.Venta;
import com.example.nicoc.productos.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
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

        File file_image = new ManagerFile().getFileImagenByName(venta.getProducto().getImagen());
        if (file_image != null)
            view_img_producto.setImageURI(Uri.fromFile(file_image));

        // view_img_producto.setImageDrawable(p.getImagen()); ARREGLAR LO DE IMAGEN
        view_txt_fechaVenta.setText(venta.getFechaString());
        view_txt_monto.setText("$"+venta.getMonto_total().toString());

        return v;
    }

    /**
     * Setea un nuevo listado de items que se muestran, items_all permanece igual. Usado despues de filtros.
     * @param items Listados de objetos Producto
     */
    private void refreshData(List<Venta> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    /**
     * Metodo personalizado para filtrar listado de ventas por producto y fecha
     * @param codigo String (convertido a minuscula para buscar)
     * @param fecha_ini Date (buscar por fecha)
     * @param fecha_fin Date (buscar por fecha)
     */
    public void filtrado(String codigo, Date fecha_ini, Date fecha_fin){

        String filtro_codigo = codigo.toString().toLowerCase();

        List<Venta> filtrado = new ArrayList<Venta>();

        for (Venta  venta: this.items_all){
            if (
                    (
                            (venta.getFecha().compareTo(fecha_ini) >= 0) &&
                            (venta.getFecha().compareTo(fecha_fin) <= 0)
                    ) &&
                            venta.getProducto().getCodigo().toLowerCase().contains(filtro_codigo)
                    )
                filtrado.add(venta);
        }

        this.refreshData(filtrado);
    }

}
