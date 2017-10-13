package com.example.nicoc.productos.Venta.ListaVentasFragment;

import com.example.nicoc.productos.Database.Venta;

import java.util.List;

/**
 * Created by nicoc on 12/10/17.
 */

public interface IListaVentas {
    interface View{
        public void mostrarError(String error);
        public void getItems();
        public void setItems(List<Venta> ventas);
    }

    interface Presenter{
        public void onError(String error);
        public void getItems();
        public void onReturnItems(List<Venta> ventas);
    }

    interface Model {
        public void getVentas();
    }
}
