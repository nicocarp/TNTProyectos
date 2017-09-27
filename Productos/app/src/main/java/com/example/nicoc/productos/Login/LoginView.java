package com.example.nicoc.productos.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nicoc.productos.App;
import com.example.nicoc.productos.Database.DaoSession;
import com.example.nicoc.productos.Database.ManagerDB;
import com.example.nicoc.productos.MainActivity;
import com.example.nicoc.productos.R;

public class LoginView extends AppCompatActivity implements ILogin.View {

    private EditText txtUsername;
    private EditText txtPassword;
    private ILogin.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        txtUsername = (EditText)findViewById(R.id.txtUsername);
        this.presenter = new LoginPresenter(this);
    }

    public void login(View view){
        validarUsuario();
    }

    @Override
    public void validarUsuario() {
        String u = txtUsername.getText().toString();
        String p = txtPassword.getText().toString();
        presenter.validarUsuario(u, p);
    }

    @Override
    public void usuarioValido() {

        startActivity(new Intent(LoginView.this, MainActivity.class));
    }

    @Override
    public void mostrarError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public ManagerDB getManagerDB() {
        return ((App)getApplication()).getManagerDB();
    }


}
