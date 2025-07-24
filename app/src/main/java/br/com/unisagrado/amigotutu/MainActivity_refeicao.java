package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_refeicao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_refeicao);

        ImageButton btn_voltar_refeicao = findViewById(R.id.btn_voltar_refeicao);
        btn_voltar_refeicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criar uma intenção para retornar à MainActivity
                Intent intent = new Intent(MainActivity_refeicao.this, MainActivity.class);
                // Passar um sinal indicando que a rolagem suave até a visualização de alimentação deve ser realizada
                intent.putExtra("scrollToAlimentacao", true);
                // Iniciar a atividade MainActivity
                startActivity(intent);
            }
        });
    }

    private MediaPlayer mediaPlayer;

    public void som_refeicao_arroz(View view) {
        tocarSom(view, R.raw.som_refeicao_arroz);
    }

    public void som_refeicao_feijao(View view) {
        tocarSom(view, R.raw.som_refeicao_feijao);
    }

    public void som_refeicao_carne(View view) {
        tocarSom(view, R.raw.som_refeicao_carne);
    }

    public void som_refeicao_frango(View view) {
        tocarSom(view, R.raw.som_refeicao_frango);
    }

    public void som_refeicao_ovo(View view) {
        tocarSom(view, R.raw.som_refeicao_ovo);
    }

    public void som_refeicao_batatafrita(View view) {
        tocarSom(view, R.raw.som_refeicao_batatafrita);
    }

    public void som_refeicao_macarrao(View view) {
        tocarSom(view, R.raw.som_refeicao_macarrao);
    }

    public void som_refeicao_salsicha(View view) {
        tocarSom(view, R.raw.som_refeicao_salsicha);
    }

    public void som_refeicao_pizza(View view) {
        tocarSom(view, R.raw.som_refeicao_pizza);
    }

    public void som_refeicao_lanche(View view) {
        tocarSom(view, R.raw.som_refeicao_lanche);
    }

    public void som_refeicao_pao(View view) {
        tocarSom(view, R.raw.som_refeicao_pao);
    }

    public void som_refeicao_queijo(View view) {
        tocarSom(view, R.raw.som_refeicao_queijo);
    }

    public void som_refeicao_pipoca(View view) {
        tocarSom(view, R.raw.som_refeicao_pipoca);
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
