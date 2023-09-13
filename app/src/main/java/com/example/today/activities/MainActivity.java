package com.example.today.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.today.Model.Task;
import com.example.today.R;
import com.example.today.adapters.TaskAdapter;
import com.example.today.dao.TaskDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
   private FloatingActionButton fab;
   private List<Task> tasks = new ArrayList<>();
   private TextView casa, outros, exercicio, escola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        fab = findViewById(R.id.floatingActionButton5);
        casa = findViewById(R.id.quantCasa);
        outros = findViewById(R.id.quantOutros);
        exercicio = findViewById(R.id.quantExer);
        escola = findViewById(R.id.quantEscola);
        listarTarefas();
        List<Task> catCasa = this.tasks.stream()
                .filter(task -> task.getCategoria().equals("Casa"))
                .collect(Collectors.toList());
        List<Task> catExerc = this.tasks.stream()
                .filter(task -> task.getCategoria().equals("Exercício"))
                .collect(Collectors.toList());
        List<Task> catOutros = this.tasks.stream()
                .filter(task -> task.getCategoria().equals("Outros"))
                .collect(Collectors.toList());
        List<Task> catEscola = this.tasks.stream()
                .filter(task -> task.getCategoria().equals("Escola"))
                .collect(Collectors.toList());
        Integer quantCasa = catCasa.size();
        Integer quantExer = catExerc.size();
        Integer quantOutros = catOutros.size();
        Integer quantEscola = catEscola.size();
        casa.setText(quantCasa.toString());
        escola.setText(quantEscola.toString());
        outros.setText(quantOutros.toString());
        exercicio.setText(quantExer.toString());
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CadastroTarefas.class);
                startActivity(intent);
            }
        });

    }
    public void listarTarefas(){
        TaskDAO db = new TaskDAO(getApplicationContext());
        List<Task> tasks = db.listar();
        this.tasks = tasks;
        ListView taskListView = findViewById(R.id.taskListView);
        TaskAdapter taskAdapter = new TaskAdapter(this, tasks);
        taskListView.setAdapter(taskAdapter);
    }
}