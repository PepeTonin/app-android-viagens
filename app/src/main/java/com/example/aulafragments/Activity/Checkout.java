package com.example.aulafragments.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aulafragments.Database.DatabaseHelper;
import com.example.aulafragments.R;

public class Checkout extends AppCompatActivity {

    private TextView tvNome;
    private TextView tvDataNascimento;
    private TextView tvGenero;
    private TextView tvEmail;
    private TextView tvTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        tvNome = findViewById(R.id.tvCheckoutNome);
        tvDataNascimento = findViewById(R.id.tvDataNascCheckout);
        tvGenero = findViewById(R.id.tvGeneroCheckout);
        tvEmail = findViewById(R.id.tvEmailCheckout);
        tvTelefone = findViewById(R.id.tvTelefoneCheckout);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM perfil", null);

        int indiceNome = cursor.getColumnIndex("nome");
        int indiceDataNascimento = cursor.getColumnIndex("dataNascimento");
        int indiceGenero = cursor.getColumnIndex("genero");
        int indiceEmail = cursor.getColumnIndex("email");
        int indiceTelefone = cursor.getColumnIndex("telefone");

        if (cursor.moveToFirst()) {
            String nome = cursor.getString(indiceNome);
            String dataNascimento = cursor.getString(indiceDataNascimento);
            String genero = cursor.getString(indiceGenero);
            String email = cursor.getString(indiceEmail);
            String telefone = cursor.getString(indiceTelefone);
            tvNome.setText(nome);
            tvDataNascimento.setText(dataNascimento);
            tvGenero.setText(genero);
            tvEmail.setText(email);
            tvTelefone.setText(telefone);
        }

        cursor.close();
        db.close();
    }



    public void voltar(View view) {
        finish();
    }
}
