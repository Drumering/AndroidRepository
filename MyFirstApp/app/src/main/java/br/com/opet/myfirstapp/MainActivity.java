package br.com.opet.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        textValor = findViewById(R.id.textValor);
    }

    public void converter_para_real(View view) {
        String valorText = editValor.getText().toString();
        double dolar = Double.parseDouble(valorText);
        double real = 3.97;

        double resultado = dolar * real;

        String formatado = "R$ " + resultado;

        textValor.setText(formatado);
    }
}
