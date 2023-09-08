package com.example.today;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<CategoryItem> categories = new ArrayList<>();
        categories.add(new CategoryItem("Categoria 1", 5));
        categories.add(new CategoryItem("Categoria 2", 8));
        categories.add(new CategoryItem("Categoria 3", 3));

        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Tarefa 1", "Descrição da Tarefa 1"));
        tasks.add(new Task("Tarefa 2", "Descrição da Tarefa 2"));
        tasks.add(new Task("Tarefa 3", "Descrição da Tarefa 3"));

        // Configurando o adaptador para a lista de categorias
        ListView categoryListView = findViewById(R.id.listView);
        CategoryAdapter categoryAdapter = new CategoryAdapter(this, categories);
        categoryListView.setAdapter(categoryAdapter);

        // Configurando o adaptador para a lista de tarefas
        ListView taskListView = findViewById(R.id.taskListView);
        TaskAdapter taskAdapter = new TaskAdapter(this, tasks);
        taskListView.setAdapter(taskAdapter);

    }
}