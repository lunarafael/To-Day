package com.example.today.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.today.Model.Task;
import com.example.today.R;

import java.util.List;

public class TaskAdapter extends ArrayAdapter<Task> {
    public TaskAdapter(Context context, List<Task> tasks) {
        super(context, 0, tasks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obter a tarefa atual da lista
        Task task = getItem(position);

        // Verifique se uma view está sendo reutilizada, caso contrário, inflamos uma nova
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.task_layout, parent, false);
        }

        // Encontre as Views no layout do item de tarefa
        TextView taskName = convertView.findViewById(R.id.taskNameTextView);
        TextView taskDesc = convertView.findViewById(R.id.taskDescriptionTextView);
        // Configure as informações do item de tarefa com base nos dados da tarefa
        taskName.setText(task.getNome());
        taskDesc.setText(task.getDescricao());
        return convertView;
    }
}
