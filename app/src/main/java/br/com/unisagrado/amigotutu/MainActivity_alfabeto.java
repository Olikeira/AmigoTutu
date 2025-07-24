package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_alfabeto extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_alfabeto);

        ImageButton btn_voltar_alfabeto = findViewById(R.id.btn_voltar_alfabeto);
        btn_voltar_alfabeto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_alfabeto.this, MainActivity.class);
                intent.putExtra("scrollToAprendizado", true);
                startActivity(intent);
            }
        });
    }

    private MediaPlayer mediaPlayer;

        public void som_alfabeto_a(View view) {
            tocarSom(view, R.raw.som_alfabeto_a);
        }

        public void som_alfabeto_b(View view) {
            tocarSom(view, R.raw.som_alfabeto_b);
        }

        public void som_alfabeto_c(View view) {
            tocarSom(view, R.raw.som_alfabeto_c);
        }

        public void som_alfabeto_d(View view) {
            tocarSom(view, R.raw.som_alfabeto_d);
        }

        public void som_alfabeto_e(View view) {
            tocarSom(view, R.raw.som_alfabeto_e);
        }

        public void som_alfabeto_f(View view) {
            tocarSom(view, R.raw.som_alfabeto_f);
        }

        public void som_alfabeto_g(View view) {
            tocarSom(view, R.raw.som_alfabeto_g);
        }

        public void som_alfabeto_h(View view) {
            tocarSom(view, R.raw.som_alfabeto_h);
        }

        public void som_alfabeto_i(View view) {
            tocarSom(view, R.raw.som_alfabeto_i);
        }

        public void som_alfabeto_j(View view) {
            tocarSom(view, R.raw.som_alfabeto_j);
        }

        public void som_alfabeto_k(View view) {
            tocarSom(view, R.raw.som_alfabeto_k);
        }

        public void som_alfabeto_l(View view) {
            tocarSom(view, R.raw.som_alfabeto_l);
        }

        public void som_alfabeto_m(View view) {
            tocarSom(view, R.raw.som_alfabeto_m);
        }

        public void som_alfabeto_n(View view) {
            tocarSom(view, R.raw.som_alfabeto_n);
        }

        public void som_alfabeto_o(View view) {
            tocarSom(view, R.raw.som_alfabeto_o);
        }

        public void som_alfabeto_p(View view) {
            tocarSom(view, R.raw.som_alfabeto_p);
        }

        public void som_alfabeto_q(View view) {
            tocarSom(view, R.raw.som_alfabeto_q);
        }

        public void som_alfabeto_r(View view) {
            tocarSom(view, R.raw.som_alfabeto_r);
        }

        public void som_alfabeto_s(View view) {
            tocarSom(view, R.raw.som_alfabeto_s);
        }

        public void som_alfabeto_t(View view) {
            tocarSom(view, R.raw.som_alfabeto_t);
        }

        public void som_alfabeto_u(View view) {
            tocarSom(view, R.raw.som_alfabeto_u);
        }

        public void som_alfabeto_v(View view) {
            tocarSom(view, R.raw.som_alfabeto_v);
        }

        public void som_alfabeto_w(View view) {
            tocarSom(view, R.raw.som_alfabeto_w);
        }

        public void som_alfabeto_x(View view) {
            tocarSom(view, R.raw.som_alfabeto_x);
        }

        public void som_alfabeto_y(View view) {
            tocarSom(view, R.raw.som_alfabeto_y);
        }

        public void som_alfabeto_z(View view) {
            tocarSom(view, R.raw.som_alfabeto_z);
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