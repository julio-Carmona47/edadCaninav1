package es.davante.edadcanina;

import es.davante.edadcanina.modelo.EdadCaninaModelo;

public class EdadCaninaControlador {
    private final EdadCaninaModelo modelo;

    public EdadCaninaControlador(EdadCaninaModelo modelo) {
        this.modelo = modelo;
    }

    public void calcular() {
        modelo.calcular();
    }

    public void limpiar() {
        modelo.setEntrada(""); // Al borrar la entrada, el modelo ya borra el resultado y el error
    }
}