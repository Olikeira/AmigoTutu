package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_brincar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_brincar);

        ImageButton btn_voltar_brincar = findViewById(R.id.btn_voltar_brincar);
        btn_voltar_brincar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_brincar.this, MainActivity.class);
                intent.putExtra("scrollToDiversao", true);
                startActivity(intent);
            }
        });
    }

    private MediaPlayer mediaPlayer;

    public void som_brincar_querbrincar(View view) {
        tocarSom(view, R.raw.som_brincar_querbrincar);
    }

    public void som_brincar_bola(View view) {
        tocarSom(view, R.raw.som_brincar_bola);
    }

    public void som_brincar_carrinho(View view) {
        tocarSom(view, R.raw.som_brincar_carrinho);
    }

    public void som_brincar_boneca(View view) {
        tocarSom(view, R.raw.som_brincar_boneca);
    }

    public void som_brincar_bicicleta(View view) {
        tocarSom(view, R.raw.som_brincar_bicicleta);
    }

    public void som_brincar_piscina(View view) {
        tocarSom(view, R.raw.som_brincar_piscina);
    }

    public void som_brincar_televisao(View view) {
        tocarSom(view, R.raw.som_brincar_televisao);
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