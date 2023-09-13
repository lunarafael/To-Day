package com.example.today.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.today.Model.Task;
import com.example.today.R;
import com.example.today.dao.TaskDAO;

public class CadastroTarefas extends AppCompatActivity {
    private EditText editNome, editDesc;
    private Spinner spinCategoria;
    private Button btnCadastrar;
    private Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_tarefas);
        btnCadastrar = findViewById(R.id.buttonCadastro);
        btnVoltar = findViewById(R.id.buttonVolto);
        editNome = findViewById(R.id.eidtNome);
        editDesc = findViewById(R.id.editDesc);
        spinCategoria = findViewById(R.id.spinnerCAtegoria);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaskDAO dbTask = new TaskDAO(getApplicationContext());
                String nome = editNome.getText().toString();
                String desc = editDesc.getText().toString();
                String categoria = spinCategoria.getSelectedItem().toString();
                Task task = new Task();
                task.setNome(nome);
                task.setDescricao(desc);
                task.setCategoria(categoria);
                dbTask.salvar(task);
                Toast.makeText(CadastroTarefas.this, "Dados salvos com sucesso", Toast.LENGTH_SHORT).show();

            }
        });
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}