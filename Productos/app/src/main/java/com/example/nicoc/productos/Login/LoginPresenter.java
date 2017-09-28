package com.example.nicoc.productos.Login;

/**
 * Created by nicoc on 19/09/17.
 */

public class LoginPresenter implements ILogin.Presenter {

    private ILogin.View view;
    private ILogin.Model model;

    public LoginPresenter(ILogin.View view) {
        this.view = view;
        this.model = new LoginModel(this);
    }

    @Override
    public void validarUsuario(String username, String password) {
        this.model.validarUsuario(username, password);
    }

    @Override
    public void usuarioValido(Long id_usuario) {
        this.view.usuarioValido(id_usuario);
    }

    @Override
    public void mostrarError(String error) {
        this.view.mostrarError(error);
    }
}
