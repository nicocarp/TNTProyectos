package com.example.nicoc.productos.Login;

import com.example.nicoc.productos.App;
import com.example.nicoc.productos.Database.DaoSession;
import com.example.nicoc.productos.Database.ManagerDB;
import com.example.nicoc.productos.Database.Usuario;
import com.example.nicoc.productos.Database.UsuarioDao;

import java.util.List;


/**
 * Created by nicoc on 19/09/17.
 */

public class LoginModel implements ILogin.Model{
    private ILogin.Presenter presenter;

    public LoginModel(ILogin.Presenter presenter) {
        this.presenter = presenter
    }

    @Override
    public void validarUsuario(String username, String password) {
        String error = "";
        long id_user = ManagerDB.validarUsuario(username, password);
        if (id_user == -1)
            presenter.mostrarError("Datos ingresados incorrectos");
        else
            presenter.usuarioValido();
    }
}
