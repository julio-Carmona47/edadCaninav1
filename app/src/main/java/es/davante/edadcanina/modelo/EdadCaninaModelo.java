package es.davante.edadcanina.modelo;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import es.davante.edadcanina.BR; // Importante: BR se genera automáticamente

public class EdadCaninaModelo extends BaseObservable {

    public static final int FACTOR_CANINO = 7;
    public static final int EDAD_MINIMA = 1;
    public static final int EDAD_MAXIMA = 30;

    private String entrada = "";
    private String resultado = "";

    @Bindable
    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        // Comprobación de cambio para no hacer trabajo extra
        if (this.entrada != null && !this.entrada.equals(entrada)) {
            this.entrada = entrada;
            notifyPropertyChanged(BR.entrada);

            // Si cambia la entrada, el resultado caduca y se borra
            setResultado("");
        }
    }

    @Bindable
    public String getResultado() {
        return resultado;
    }

    // Setter privado: el resultado solo lo puede cambiar el propio modelo
    private void setResultado(String resultado) {
        this.resultado = resultado;
        notifyPropertyChanged(BR.resultado);
    }

    // Método que ejecuta el cálculo y actualiza el resultado
    public void calcular() {
        Validacion val = validar(entrada);
        if (val == Validacion.OK) {
            int edad = Integer.parseInt(entrada.trim());
            int edadHumana = edad * FACTOR_CANINO;
            // Formateamos el texto (deberás tener este string en strings.xml)
            setResultado(edadHumana + " años humanos");
        } else {
            setResultado(""); // Si hay error, borramos resultado
        }
    }

    public Validacion validar(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return Validacion.VACIO;
        }
        int edad;
        try {
            edad = Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            return Validacion.NO_NUMERICO;
        }
        if (edad < EDAD_MINIMA || edad > EDAD_MAXIMA) {
            return Validacion.FUERA_RANGO;
        }
        return Validacion.OK;
    }
}