package com.example.aulafragments.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.aulafragments.Model.PerfilUsuario;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS perfil (nome TEXT, dataNascimento TEXT, genero TEXT, email TEXT, telefone TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades if needed
    }

    public long inserirPerfil(PerfilUsuario perfil) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", perfil.getNome());
        values.put("dataNascimento", perfil.getDataNascimento());
        values.put("genero", perfil.getGenero());
        values.put("email", perfil.getEmail());
        values.put("telefone", perfil.getTelefone());
        long newRowId = db.insert("perfil", null, values);
        db.close();
        return newRowId;
    }
}
