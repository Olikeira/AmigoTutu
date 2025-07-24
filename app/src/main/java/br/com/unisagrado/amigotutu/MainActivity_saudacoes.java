package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_saudacoes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_saudacoes);

        ImageButton btn_voltar_saudacoes = findViewById(R.id.btn_voltar_saudacoes);
        btn_voltar_saudacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_saudacoes.this, MainActivity.class);
                intent.putExtra("scrollToComunicacao", true);
                startActivity(intent);
            }
        });
    }

    private MediaPlayer mediaPlayer;

    public void som_saudacoes_bomdia(View view) {
        tocarSom(view, R.raw.som_saudacoes_bomdia);
    }

    public void som_saudacoes_boanoite(View view) {
        tocarSom(view, R.raw.som_saudacoes_boanoite);
    }

    public void som_saudacoes_ola(View view) {
        tocarSom(view, R.raw.som_saudacoes_ola);
    }

    public void som_saudacoes_tchau(View view) {
        tocarSom(view, R.raw.som_saudacoes_tchau);
    }

    public void som_saudacoes_tudobem(View view) {
        tocarSom(view, R.raw.som_saudacoes_tudobem);
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