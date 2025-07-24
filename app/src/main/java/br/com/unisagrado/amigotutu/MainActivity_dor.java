package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_dor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dor);

        ImageButton btn_voltar_dor = findViewById(R.id.btn_voltar_dor);
        btn_voltar_dor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_dor.this, MainActivity.class);
                intent.putExtra("scrollToNecessidades", true);
                startActivity(intent);
            }
        });
    }

    private MediaPlayer mediaPlayer;

    public void som_dor_cabeca(View view) {
        tocarSom(view, R.raw.som_dor_cabeca);
    }

    public void som_dor_barriga(View view) {
        tocarSom(view, R.raw.som_dor_barriga);
    }

    public void som_dor_garganta(View view) {
        tocarSom(view, R.raw.som_dor_garganta);
    }

    public void som_dor_dente(View view) {
        tocarSom(view, R.raw.som_dor_dente);
    }

    public void som_dor_braco(View view) {
        tocarSom(view, R.raw.som_dor_braco);
    }

    public void som_dor_mao(View view) {
        tocarSom(view, R.raw.som_dor_mao);
    }

    public void som_dor_perna(View view) {
        tocarSom(view, R.raw.som_dor_perna);
    }

    public void som_dor_pe(View view) {
        tocarSom(view, R.raw.som_dor_pe);
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