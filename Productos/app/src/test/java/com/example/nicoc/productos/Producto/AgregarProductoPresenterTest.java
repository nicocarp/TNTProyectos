package com.example.nicoc.productos.Producto;

import com.example.nicoc.productos.Producto.Agregar.AgregarProductoPresenter;
import com.example.nicoc.productos.Producto.Agregar.IProducto;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by nicoc on 25/09/17.
 */
@RunWith(MockitoJUnitRunner.class)

public class AgregarProductoPresenterTest {

    private AgregarProductoPresenter presenter;

    @Mock
    private IProducto.View view;

    @Mock
    private IProducto.Model model;

    @Before
    public void setUp(){
        this.presenter = new AgregarProductoPresenter(view);
    }



}