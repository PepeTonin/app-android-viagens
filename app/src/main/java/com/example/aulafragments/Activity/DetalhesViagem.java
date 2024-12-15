package com.example.aulafragments.Activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
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
    ImageView ivImagem;
    MediaPlayer mediaPlayer;
    ImageButton btnPlayPause;
    boolean isPlaying = false;

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
        ivImagem = findViewById(R.id.ivImagem);
        btnPlayPause = findViewById(R.id.btnPlayPause);

        Bundle bundle = getIntent().getExtras();

        if (bundle == null) {
            return;
        }

        // Obtendo os dados do pacote de viagem
        String origem = bundle.getString("origem");
        String destino = bundle.getString("destino");
        String dataIda = bundle.getString("dataIda");
        String dataVolta = bundle.getString("dataVolta");
        int pessoas = bundle.getInt("pessoas");
        float valor = bundle.getFloat("valor");

        // Exibindo os dados na interface
        tvOrigem.setText(origem);
        tvDestino.setText(destino);
        tvDataIda.setText(dataIda);
        tvDataVolta.setText(dataVolta);
        tvPessoas.setText(Integer.toString(pessoas));
        tvValor.setText(String.valueOf(valor));

        // Carregar a imagem do destino e o áudio
        if (destino != null) {
            switch (destino.toLowerCase()) {
                case "sao paulo":
                    ivImagem.setImageResource(R.drawable.saopaulo);
                    mediaPlayer = MediaPlayer.create(this, R.raw.saopaulo);
                    break;
                case "rio de janeiro":
                    ivImagem.setImageResource(R.drawable.riodejaneiro);
                    mediaPlayer = MediaPlayer.create(this, R.raw.riodejaneiro);
                    break;
                case "belem":
                    ivImagem.setImageResource(R.drawable.belem);
                    mediaPlayer = MediaPlayer.create(this, R.raw.belem);
                    break;
                case "recife":
                    ivImagem.setImageResource(R.drawable.recife);
                    mediaPlayer = MediaPlayer.create(this, R.raw.recife);
                    break;
                case "brasilia":
                    ivImagem.setImageResource(R.drawable.brasilia);
                    mediaPlayer = MediaPlayer.create(this, R.raw.brasilia);
                    break;
                case "belo horizonte":
                    ivImagem.setImageResource(R.drawable.bh);
                    mediaPlayer = MediaPlayer.create(this, R.raw.bh);
                    break;
                case "curitiba":
                    ivImagem.setImageResource(R.drawable.curitiba);
                    mediaPlayer = MediaPlayer.create(this, R.raw.curitiba);
                    break;
                case "joao pessoa":
                    ivImagem.setImageResource(R.drawable.joaopessoa);
                    mediaPlayer = MediaPlayer.create(this, R.raw.joaopessoa);
                    break;
                case "bonito":
                    ivImagem.setImageResource(R.drawable.bonito);
                    mediaPlayer = MediaPlayer.create(this, R.raw.bonito);
                    break;
                case "manaus":
                    ivImagem.setImageResource(R.drawable.manaus);
                    mediaPlayer = MediaPlayer.create(this, R.raw.manaus);
                    break;
                case "florianopolis":
                    ivImagem.setImageResource(R.drawable.floripa);
                    mediaPlayer = MediaPlayer.create(this, R.raw.floripa);
                    break;
                case "salvador":
                    ivImagem.setImageResource(R.drawable.salvador);
                    mediaPlayer = MediaPlayer.create(this, R.raw.salvador);
                    break;
                case "natal":
                    ivImagem.setImageResource(R.drawable.natal);
                    mediaPlayer = MediaPlayer.create(this, R.raw.natal);
                    break;
            }

            // Começar a reprodução do áudio automaticamente ao carregar o destino
            if (mediaPlayer != null) {
                playAudio();
            }
        }

        // Configurando o botão de controle de áudio
        btnPlayPause.setOnClickListener(v -> toggleAudio());
    }

    // Redirecionar ao Checkout
    public void comprar(View view) {
        Intent intent = new Intent(this, Checkout.class);
        startActivity(intent);
    }

    // Voltar à tela anterior
    public void voltar(View view) {
        finish();
    }

    // Método para controlar a reprodução do áudio
    private void playAudio() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            isPlaying = true;
            btnPlayPause.setImageResource(R.drawable.ic_pause);
        }
    }

    // Alternar entre play e pause
    private void toggleAudio() {
        if (isPlaying) {
            mediaPlayer.pause();
            btnPlayPause.setImageResource(R.drawable.ic_play);
        } else {
            mediaPlayer.start();
            btnPlayPause.setImageResource(R.drawable.ic_pause);
        }
        isPlaying = !isPlaying;
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}
