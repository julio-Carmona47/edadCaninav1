package es.davante.edadcanina.vista;

import android.widget.EditText;
import androidx.databinding.BindingAdapter;
import es.davante.edadcanina.modelo.Validacion;

public class EdadCaninaBindingAdapters {

    // Este adaptador se usará en el XML: app:errorDinamico="@{modelo.validacion}"
    @BindingAdapter("errorDinamico")
    public static void setErrorDinamico(EditText editText, Validacion validacion) {
        if (validacion == null || validacion == Validacion.OK) {
            editText.setError(null); // Todo bien, sin error
        } else {
            // Si hay error, mostramos el texto correspondiente
            switch (validacion) {
                case VACIO:
                    editText.setError("El campo no puede estar vacío");
                    break;
                case NO_NUMERICO:
                    editText.setError("Debes introducir un número válido");
                    break;
                case FUERA_RANGO:
                    editText.setError("La edad debe estar entre 1 y 30");
                    break;
            }
        }
    }
}