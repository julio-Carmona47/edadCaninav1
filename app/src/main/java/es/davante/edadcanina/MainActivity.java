package es.davante.edadcanina;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import es.davante.edadcanina.databinding.ActivityMainBinding;
import es.davante.edadcanina.modelo.EdadCaninaModelo;

public class MainActivity extends AppCompatActivity {

    // Claves constantes para guardar el estado (Paso 7)
    private static final String KEY_ENTRADA = "key_entrada";
    private static final String KEY_RESULTADO = "key_resultado";

    private ActivityMainBinding binding;
    private EdadCaninaModelo modelo;
    private EdadCaninaControlador controlador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        modelo = new EdadCaninaModelo();
        controlador = new EdadCaninaControlador(modelo);


        if (savedInstanceState != null) {
            modelo.setEntrada(savedInstanceState.getString(KEY_ENTRADA, ""));
            modelo.setResultado(savedInstanceState.getString(KEY_RESULTADO, ""));
        }


        binding.setModelo(modelo);
        binding.setControlador(controlador);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_ENTRADA, modelo.getEntrada());
        outState.putString(KEY_RESULTADO, modelo.getResultado());
    }
}