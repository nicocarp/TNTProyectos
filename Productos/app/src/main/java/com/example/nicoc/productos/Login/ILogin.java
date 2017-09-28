package com.example.nicoc.productos.Login;

import com.example.nicoc.productos.Database.ManagerDB;

/**
 * Created by nicoc on 19/09/17.
 */

public interface ILogin {

    interface View {
        public void validarUsuario();
        public void usuarioValido(Long id_usuario);
        public void mostrarError(String error);
    }

    interface Presenter {
        public void validarUsuario(String username, String password);
        public void usuarioValido(Long id_usuario);
        public void mostrarError(String error);
    }

    interface Model {
        public void validarUsuario(String username, String password);
    }
}
