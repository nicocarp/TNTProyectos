package com.example.nicoc.productos;

/**
 * Created by nicoc on 17/09/17.
 */

public interface AlCuadrado {

    interface View {
        void mostrarResultado(String resultado);

    }

    interface Presenter{
        void calcularAlCuadrado(String valor);
        void mostrarResultado(Double resultado);
        void mostrarError(String error);
    }

    interface Model {
        void calcularAlCuadrado(String valor);
    }


}
