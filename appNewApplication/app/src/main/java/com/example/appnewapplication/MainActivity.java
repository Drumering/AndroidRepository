package com.example.appnewapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup g1;
    private RadioGroup g2;
    private RadioGroup g3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        g1 = findViewById(R.id.group1);
        g2 = findViewById(R.id.group2);
        g3 = findViewById(R.id.group3);
    }

    public void verificar(View view) {

        int acertos = 0;

        int id1 = g1.getCheckedRadioButtonId();
        int id2 = g2.getCheckedRadioButtonId();
        int id3 = g3.getCheckedRadioButtonId();

        String texto = "";
        
        if(id1 == R.id.radio3_1){
            acertos += 1;
        }
        if (id2 == R.id.radio4_2){
            acertos += 1;
        }
        if (id3 == R.id.radio4_3){
            acertos += 1;
        }
        if(acertos == 3){
            texto = "Perfeito!";
        }else if(acertos == 2){
            texto = "Quase lá!";
        }else if(acertos == 1){
            texto = "Você pode melhorar";
        }else{
            texto = "Tente outra vez";
        }

        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
    }
}