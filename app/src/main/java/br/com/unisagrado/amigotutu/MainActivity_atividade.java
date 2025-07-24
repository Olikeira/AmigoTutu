package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_atividade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_atividade);

        ImageButton btn_voltar_atividade = findViewById(R.id.btn_voltar_atividade);
        btn_voltar_atividade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_atividade.this, MainActivity.class);
                intent.putExtra("scrollToDiversao", true);
                startActivity(intent);
            }
        });
    }

    private MediaPlayer mediaPlayer;

    public void som_atividade_musica(View view) {
        tocarSom(view, R.raw.som_atividade_musica);
    }

    public void som_atividade_livro(View view) {
        tocarSom(view, R.raw.som_atividade_livro);
    }

    public void som_atividade_papel(View view) {
        tocarSom(view, R.raw.som_atividade_papel);
    }

    public void som_atividade_desenhar(View view) {
        tocarSom(view, R.raw.som_atividade_desenhar);
    }

    public void som_atividade_colorir(View view) {
        tocarSom(view, R.raw.som_atividade_colorir);
    }

    public void som_atividade_lapis(View view) {
        tocarSom(view, R.raw.som_atividade_lapis);
    }

    public void som_atividade_regua(View view) {
        tocarSom(view, R.raw.som_atividade_regua);
    }

    public void som_atividade_tesoura(View view) {
        tocarSom(view, R.raw.som_atividade_tesoura);
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