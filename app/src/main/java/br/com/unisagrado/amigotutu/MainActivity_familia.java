package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_familia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_familia);

        ImageButton btn_voltar_familia = findViewById(R.id.btn_voltar_familia);
        btn_voltar_familia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_familia.this, MainActivity.class);
                intent.putExtra("scrollToEmocoes", true);
                startActivity(intent);
            }
        });
    }

    private MediaPlayer mediaPlayer;

    public void som_familia_papai(View view) {
        tocarSom(view, R.raw.som_familia_papai);
    }

    public void som_familia_mamae(View view) {
        tocarSom(view, R.raw.som_familia_mamae);
    }

    public void som_familia_vovoh(View view) {
        tocarSom(view, R.raw.som_familia_vovoh);
    }

    public void som_familia_vovom(View view) {
        tocarSom(view, R.raw.som_familia_vovom);
    }

    public void som_familia_irmao(View view) {
        tocarSom(view, R.raw.som_familia_irmao);
    }

    public void som_familia_irma(View view) {
        tocarSom(view, R.raw.som_familia_irma);
    }

    public void som_familia_familia(View view) {
        tocarSom(view, R.raw.som_familia_familia);
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