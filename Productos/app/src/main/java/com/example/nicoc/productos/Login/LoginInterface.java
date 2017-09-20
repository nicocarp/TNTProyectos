package com.example.nicoc.productos.Login;

/**
 * Created by nicoc on 19/09/17.
 */

public interface LoginInterface {

    interface View {
        public void validarUsuario();
        public void usuarioValido();
        public void mostrarError(String error);
    }

    interface Presenter {
        public void validarUsuario(String username, String password);
        public void usuarioValido();
        public void mostrarError(String error);
    }

    interface Model {
        public void validarUsuario(String username, String password);
    }
}
