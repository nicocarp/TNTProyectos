package com.example.nicoc.productos.Login;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Created by nicoc on 20/09/17.
 */
@RunWith(MockitoJUnitRunner.class)

public class LoginPresenterTest {

    private LoginPresenter presenter;

    @Mock
    private LoginInterface.View view;

    @Mock
    private LoginInterface.Model model;

    @Before
    public void setUp(){
        this.presenter = new LoginPresenter(view);
    }

    @Test
    public void testUsuarioValido(){
        presenter.validarUsuario("nicoc", "1234");
        verify(view).usuarioValido();
    }
    @Test
    public void testUsuarioNoValido(){
        presenter.validarUsuario("alguno", "invalido");
        verify(view).mostrarError("Datos ingresados incorrectos");
    }
}