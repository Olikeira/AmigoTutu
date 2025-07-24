package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_bebidas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bebidas);

        ImageButton btn_voltar_bebidas = findViewById(R.id.btn_voltar_bebidas);
        btn_voltar_bebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_bebidas.this, MainActivity.class);
                intent.putExtra("scrollToAlimentacao", true);
                startActivity(intent);
            }
        });
    }

    private MediaPlayer mediaPlayer;

    public void som_bebidas_agua(View view) {
        tocarSom(view, R.raw.som_bebidas_agua);
    }

    public void som_bebidas_suco(View view) {
        tocarSom(view, R.raw.som_bebidas_suco);
    }

    public void som_bebidas_leite(View view) {
        tocarSom(view, R.raw.som_bebidas_leite);
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