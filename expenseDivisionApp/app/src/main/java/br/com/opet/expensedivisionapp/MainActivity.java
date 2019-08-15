package br.com.opet.expensedivisionapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText valueToDivide;
    private TextView valueForEachPerson, textPessoas;
    private SeekBar seekPessoas;
    private CheckBox checkAcrescimo;
    private double original;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueToDivide = findViewById(R.id.valueToDivide);
        valueForEachPerson = findViewById(R.id.valueForEachPerson);
        textPessoas = findViewById(R.id.textPessoas);
        seekPessoas = findViewById(R.id.seekPessoas);
        checkAcrescimo = findViewById(R.id.checkAcrescimo);

        valueToDivide.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 0){
                    double X = Double.parseDouble(s.toString());
                    double Y = seekPessoas.getProgress();

                    double z = X/Y;

                    DecimalFormat df = new DecimalFormat("#0.00");

                    String result = "$ " + df.format(z) + " per person";

                    valueForEachPerson.setText(result);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().isEmpty()){
                    original = Double.parseDouble(s.toString());
                }
            }
        });

        checkAcrescimo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if(!valueToDivide.getText().toString().isEmpty()){
                        double X = original;
                        X *= 1.1;
                        DecimalFormat df = new DecimalFormat("#0.00");

                        valueToDivide.setText(df.format(X));
                    }else{
                        valueToDivide.setText(String.valueOf(original));
                    }
                }
            }
        });

        seekPessoas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textPessoas.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                if(!valueToDivide.getText().toString().isEmpty()){
                    String x = valueToDivide.getText().toString();

                    double X = Double.parseDouble(x);
                    double Y = seekPessoas.getProgress();

                    double z = X/Y;

                    DecimalFormat df = new DecimalFormat("#0.00");

                    String result = "$ " + df.format(z) + " per person";

                    valueForEachPerson.setText(result);
                }
            }
        });
    }

    /*public void expenseDivision(View view) {
        String x = valueToDivide.getText().toString();
        String y = peopleToDivide.getText().toString();

        double X = Double.parseDouble(x);
        double Y = Double.parseDouble(y);

        double z = X/Y;

        DecimalFormat df = new DecimalFormat("#0.00");

        String result = "$ " + df.format(z) + " per person";

        valueForEachPerson.setText(result);
    }*/
}
