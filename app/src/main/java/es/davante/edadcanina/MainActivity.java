package es.davante.edadcanina;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import es.davante.edadcanina.databinding.ActivityMainBinding;
import es.davante.edadcanina.modelo.EdadCaninaModelo;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private EdadCaninaModelo modelo; // Nueva variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // 1. Instanciamos el modelo
        modelo = new EdadCaninaModelo();

        // 2. Asociamos el modelo al XML
        binding.setModelo(modelo);

        // 3. El botón llama directamente al método del modelo
        binding.btnCalc.setOnClickListener(view -> modelo.calcular());
    }
}