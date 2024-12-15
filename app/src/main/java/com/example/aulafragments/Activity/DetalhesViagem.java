package com.example.aulafragments.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aulafragments.R;

public class DetalhesViagem extends AppCompatActivity {

    TextView tvOrigem;
    TextView tvDestino;
    TextView tvDataIda;
    TextView tvDataVolta;
    TextView tvPessoas;
    TextView tvValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_viagem);

        tvOrigem = findViewById(R.id.tvOrigem2);
        tvDestino = findViewById(R.id.tvDestino2);
        tvDataIda = findViewById(R.id.tvDataIda2);
        tvDataVolta = findViewById(R.id.tvDataVolta2);
        tvPessoas = findViewById(R.id.tvPessoas2);
        tvValor = findViewById(R.id.tvValor2);

        Bundle bundle = getIntent().getExtras();

        if (bundle == null) {
            return;
        }

        String origem = bundle.getString("origem");
        String destino = bundle.getString("destino");
        String dataIda = bundle.getString("dataIda");
        String dataVolta = bundle.getString("dataVolta");
        int pessoas = bundle.getInt("pessoas");
        float valor = bundle.getFloat("valor");

        tvOrigem.setText(origem);
        tvDestino.setText(destino);
        tvDataIda.setText(dataIda);
        tvDataVolta.setText(dataVolta);
        tvPessoas.setText(Integer.toString(pessoas));
        tvValor.setText(String.valueOf(valor));
    }

    public void comprar(View view) {
        Intent intent = new Intent(this, Checkout.class);
        startActivity(intent);
    }

    public void voltar(View view) {
        finish();
    }
}
