package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_animais extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_animais);

        ImageButton btn_voltar_animais = findViewById(R.id.btn_voltar_animais);
        btn_voltar_animais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_animais.this, MainActivity.class);
                intent.putExtra("scrollToAprendizado", true);
                startActivity(intent);
            }
        });
    }

    private MediaPlayer mediaPlayer;

    public void som_animais_cachorro(View view) {
        tocarSom(view, R.raw.som_animais_cachorro);
    }

    public void som_animais_gato(View view) {
        tocarSom(view, R.raw.som_animais_gato);
    }

    public void som_animais_passaro(View view) {
        tocarSom(view, R.raw.som_animais_passaro);
    }

    public void som_animais_peixe(View view) {
        tocarSom(view, R.raw.som_animais_peixe);
    }

    public void som_animais_cavalo(View view) {
        tocarSom(view, R.raw.som_animais_cavalo);
    }

    public void som_animais_vaca(View view) {
        tocarSom(view, R.raw.som_animais_vaca);
    }

    public void som_animais_galinha(View view) {
        tocarSom(view, R.raw.som_animais_galinha);
    }

    public void som_animais_coelho(View view) {
        tocarSom(view, R.raw.som_animais_coelho);
    }

    public void som_animais_sapo(View view) {
        tocarSom(view, R.raw.som_animais_sapo);
    }

    public void som_animais_abelha(View view) {
        tocarSom(view, R.raw.som_animais_abelha);
    }

    public void som_animais_borboleta(View view) {
        tocarSom(view, R.raw.som_animais_borboleta);
    }

    public void som_animais_formiga(View view) {
        tocarSom(view, R.raw.som_animais_formiga);
    }

    public void som_animais_urso(View view) {
        tocarSom(view, R.raw.som_animais_urso);
    }

    public void som_animais_jacare(View view) {
        tocarSom(view, R.raw.som_animais_jacare);
    }

    public void som_animais_tartaruga(View view) {
        tocarSom(view, R.raw.som_animais_tartaruga);
    }

    public void som_animais_macaco(View view) {
        tocarSom(view, R.raw.som_animais_macaco);
    }

    public void som_animais_leao(View view) {
        tocarSom(view, R.raw.som_animais_leao);
    }

    public void som_animais_zebra(View view) {
        tocarSom(view, R.raw.som_animais_zebra);
    }

    public void som_animais_girafa(View view) {
        tocarSom(view, R.raw.som_animais_girafa);
    }

    public void som_animais_elefante(View view) {
        tocarSom(view, R.raw.som_animais_elefante);
    }

    public void som_animais_hipopotamo(View view) {
        tocarSom(view, R.raw.som_animais_hipopotamo);
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