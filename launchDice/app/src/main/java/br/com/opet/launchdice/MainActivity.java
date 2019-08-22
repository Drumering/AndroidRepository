package br.com.opet.launchdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekDados;
    private TextView quantidadeDados;
    private SeekBar seekFaces;
    private TextView quantidadeFaces;
    private TextView resultDice;
    private ArrayList<Dado> listDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekDados = findViewById(R.id.seekDados);
        quantidadeDados = findViewById(R.id.quantidadeDados);

        seekFaces = findViewById(R.id.seekFaces);
        quantidadeFaces = findViewById(R.id.quantidadeFaces);

        resultDice = findViewById(R.id.resultDice);

        listDados = new ArrayList<Dado>();

        seekDados.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                quantidadeDados.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                for (int i = 0;i < seekBar.getProgress();i++){
                    listDados.add(new Dado(seekFaces.getProgress()));
                }

                for (Dado d: listDados) {
                    resultDice.setText("Dado:" + listDados.indexOf(d));
                }
            }
        });

        seekFaces.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                quantidadeFaces.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
