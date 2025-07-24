package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_numeros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_numeros);

        ImageButton btn_voltar_numeros = findViewById(R.id.btn_voltar_numeros);
        btn_voltar_numeros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_numeros.this, MainActivity.class);
                intent.putExtra("scrollToAprendizado", true);
                startActivity(intent);
            }
        });
    }

    private MediaPlayer mediaPlayer;

    public void som_numeros_0(View view) {
        tocarSom(view, R.raw.som_numeros_0);
    }

    public void som_numeros_1(View view) {
        tocarSom(view, R.raw.som_numeros_1);
    }

    public void som_numeros_2(View view) {
        tocarSom(view, R.raw.som_numeros_2);
    }

    public void som_numeros_3(View view) {
        tocarSom(view, R.raw.som_numeros_3);
    }

    public void som_numeros_4(View view) {
        tocarSom(view, R.raw.som_numeros_4);
    }

    public void som_numeros_5(View view) {
        tocarSom(view, R.raw.som_numeros_5);
    }

    public void som_numeros_6(View view) {
        tocarSom(view, R.raw.som_numeros_6);
    }

    public void som_numeros_7(View view) {
        tocarSom(view, R.raw.som_numeros_7);
    }

    public void som_numeros_8(View view) {
        tocarSom(view, R.raw.som_numeros_8);
    }

    public void som_numeros_9(View view) {
        tocarSom(view, R.raw.som_numeros_9);
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