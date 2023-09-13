package com.example.today.dao;

import com.example.today.Model.Task;

import java.util.List;

public interface ITask {
    public  boolean salvar(Task task);
    public List<Task> listar();
    public int pegarQuantCategoriasPor(String Categoria);


}
