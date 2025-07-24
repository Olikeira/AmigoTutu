package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_roupas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_roupas);

        ImageButton btn_voltar_roupas = findViewById(R.id.btn_voltar_roupas);
        btn_voltar_roupas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_roupas.this, MainActivity.class);
                intent.putExtra("scrollToNecessidades", true);
                startActivity(intent);
            }
        });
    }

    private MediaPlayer mediaPlayer;

    public void som_roupas_camiseta(View view) {
        tocarSom(view, R.raw.som_roupas_camiseta);
    }

    public void som_roupas_blusa(View view) {
        tocarSom(view, R.raw.som_roupas_blusa);
    }

    public void som_roupas_calca(View view) {
        tocarSom(view, R.raw.som_roupas_calca);
    }

    public void som_roupas_bermuda(View view) {
        tocarSom(view, R.raw.som_roupas_bermuda);
    }

    public void som_roupas_vestido(View view) {
        tocarSom(view, R.raw.som_roupas_vestido);
    }

    public void som_roupas_saia(View view) {
        tocarSom(view, R.raw.som_roupas_saia);
    }

    public void som_roupas_calcinha(View view) {
        tocarSom(view, R.raw.som_roupas_calcinha);
    }

    public void som_roupas_cueca(View view) {
        tocarSom(view, R.raw.som_roupas_cueca);
    }

    public void som_roupas_chinelo(View view) {
        tocarSom(view, R.raw.som_roupas_chinelo);
    }

    public void som_roupas_tenis(View view) {
        tocarSom(view, R.raw.som_roupas_tenis);
    }

    public void som_roupas_meia(View view) {
        tocarSom(view, R.raw.som_roupas_meia);
    }

    public void som_roupas_luva(View view) {
        tocarSom(view, R.raw.som_roupas_luva);
    }

    public void som_roupas_bone(View view) {
        tocarSom(view, R.raw.som_roupas_bone);
    }

    public void som_roupas_chapeu(View view) {
        tocarSom(view, R.raw.som_roupas_chapeu);
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