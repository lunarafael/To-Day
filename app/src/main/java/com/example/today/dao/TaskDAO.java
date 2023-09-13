package com.example.today.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.today.Model.Task;
import com.example.today.helpers.BancoHelperSQLite;

import java.util.ArrayList;
import java.util.List;

public class TaskDAO implements ITask{
    private SQLiteDatabase objW;
    private  SQLiteDatabase objR;

    public TaskDAO(Context ctx) {
        BancoHelperSQLite db = new BancoHelperSQLite(ctx);
        objW = db.getWritableDatabase();
        objR = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Task task) {
        try{
            ContentValues values = new ContentValues();
            values.put("nome", task.getNome());
            values.put("descricao", task.getNome());
            values.put("categoria", task.getCategoria());
            this.objW.insert("TAREFAS",null, values);

        }catch (Exception e){
            Log.i("INFO_TO_DAY", "ERRO AO INSERIR: " + e.getMessage() );
            return  false;
        }
        return true;
    }

    @Override
    public List<Task> listar() {
        List<Task> tasks = new ArrayList<>();
        try{
            String sql = "SELECT * FROM TAREFAS";
            Cursor cursor = objR.rawQuery(sql, null);
            int iid = cursor.getColumnIndexOrThrow("id");
            int inome = cursor.getColumnIndexOrThrow("nome");
            int idesc = cursor.getColumnIndexOrThrow("descricao");
            int icategoria = cursor.getColumnIndexOrThrow("categoria");
            cursor.moveToFirst();
            do {
                if(cursor.getCount() == 0) break;
                Task task = new Task();
                task.setId(Integer.valueOf(cursor.getString(iid)));
                task.setNome(cursor.getString(inome));
                task.setDescricao(cursor.getString(idesc));
                task.setCategoria(cursor.getString(icategoria));
                tasks.add(task);
            }while (cursor.moveToNext());
            Log.i("INFO_TO_DAY", "SUCESSO AO LISTAR AS TAREFAS");
        }catch (Exception e){
            Log.i("INFO_TO_DAY", "ERRO AO LISTAR: " + e.getMessage() );
            return  null;
        }
        return tasks;

    }

    @Override
    public int pegarQuantCategoriasPor(String Categoria) {

        return 0;
    }
}
