package com.example.nicoc.productos.Login;

/**
 * Created by nicoc on 19/09/17.
 */

public class LoginModel implements LoginInterface.Model{
    private LoginInterface.Presenter presenter;

    public LoginModel(LoginInterface.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void validarUsuario(String username, String password) {
        String error = "";
        if (username.equals("") || password.equals(""))
            error = "Campos vacios";
        //  aca debemos buscar  datos en bd o en algun lugar.
        if (!username.equals("nicoc") || !password.equals("1234"))
            error = "Datos ingresados incorrectos";
        if (error.equals(""))
            presenter.usuarioValido();
        else
            presenter.mostrarError(error);

    }
}
