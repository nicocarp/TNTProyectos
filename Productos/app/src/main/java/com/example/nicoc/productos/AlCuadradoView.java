package com.example.nicoc.productos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AlCuadradoView extends AppCompatActivity implements AlCuadrado.View{

    private TextView lblResultado;
    private EditText txtValor;
    /*Los eventos no los maneja la actividad !!! */
    //private Button btnCalcular;
    private AlCuadrado.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblResultado = (TextView)findViewById(R.id.lblResultado);
        txtValor= (EditText) findViewById(R.id.txtValor);
        presenter = new AlCuadradoPresenter(this);
    }

    @Override
    public void mostrarResultado(String resultado) {
        lblResultado.setText(resultado);
    }

    public void calcular(View view) {
        presenter.calcularAlCuadrado(txtValor.getText().toString());
        //lblResultado.setText(txtValor.getText().toString());
    }
}
