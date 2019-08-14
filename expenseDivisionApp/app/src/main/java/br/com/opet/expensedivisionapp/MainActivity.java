package br.com.opet.expensedivisionapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText valueToDivide;
    private EditText peopleToDivide;
    private TextView valueForEachPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valueToDivide = findViewById(R.id.valueToDivide);
        peopleToDivide = findViewById(R.id.peopleToDivide);
        valueForEachPerson = findViewById(R.id.valueForEachPerson);
    }

    public void expenseDivision(View view) {
        String x = valueToDivide.getText().toString();
        String y = peopleToDivide.getText().toString();

        double X = Double.parseDouble(x);
        double Y = Double.parseDouble(y);

        double z = X/Y;

        DecimalFormat df = new DecimalFormat("#0.00");

        String result = "$ " + df.format(z) + " per person";

        valueForEachPerson.setText(result);
    }
}
