package br.com.opet.expensedivisionapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText valueToDivide;
    private TextView valueForEachPerson, textPessoas;
    private SeekBar seekPessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueToDivide = findViewById(R.id.valueToDivide);
        valueForEachPerson = findViewById(R.id.valueForEachPerson);
        textPessoas = findViewById(R.id.textPessoas);
        seekPessoas = findViewById(R.id.seekPessoas);

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
