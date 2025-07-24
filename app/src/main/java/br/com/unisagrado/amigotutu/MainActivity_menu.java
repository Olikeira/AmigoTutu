package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ImageButton btnFechar = findViewById(R.id.btn_fecharmenu);
        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_menu.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ImageButton btnCustom = findViewById(R.id.btn_personalizar);
        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_menu.this, MainActivity_custom.class);
                startActivity(intent);
            }
        });

        ImageButton btnContato = findViewById(R.id.btn_contato);
        btnContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_menu.this, MainActivity_contato.class);
                startActivity(intent);
            }
        });

        ImageButton btnSobre = findViewById(R.id.btn_sobre);
        btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_menu.this, MainActivity_sobre.class);
                startActivity(intent);
            }
        });
    }
}