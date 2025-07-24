package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;

public class MainActivity_abertura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_abertura);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity_abertura.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000); // 2000 milissegundos (2seg)
    }
}