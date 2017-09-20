package com.example.nicoc.productos.Login;

/**
 * Created by nicoc on 19/09/17.
 */

public class LoginPresenter implements LoginInterface.Presenter {

    private LoginInterface.View view;
    private LoginInterface.Model model;

    public LoginPresenter(LoginInterface.View view) {
        this.view = view;
        this.model = new LoginModel(this);
    }

    @Override
    public void validarUsuario(String username, String password) {
        this.model.validarUsuario(username, password);
    }

    @Override
    public void usuarioValido() {
        this.view.usuarioValido();
    }

    @Override
    public void mostrarError(String error) {
        this.view.mostrarError(error);
    }
}
