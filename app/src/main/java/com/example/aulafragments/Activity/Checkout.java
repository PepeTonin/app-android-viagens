package com.example.aulafragments.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aulafragments.R;

public class Checkout extends AppCompatActivity {

    private TextView tvNome;
    private TextView tvDataNascimento;
    private TextView tvEmail;
    private TextView tvTelefone;
    private TextView tvOrigem;
    private TextView tvDestino;
    private TextView tvIda;
    private TextView tvVolta;
    private TextView tvPessoas;
    private TextView tvValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        tvNome = findViewById(R.id.tvCheckoutNome);
        tvDataNascimento = findViewById(R.id.tvDataNascCheckout);
        tvEmail = findViewById(R.id.tvEmailCheckout);
        tvTelefone = findViewById(R.id.tvTelefoneCheckout);
        tvOrigem = findViewById(R.id.tvOrigem);;
        tvDestino = findViewById(R.id.tvDestino);;
        tvIda = findViewById(R.id.tvIda);;
        tvVolta = findViewById(R.id.tvVolta);;
        tvPessoas = findViewById(R.id.tvPessoas);;
        tvValor = findViewById(R.id.tvValor);;

        Intent intent = getIntent();

        String origem = intent.getStringExtra("origem");
        String destino = intent.getStringExtra("destino");
        String dataIda = intent.getStringExtra("dataIda");
        String dataVolta = intent.getStringExtra("dataVolta");
        int pessoas = intent.getIntExtra("pessoas", 0);
        float valor = intent.getFloatExtra("valor", 0);

        String nome = intent.getStringExtra("nome");
        String dataNascimento = intent.getStringExtra("nascimento");
        String email = intent.getStringExtra("email");
        String telefone = intent.getStringExtra("telefone");

        tvNome.setText("Nome: "+nome);
        tvDataNascimento.setText("Data de Nascimento: "+dataNascimento);
        tvEmail.setText("Email: "+email);
        tvTelefone.setText("Telefone: "+telefone);
        tvOrigem.setText("Origem: "+origem);
        tvDestino.setText("Destino: "+destino);
        tvIda.setText("Data da Ida: "+dataIda);
        tvVolta.setText("Data da Volta: "+dataVolta);
        tvPessoas.setText("Quantidade de Pessoas: "+pessoas);
        tvValor.setText("Valor: "+valor);
    }

    public void voltar(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}