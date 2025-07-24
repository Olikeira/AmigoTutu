package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_comentarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_comentarios);

        ImageButton btn_voltar_comentarios = findViewById(R.id.btn_voltar_comentarios);
        btn_voltar_comentarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_comentarios.this, MainActivity.class);
                intent.putExtra("scrollToComunicacao", true);
                startActivity(intent);
            }
        });
    }

    private MediaPlayer mediaPlayer;

    public void som_comentarios_sim(View view) {
        tocarSom(view, R.raw.som_comentarios_sim);
    }

    public void som_comentarios_nao(View view) {
        tocarSom(view, R.raw.som_comentarios_nao);
    }

    public void som_comentarios_gostodisso(View view) {
        tocarSom(view, R.raw.som_comentarios_gostodisso);
    }

    public void som_comentarios_naogostodisso(View view) {
        tocarSom(view, R.raw.som_comentarios_naogostodisso);
    }

    public void som_comentarios_obrigado(View view) {
        tocarSom(view, R.raw.som_comentarios_obrigado);
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