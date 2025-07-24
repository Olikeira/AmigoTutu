package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_cores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cores);

        ImageButton btn_voltar_cores = findViewById(R.id.btn_voltar_cores);
        btn_voltar_cores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_cores.this, MainActivity.class);
                intent.putExtra("scrollToAprendizado", true);
                startActivity(intent);
            }
        });
    }

    private MediaPlayer mediaPlayer;

    public void som_cores_preto(View view) {
        tocarSom(view, R.raw.som_cores_preto);
    }

    public void som_cores_branco(View view) {
        tocarSom(view, R.raw.som_cores_branco);
    }

    public void som_cores_amarelo(View view) {
        tocarSom(view, R.raw.som_cores_amarelo);
    }

    public void som_cores_verde(View view) {
        tocarSom(view, R.raw.som_cores_verde);
    }

    public void som_cores_azul(View view) {
        tocarSom(view, R.raw.som_cores_azul);
    }

    public void som_cores_vermelho(View view) {
        tocarSom(view, R.raw.som_cores_vermelho);
    }

    public void som_cores_roxo(View view) {
        tocarSom(view, R.raw.som_cores_roxo);
    }

    public void som_cores_laranja(View view) {
        tocarSom(view, R.raw.som_cores_laranja);
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