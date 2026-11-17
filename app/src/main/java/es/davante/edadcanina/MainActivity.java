package es.davante.edadcanina;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
// IMPORTANTE: Estos dos imports nuevos son necesarios para DataBinding
import androidx.databinding.DataBindingUtil;
import es.davante.edadcanina.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final int FACTOR_CANINO = 7;
    private static final int EDAD_MINIMA = 1;
    private static final int EDAD_MAXIMA = 30;

    // 1. Declaramos el objeto Binding (en lugar de las variables EditText y TextView)
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // 2. Inicializamos el Binding en lugar de setContentView
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // 3. Usamos el binding para el botón. ¡Ya no hay ningún findViewById!
        binding.btnCalc.setOnClickListener(view -> calcularEdad());
    }

    private void calcularEdad() {
        // Usamos binding.ageInput en lugar de ageEdit
        String texto = binding.ageInput.getText().toString().trim();

        if (texto.isEmpty()) {
            mostrarError(getString(R.string.error_vacio));
            return;
        }

        int edad;
        try {
            edad = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            mostrarError(getString(R.string.error_no_numero));
            return;
        }

        if (edad < EDAD_MINIMA || edad > EDAD_MAXIMA) {
            mostrarError(getString(R.string.error_rango, EDAD_MINIMA, EDAD_MAXIMA));
            return;
        }

        // Usamos binding.ageInput y binding.resultText
        binding.ageInput.setError(null);
        int edadHumana = edad * FACTOR_CANINO;
        binding.resultText.setText(getString(R.string.tu_edad_format, edadHumana));
    }

    private void mostrarError(String mensaje) {
        binding.ageInput.setError(mensaje);
        binding.ageInput.requestFocus();
        binding.resultText.setText("");
    }
}