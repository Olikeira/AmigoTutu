package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_pedidos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pedidos);

        ImageButton btn_voltar_pedidos = findViewById(R.id.btn_voltar_pedidos);
        btn_voltar_pedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_pedidos.this, MainActivity.class);
                intent.putExtra("scrollToComunicacao", true);
                startActivity(intent);
            }
        });
    }

    private MediaPlayer mediaPlayer;

    public void som_pedidos_mais(View view) {
        tocarSom(view, R.raw.som_pedidos_mais);
    }

    public void som_pedidos_menos(View view) {
        tocarSom(view, R.raw.som_pedidos_menos);
    }

    public void som_pedidos_pare(View view) {
        tocarSom(view, R.raw.som_pedidos_pare);
    }

    public void som_pedidos_ajuda(View view) {
        tocarSom(view, R.raw.som_pedidos_ajuda);
    }

    public void som_pedidos_desculpa(View view) {
        tocarSom(view, R.raw.som_pedidos_desculpa);
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