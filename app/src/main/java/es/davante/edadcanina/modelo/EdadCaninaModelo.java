package es.davante.edadcanina.modelo;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import es.davante.edadcanina.BR;

public class EdadCaninaModelo extends BaseObservable {

    public static final int FACTOR_CANINO = 7;
    public static final int EDAD_MINIMA = 1;
    public static final int EDAD_MAXIMA = 30;

    private String entrada = "";
    private String resultado = "";
    private Validacion validacion = null;

    @Bindable
    public String getEntrada() { return entrada; }

    public void setEntrada(String entrada) {
        if (this.entrada != null && !this.entrada.equals(entrada)) {
            this.entrada = entrada;
            notifyPropertyChanged(BR.entrada);
            setResultado("");
            setValidacion(null); // Limpiamos el error al escribir
        }
    }

    @Bindable
    public String getResultado() { return resultado; }

    public void setResultado(String resultado) {
        this.resultado = resultado;
        notifyPropertyChanged(BR.resultado);
    }

    @Bindable
    public Validacion getValidacion() { return validacion; }

    public void setValidacion(Validacion validacion) {
        this.validacion = validacion;
        notifyPropertyChanged(BR.validacion);
    }

    public void calcular() {
        Validacion val = validar(entrada);
        setValidacion(val); // Guardamos el error para que el XML lo pinte

        if (val == Validacion.OK) {
            int edad = Integer.parseInt(entrada.trim());
            int edadHumana = edad * FACTOR_CANINO;
            setResultado(edadHumana + " años humanos");
        } else {
            setResultado("");
        }
    }

    public Validacion validar(String texto) {
        if (texto == null || texto.trim().isEmpty()) return Validacion.VACIO;
        int edad;
        try {
            edad = Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            return Validacion.NO_NUMERICO;
        }
        if (edad < EDAD_MINIMA || edad > EDAD_MAXIMA) return Validacion.FUERA_RANGO;
        return Validacion.OK;
    }
}