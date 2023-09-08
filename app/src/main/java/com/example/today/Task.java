package com.example.today;

public class Task {
    private String nome;
    private String desc;

    public  Task(String nome, String desv){
        this.nome = nome;
        this.desc = desv;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
