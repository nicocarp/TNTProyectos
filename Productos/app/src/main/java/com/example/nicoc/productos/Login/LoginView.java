package com.example.nicoc.productos.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginView extends AppCompatActivity implements ILogin.View {

    @BindView(R.id.txtPassword) EditText txtPassword;
    @BindView(R.id.txtUsername) EditText txtUsername;

    private ILogin.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);

        ButterKnife.bind(this);

        this.presenter = new LoginPresenter(this);

        txtPassword.setText("1234");
        txtUsername.setText("nicoc");
    }

    @OnClick(R.id.btnLogin)
    public void login(){
        validarUsuario();
    }

    @Override
    public void validarUsuario() {
        String u = txtUsername.getText().toString();
        String p = txtPassword.getText().toString();
        presenter.validarUsuario(u, p);
    }

    @Override
    public void usuarioValido(Long id_usuario) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(MainActivity.USER_ID, String.valueOf(id_usuario));
        edit.commit();

        startActivity(new Intent(LoginView.this, MainActivity.class));
    }

    @Override
    public void mostrarError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }



}
