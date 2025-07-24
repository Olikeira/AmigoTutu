package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Set;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String buttonNameToAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "onCreate iniciado");

        setupButtonClickListeners();
        setupButtonLongClickListeners();
        setupButtonWithScrolling();

        Log.d("MainActivity", "onCreate finalizado");
    }

    private int[] buttonIds = {
            R.id.btn_menu, R.id.btn_diadia, R.id.btn_refeicao, R.id.btn_bebidas,
            R.id.btn_frutas, R.id.btn_doces, R.id.btn_pedidos, R.id.btn_comentarios,
            R.id.btn_saudacoes, R.id.btn_necessidades, R.id.btn_dor, R.id.btn_roupas,
            R.id.btn_familia, R.id.btn_expressoes, R.id.btn_lugares, R.id.btn_brincar,
            R.id.btn_atividade, R.id.btn_animais, R.id.btn_cores, R.id.btn_numeros,
            R.id.btn_alfabeto
    };

    private Class<?>[] activityClasses = {
            MainActivity_acessomenu.class, MainActivity_favoritos.class, MainActivity_refeicao.class,
            MainActivity_bebidas.class, MainActivity_frutas.class, MainActivity_doces.class,
            MainActivity_pedidos.class, MainActivity_comentarios.class, MainActivity_saudacoes.class,
            MainActivity_necessidades.class, MainActivity_dor.class, MainActivity_roupas.class,
            MainActivity_familia.class, MainActivity_expressoes.class, MainActivity_lugares.class,
            MainActivity_brincar.class, MainActivity_atividade.class, MainActivity_animais.class,
            MainActivity_cores.class, MainActivity_numeros.class, MainActivity_alfabeto.class
    };

    private void setupButtonClickListeners() {
        Log.d("MainActivity", "setupButtonClickListeners iniciado");

        for (int i = 0; i < buttonIds.length; i++) {
            final int index = i;
            findViewById(buttonIds[i]).setOnClickListener(v -> {
                Log.d("MainActivity", "Botão clicado: " + getResources().getResourceEntryName(buttonIds[index]));
                Intent intent = new Intent(MainActivity.this, activityClasses[index]);
                startActivity(intent);
            });
        }

        Log.d("MainActivity", "setupButtonClickListeners finalizado");
    }

    private void setupButtonLongClickListeners() {
        int[] buttonIds = {
                R.id.btn_menu, R.id.btn_refeicao, R.id.btn_bebidas,
                R.id.btn_frutas, R.id.btn_doces, R.id.btn_pedidos, R.id.btn_comentarios,
                R.id.btn_saudacoes, R.id.btn_necessidades, R.id.btn_dor, R.id.btn_roupas,
                R.id.btn_familia, R.id.btn_expressoes, R.id.btn_lugares, R.id.btn_brincar,
                R.id.btn_atividade, R.id.btn_animais, R.id.btn_cores, R.id.btn_numeros,
                R.id.btn_alfabeto
        };

        for (int buttonId : buttonIds) {
            findViewById(buttonId).setOnLongClickListener(v -> {
                buttonNameToAdd = getResources().getResourceEntryName(buttonId);
                showAddToFavoritesDialog();
                return true;
            });
        }
    }

    private void setupButtonWithScrolling() {
        final ScrollView scrollView = findViewById(R.id.scrollView);
        int[] tempButtonIds = {
                R.id.temp_favoritos, R.id.temp_alimentacao, R.id.temp_comunicacao,
                R.id.temp_necessidades, R.id.temp_emocoes, R.id.temp_lugares,
                R.id.temp_diversao, R.id.temp_aprendizado
        };

        int[] targetButtonIds = {
                R.id.favoritos, R.id.alimentacao, R.id.comunicacao, R.id.necessidades,
                R.id.emocoes, R.id.lugares, R.id.diversao, R.id.aprendizado
        };

        for (int i = 0; i < tempButtonIds.length; i++) {
            final View targetButton = findViewById(targetButtonIds[i]);
            findViewById(tempButtonIds[i]).setOnClickListener(v ->
                    scrollView.smoothScrollTo(0, targetButton.getTop())
            );
        }
    }

    private void showAddToFavoritesDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Adicionar aos Favoritos")
                .setMessage("Deseja adicionar este item aos favoritos?")
                .setPositiveButton("Sim", (dialog, which) -> {
                    addToFavorites(buttonNameToAdd);
                    Toast.makeText(MainActivity.this, "Adicionado aos favoritos", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Não", (dialog, which) -> dialog.dismiss())
                .create()
                .show();
    }

    private void addToFavorites(String buttonName) {
        SharedPreferences prefs = getSharedPreferences("favorites1", MODE_PRIVATE);
        Set<String> favorites = prefs.getStringSet("favorites_set1", new HashSet<>());

        // Verifica se o favorito já existe antes de adicionar
        if (favorites.contains(buttonName)) {
            Log.d("AddToFavorites", buttonName + " já" +
                    " está nos favoritos.");
        } else {
            favorites.add(buttonName);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putStringSet("favorites_set1", favorites);
            editor.apply();
            Log.d("AddToFavorites", buttonName + " foi adicionado aos favoritos.");
        }
    }
}
