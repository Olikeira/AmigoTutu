package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity_contato extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contato);

        ImageButton email_sugestao = findViewById(R.id.btn_sugestao);
        email_sugestao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destinatario = {"sugestoes.tutu@gmail.com"};
                String assunto = "Sugestão de Melhoria";
                String mensagem = "Olá! Gostaria de compartilhar uma sugestão de melhoria...";

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, destinatario);
                intent.putExtra(Intent.EXTRA_SUBJECT, assunto);
                intent.putExtra(Intent.EXTRA_TEXT, mensagem);
                startActivity(Intent.createChooser(intent, "Enviar e-mail"));
            }
        });

        ImageButton email_erro = findViewById(R.id.btn_erro);
        email_erro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destinatario = {"erro.tutu@gmail.com"};
                String assunto = "Reportar Erro";
                String mensagem = "Olá! Gostaria de informar um erro no app...";

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, destinatario);
                intent.putExtra(Intent.EXTRA_SUBJECT, assunto);
                intent.putExtra(Intent.EXTRA_TEXT, mensagem);
                startActivity(Intent.createChooser(intent, "Enviar e-mail"));
            }
        });

        ImageButton btnFechar = findViewById(R.id.btn_fechar_contato);
        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_contato.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}