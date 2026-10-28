package es.davante.edadcanina;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // 1. Constantes para evitar números mágicos y validar
    private static final int FACTOR_CANINO = 7;
    private static final int EDAD_MINIMA = 1;
    private static final int EDAD_MAXIMA = 30;

    // 2. Variables declaradas a nivel de clase para usarlas en otros métodos
    private EditText ageEdit;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Lo mantengo porque lo tenías en tu código
        setContentView(R.layout.activity_main);

        // 3. Inicializamos las variables (usando TUS IDs)
        ageEdit = findViewById(R.id.age_input);
        resultText = findViewById(R.id.result_text);
        Button button1 = findViewById(R.id.btn_calc); // Usamos tu ID btn_calc

        // 4. Llamamos al método de calcular
        button1.setOnClickListener(view -> calcularEdad());
    }

    // Método principal que hace la validación y el cálculo
    private void calcularEdad() {
        String texto = ageEdit.getText().toString().trim();

        // Validación 1: ¿Está vacío?
        if (texto.isEmpty()) {
            mostrarError(getString(R.string.error_vacio));
            return;
        }

        int edad;
        // Validación 2: ¿Es un número? (Evita que la app se cierre)
        try {
            edad = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            mostrarError(getString(R.string.error_no_numero));
            return;
        }

        // Validación 3: ¿Está dentro del rango permitido?
        if (edad < EDAD_MINIMA || edad > EDAD_MAXIMA) {
            mostrarError(getString(R.string.error_rango, EDAD_MINIMA, EDAD_MAXIMA));
            return;
        }

        // Si todo está correcto, calculamos y mostramos
        ageEdit.setError(null); // Quita el error si lo hubiera
        int edadHumana = edad * FACTOR_CANINO;

        // Usamos el string con formato de strings.xml
        resultText.setText(getString(R.string.tu_edad_format, edadHumana));
    }

    // Método para mostrar los errores de forma limpia
    private void mostrarError(String mensaje) {
        ageEdit.setError(mensaje); // Muestra el icono de error en el EditText
        ageEdit.requestFocus();    // Pone el cursor en el EditText
        resultText.setText("");    // Borra el resultado anterior
    }
}