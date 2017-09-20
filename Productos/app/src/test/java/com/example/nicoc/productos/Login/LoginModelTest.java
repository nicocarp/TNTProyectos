package com.example.nicoc.productos.Login;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Created by nicoc on 19/09/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginModelTest {
    @Mock
    private LoginInterface.Presenter presenter;

    private LoginModel model;

    @Before
    public void setUp(){
        model = new LoginModel(presenter);
    }

    @Test
    public void testUsuarioValido(){
        model.validarUsuario("nicoc", "1234");
        verify(presenter).usuarioValido();
    }
    @Test
    public void testUsuarioInvalido(){
        model.validarUsuario("nicoc2", "12342");
        verify(presenter).mostrarError("Datos ingresados incorrectos");
    }
    @Test
    public void testUsuarioVacio(){
        model.validarUsuario("", "");
        verify(presenter).mostrarError("Datos ingresados incorrectos");
    }


}