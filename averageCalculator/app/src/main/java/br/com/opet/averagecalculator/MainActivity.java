package br.com.opet.averagecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText pNota;
    private EditText sNota;
    private EditText tNota;
    private CheckBox ponderar;
    private TextView conceito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pNota = findViewById(R.id.pNota);
        sNota = findViewById(R.id.sNota);
        tNota = findViewById(R.id.tNota);
        ponderar = findViewById(R.id.ponderar);
        conceito = findViewById(R.id.conceito);

        tNota.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 0 && pNota.length() > 0 && sNota.length() > 0){
                    double x = Double.parseDouble(s.toString());
                    double y = Double.parseDouble(pNota.getText().toString());
                    double z = Double.parseDouble(sNota.getText().toString());

                    double r = (x + y + z) / 3;

                    if(r > 9){
                        conceito.setText("A");
                    }else if(r > 8){
                        conceito.setText("B");
                    }else if(r > 7){
                        conceito.setText("C");
                    }else if(r > 4){
                        conceito.setText("D");
                    }else{
                        conceito.setText("E");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ponderar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    double x = Double.parseDouble(pNota.getText().toString());
                    double y = Double.parseDouble(sNota.getText().toString());
                    double z = Double.parseDouble(tNota.getText().toString());

                    double p1 = 1;
                    double p2 = 2;
                    double p3 = 3;

                    double r = ((x + p1) + (y + p2) + (z + p3)) / 6;

                    if(r > 9){
                        conceito.setText("A");
                    }else if(r > 8){
                        conceito.setText("B");
                    }else if(r > 7){
                        conceito.setText("C");
                    }else if(r > 4){
                        conceito.setText("D");
                    }else{
                        conceito.setText("E");
                    }
                }else{
                    double x = Double.parseDouble(pNota.getText().toString());
                    double y = Double.parseDouble(sNota.getText().toString());
                    double z = Double.parseDouble(tNota.getText().toString());

                    double r = (x + y + z) / 3;

                    if(r > 9){
                        conceito.setText("A");
                    }else if(r > 8){
                        conceito.setText("B");
                    }else if(r > 7){
                        conceito.setText("C");
                    }else if(r > 4){
                        conceito.setText("D");
                    }else{
                        conceito.setText("E");
                    }
                }
            }
        });
    }
}
