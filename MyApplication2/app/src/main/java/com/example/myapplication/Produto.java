package com.example.myapplication;

public class Produto {
    private String nome;
    private String unidade;
    private int quantidade;
    private boolean p;

    public boolean isP() {
        return p;
    }

    public void setP(boolean p) {
        this.p = p;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto(String nome, int quantidade,String unidade, boolean p) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.p = p;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}
