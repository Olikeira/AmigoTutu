package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_necessidades extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_necessidades);

        ImageButton btn_voltar_necessidades = findViewById(R.id.btn_voltar_necessidades);
        btn_voltar_necessidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_necessidades.this, MainActivity.class);
                intent.putExtra("scrollToNecessidades", true);
                startActivity(intent);
            }
        });
    }

    private MediaPlayer mediaPlayer;

    public void som_necessidades_xixi(View view) {
        tocarSom(view, R.raw.som_necessidades_xixi);
    }

    public void som_necessidades_coco(View view) {
        tocarSom(view, R.raw.som_necessidades_coco);
    }

    public void som_necessidades_lavarasmaos(View view) {
        tocarSom(view, R.raw.som_necessidades_lavarasmaos);
    }

    public void som_necessidades_escovarosdentes(View view) {
        tocarSom(view, R.raw.som_necessidades_escovarosdentes);
    }

    public void som_necessidades_tomarbanho(View view) {
        tocarSom(view, R.raw.som_necessidades_tomarbanho);
    }

    public void som_necessidades_sono(View view) {
        tocarSom(view, R.raw.som_necessidades_sono);
    }

    public void som_necessidades_calor(View view) {
        tocarSom(view, R.raw.som_necessidades_calor);
    }

    public void som_necessidades_frio(View view) {
        tocarSom(view, R.raw.som_necessidades_frio);
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