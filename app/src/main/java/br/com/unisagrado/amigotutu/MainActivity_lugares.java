package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_lugares extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lugares);

        ImageButton btn_voltar_lugares = findViewById(R.id.btn_voltar_lugares);
        btn_voltar_lugares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_lugares.this, MainActivity.class);
                intent.putExtra("scrollToLugares", true);
                startActivity(intent);
            }
        });
    }

    private MediaPlayer mediaPlayer;

    public void som_lugares_casa(View view) {
        tocarSom(view, R.raw.som_lugares_casa);
    }

    public void som_lugares_escola(View view) {
        tocarSom(view, R.raw.som_lugares_escola);
    }

    public void som_lugares_banheiro(View view) {
        tocarSom(view, R.raw.som_lugares_banheiro);
    }

    public void som_lugares_igreja(View view) {
        tocarSom(view, R.raw.som_lugares_igreja);
    }

    public void som_lugares_terapia(View view) {
        tocarSom(view, R.raw.som_lugares_terapia);
    }

    public void som_lugares_parquinho(View view) {
        tocarSom(view, R.raw.som_lugares_parquinho);
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