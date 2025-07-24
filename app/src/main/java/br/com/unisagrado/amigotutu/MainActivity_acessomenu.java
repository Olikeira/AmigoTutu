package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_acessomenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_acessomenu);

        ImageButton btnAMenu = findViewById(R.id.btn_acesso_menu);
        btnAMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_acessomenu.this, MainActivity_menu.class);
                startActivity(intent);
            }
        });

        ImageButton btnVoltar = findViewById(R.id.btn_voltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_acessomenu.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}