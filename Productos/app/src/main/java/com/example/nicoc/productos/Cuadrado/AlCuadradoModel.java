package com.example.nicoc.productos.Cuadrado;

/**
 * Created by nicoc on 17/09/17.
 */

public class AlCuadradoModel implements AlCuadrado.Model {

    private AlCuadrado.Presenter presenter;
    private Double resultado;


    public AlCuadradoModel(AlCuadrado.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void calcularAlCuadrado(String valor) {
        //presenter.mostrarError("Mostrnado un error");
        if (valor.equals(""))
            presenter.mostrarError("Mostrnado un error");
        Double valor_casteado = Double.valueOf(valor);
        resultado = valor_casteado * valor_casteado ;
        presenter.mostrarResultado(resultado);
    }


}
