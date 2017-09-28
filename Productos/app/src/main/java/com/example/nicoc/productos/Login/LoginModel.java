package com.example.nicoc.productos.Login;

import com.example.nicoc.productos.Database.ManagerDB;


/**
 * Created by nicoc on 19/09/17.
 */

public class LoginModel implements ILogin.Model{
    private ILogin.Presenter presenter;

    public LoginModel(ILogin.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void validarUsuario(String username, String password) {
        String error = "";
        Long id_user = ManagerDB.getInstance().validarUsuario(username, password);
        if (id_user == -1)
            presenter.mostrarError("Datos ingresados incorrectos");
        else
            presenter.usuarioValido(id_user);
    }
}
