package com.example.nicoc.productos.Venta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.nicoc.productos.Database.Producto;
import com.example.nicoc.productos.Database.Venta;
import com.example.nicoc.productos.MainActivity;
import com.example.nicoc.productos.R;
import com.example.nicoc.productos.Venta.InforProductoFragment.InforProductoFragment;
import com.example.nicoc.productos.Venta.ListadoFragment.ListadoProductosFragment;

/**
 * Esta activity contiene dos fragments: uno que muestra el listado de productos y otro
 * que muestra la informacion de los productos que se clickean en la primera lista
 */
public class VentasView extends AppCompatActivity
        implements ListadoProductosFragment.onProductoSeleccionadoListener,
        InforProductoFragment.onInforProductoFragmentListener,
        IVentas.View
{

    IVentas.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_ventas);
        this.presenter = new VentasPresenter(this);
    }

    @Override
    public void onProductoSeleccionadoFragment(Producto producto) {
        InforProductoFragment frag = ((InforProductoFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentInfoProducto));
        frag.setInfoProducto(producto);
    }

    @Override
    public void mostrarError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClickComprar(Producto producto, Integer cantidad) {
        this.comprar(producto, cantidad);
    }

    @Override
    public void comprar(Producto producto, Integer cantidad) {
        this.presenter.comrpar(producto, cantidad);
    }

    @Override
    public void onCompraRealizada(Venta venta) {
        String mje = "Compra relizada: "+ venta.getId() +
                    " Producto "+ venta.getProducto().getNombre()  +
                    " Cantidad "+venta.getCantidad();
        Toast.makeText(getApplicationContext(), mje, Toast.LENGTH_LONG).show();
        this.lanzarMainActivity();
    }

    public void lanzarMainActivity(){
        startActivity(new Intent(VentasView.this, MainActivity.class));
    }
}
