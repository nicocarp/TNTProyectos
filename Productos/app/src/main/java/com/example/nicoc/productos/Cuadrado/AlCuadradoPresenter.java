package com.example.nicoc.productos.Cuadrado;

/**
 * Created by nicoc on 17/09/17.
 */

public class AlCuadradoPresenter implements AlCuadrado.Presenter{

    private AlCuadrado.View view;
    private AlCuadrado.Model model;

    public AlCuadradoPresenter(AlCuadrado.View view){
        this.view = view;
        model = new AlCuadradoModel(this);
    }

    @Override
    public void calcularAlCuadrado(String valor) {
        model.calcularAlCuadrado(valor);
    }

    @Override
    public void mostrarResultado(Double resultado) {
        view.mostrarResultado(resultado.toString());
    }

    @Override
    public void mostrarError(String error) {
        view.mostrarResultado(error);
    }
}
