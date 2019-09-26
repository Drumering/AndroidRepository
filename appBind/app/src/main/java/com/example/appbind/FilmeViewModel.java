package com.example.appbind;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FilmeViewModel extends ViewModel {
    private String titulo;
    private Integer ano;
    private MutableLiveData<Integer> likes;

    public FilmeViewModel(){
        this.titulo = "Joanão";
        this.ano = 2019;
        this.likes = new MutableLiveData<>();
        this.likes.setValue(0);
    }

    public void onLike(){
        likes.setValue(likes.getValue()+1);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public MutableLiveData<Integer> getLikes() {
        return likes;
    }

    public void setLikes(MutableLiveData<Integer> likes) {
        this.likes = likes;
    }
}
