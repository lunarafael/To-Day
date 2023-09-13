package com.example.today.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class BancoHelperSQLite extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db_toDay";
    private static final int DATABASE_VERSION = 2;
    public BancoHelperSQLite(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS TAREFAS(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(500), descricao VARCHAR(500), categoria VARCHAR(500))");
            Log.i("INFO_TO_DAY", "BANCO CRIADO COM SUCESSO");

        }catch (Exception e){
            Log.i("INFO_TO_DAY", "ERRO INTERNO NO SERVIDOR: " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
