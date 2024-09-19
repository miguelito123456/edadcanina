package com.example.contadormiguelangelterrazasmarrufo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEdad;
    private TextView textViewResultado;
    private Button botonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vinculamos los elementos del layout con el código
        editTextEdad = findViewById(R.id.edad);
        textViewResultado = findViewById(R.id.resultado);
        botonCalcular = findViewById(R.id.boton);

        // Acción al hacer clic en el botón
        botonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularEdad();
            }
        });
    }

    private void calcularEdad() {
        String edadTexto = editTextEdad.getText().toString();

        // Verificamos si se ingresó algún valor
        if (!edadTexto.isEmpty()) {
            try {
                int edad = Integer.parseInt(edadTexto);
                int edadHumana = edad * 7;  // Puedes ajustar este cálculo si lo necesitas
                textViewResultado.setText("La edad en años humanos es: " + edadHumana);
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Por favor ingresa un número válido", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Por favor ingresa la edad", Toast.LENGTH_SHORT).show();
        }
    }
}
