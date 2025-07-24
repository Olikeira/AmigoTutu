package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_expressoes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_expressoes);

        ImageButton btn_voltar_expressoes = findViewById(R.id.btn_voltar_expressoes);
        btn_voltar_expressoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_expressoes.this, MainActivity.class);
                intent.putExtra("scrollToEmocoes", true);
                startActivity(intent);
            }
        });
    }

    private MediaPlayer mediaPlayer;

    public void som_expressoes_teamo(View view) {
        tocarSom(view, R.raw.som_expressoes_teamo);
    }

    public void som_expressoes_abraco(View view) {
        tocarSom(view, R.raw.som_expressoes_abraco);
    }

    public void som_expressoes_feliz(View view) {
        tocarSom(view, R.raw.som_expressoes_feliz);
    }

    public void som_expressoes_triste(View view) {
        tocarSom(view, R.raw.som_expressoes_triste);
    }

    public void som_expressoes_bravo(View view) {
        tocarSom(view, R.raw.som_expressoes_bravo);
    }

    public void som_expressoes_assustado(View view) {
        tocarSom(view, R.raw.som_expressoes_assustado);
    }

    public void som_expressoes_medo(View view) {
        tocarSom(view, R.raw.som_expressoes_medo);
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