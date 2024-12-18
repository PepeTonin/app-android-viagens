package com.example.aulafragments.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aulafragments.Database.DatabaseHelper;
import com.example.aulafragments.Model.Venda;
import com.example.aulafragments.R;

public class Preeencher extends AppCompatActivity {

    private TextView tvnome;
    private TextView tvnascimento;
    private TextView tvemail;
    private TextView tvtelefone;

    String nome = "";
    String dataNascimento = "";
    String email = "";
    String telefone = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preencher_dados);

        tvnome = findViewById(R.id.nome);
        tvemail = findViewById(R.id.email);
        tvnascimento = findViewById(R.id.data_nascimento);
        tvtelefone = findViewById(R.id.telefone);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM perfil", null);

        int indiceNome = cursor.getColumnIndex("nome");
        int indiceDataNascimento = cursor.getColumnIndex("dataNascimento");
        int indiceEmail = cursor.getColumnIndex("email");
        int indiceTelefone = cursor.getColumnIndex("telefone");

        if (cursor.moveToFirst()) {
             nome = cursor.getString(indiceNome);
             dataNascimento = cursor.getString(indiceDataNascimento);
             email = cursor.getString(indiceEmail);
             telefone = cursor.getString(indiceTelefone);

            tvnome.setText("Nome: "+nome);
            tvnascimento.setText("Data de Nascimento : "+dataNascimento);
            tvemail.setText("Email: "+email);
            tvtelefone.setText("Telefone: "+telefone);
        }

        cursor.close();
        db.close();
    }

    public void voltar(View view) {
        finish();
    }

    public void confirmar(View view) {
        Intent intent = new Intent(this, Checkout.class);
        intent.putExtra("nome", nome);
        intent.putExtra("nascimento", dataNascimento);
        intent.putExtra("email", email);
        intent.putExtra("telefone", telefone);

        Bundle bundle = getIntent().getExtras();
        String origem = bundle.getString("origem");
        String destino = bundle.getString("destino");
        String dataIda = bundle.getString("dataIda");
        String dataVolta = bundle.getString("dataVolta");
        int pessoas = bundle.getInt("pessoas");
        float valor = bundle.getFloat("valor");

        intent.putExtra("origem", origem);
        intent.putExtra("destino", destino);
        intent.putExtra("dataIda", dataIda);
        intent.putExtra("dataVolta", dataVolta);
        intent.putExtra("pessoas", pessoas);
        intent.putExtra("valor", valor);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        Venda venda = new Venda(nome, dataNascimento, email, telefone, origem, destino, dataIda, dataVolta, pessoas, valor);
        dbHelper.inserirVenda(venda);

        startActivity(intent);
    }
}
