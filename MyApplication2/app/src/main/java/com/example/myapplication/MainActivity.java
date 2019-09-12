package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editProduto, editQuantidade;
    private Spinner spinnerUnidade;
    private ListView listDisciplinas;
    private List<Produto> produtos;
    private ArrayAdapter adapter;
    private CheckBox checkPrioridade;
    private boolean p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        editProduto = findViewById(R.id.editProduto);
        editQuantidade = findViewById(R.id.editQuantidade);
        listDisciplinas = findViewById(R.id.listDisciplinas);
        spinnerUnidade = findViewById(R.id.spinnerUnidade);
        checkPrioridade = findViewById(R.id.checkPrioridade);

        checkPrioridade.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    p = true;
                }else {
                    p = false;
                }
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();

        produtos = new ArrayList<>();
        adapter = new ProdutoAdapter(getApplicationContext(),R.layout.list_item, produtos);
        listDisciplinas.setAdapter(adapter);
    }

    public void adicionarProduto(View view) {
        String nome = editProduto.getText().toString();
        int quantidade = Integer.parseInt(editQuantidade.getText().toString());
        String unidade = spinnerUnidade.getSelectedItem().toString();
        Produto produto = new Produto(nome,quantidade,unidade,p);

        produtos.add(produto);

        adapter.notifyDataSetChanged();
    }
}
