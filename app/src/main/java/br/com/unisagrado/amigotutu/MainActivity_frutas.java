package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_frutas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_frutas);

        ImageButton btn_voltar_frutas = findViewById(R.id.btn_voltar_frutas);
        btn_voltar_frutas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_frutas.this, MainActivity.class);
                intent.putExtra("scrollToAlimentacao", true);
                startActivity(intent);
            }
        });
    }

    private MediaPlayer mediaPlayer;

    public void som_frutas_banana(View view) {
        tocarSom(view, R.raw.som_frutas_banana);
    }

    public void som_frutas_laranja(View view) {
        tocarSom(view, R.raw.som_frutas_laranja);
    }

    public void som_frutas_morango(View view) {
        tocarSom(view, R.raw.som_frutas_morango);
    }

    public void som_frutas_uva(View view) {
        tocarSom(view, R.raw.som_frutas_uva);
    }

    public void som_frutas_abacaxi(View view) {
        tocarSom(view, R.raw.som_frutas_abacaxi);
    }

    public void som_frutas_melancia(View view) {
        tocarSom(view, R.raw.som_frutas_melancia);
    }

    public void som_frutas_maca(View view) {
        tocarSom(view, R.raw.som_frutas_maca);
    }

    public void som_frutas_mamao(View view) {
        tocarSom(view, R.raw.som_frutas_mamao);
    }

    public void som_frutas_abacate(View view) {
        tocarSom(view, R.raw.som_frutas_abacate);
    }

    public void som_frutas_melao(View view) {
        tocarSom(view, R.raw.som_frutas_melao);
    }

    // Método genérico para tocar o som e controlar o estado do botão
    private void tocarSom(View view, int somResId) {
        // Desabilita o botão para evitar cliques múltiplos
        view.setEnabled(false);

        // Verifica se o MediaPlayer já está tocando
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        // Cria e inicia o MediaPlayer com o som correspondente
        mediaPlayer = MediaPlayer.create(this, somResId);
        mediaPlayer.start();

        // Listener para reabilitar o botão após o som terminar
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                mediaPlayer = null;
                view.setEnabled(true);
            }
        });
    }
}