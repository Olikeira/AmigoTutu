package br.com.unisagrado.amigotutu;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import java.util.HashSet;
import java.util.Set;
import android.util.Log;

public class MainActivity_favoritos extends AppCompatActivity {

    private LinearLayout favoritesLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_favoritos);

        favoritesLayout = findViewById(R.id.favoritesLayout);

        // Configura o botão de voltar
        ImageButton btn_voltar_favoritos = findViewById(R.id.btn_voltar_favoritos);
        btn_voltar_favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_favoritos.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Carrega os favoritos
        loadFavorites();
    }

    private void loadFavorites() {
        SharedPreferences prefs = getSharedPreferences("favorites1", MODE_PRIVATE);
        Set<String> favorites = prefs.getStringSet("favorites_set1", new HashSet<>());



        // Limpa os favoritos existentes
        favoritesLayout.removeAllViews();

        // Verifica se há favoritos armazenados
        if (favorites.isEmpty()) {
            Log.d("LoadFavorites", "Nenhum favorito armazenado.");
            return;
        }

        Log.d("LoadFavorites", "Favoritos armazenados: " + favorites.toString());

        for (final String buttonName : favorites) {
            Log.d("LoadFavorites", "Carregando favorito: " + buttonName);

            // Infla a view do botão favorito
            View favoriteView = getLayoutInflater().inflate(R.layout.favorite_button_layout, null);

            // Encontra o ImageButton e define a imagem correspondente ao favorito
            ImageButton favoriteButton = favoriteView.findViewById(R.id.favorite_button);
            int buttonResId = getResources().getIdentifier(buttonName, "drawable", getPackageName());

            // Verifica se o recurso existe antes de definir a imagem
            if (buttonResId != 0) {
                favoriteButton.setImageResource(buttonResId);
            } else {
                Log.e("LoadFavorites", "Recurso drawable não encontrado: " + buttonName);
                continue; // Pula a adição desta view se o recurso não for encontrado
            }

            // Define o comportamento de longo clique para remover o favorito
            favoriteButton.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    showRemoveFromFavoritesDialog(buttonName);
                    return true;
                }
            });

            // Define o comportamento de clique para redirecionar para a atividade correspondente
            favoriteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    redirectToActivity(buttonName);
                }
            });

            // Adiciona a view ao layout de favoritos
            favoritesLayout.addView(favoriteView);
        }
    }


    private void removeFromFavorites(String buttonName) {
        SharedPreferences prefs = getSharedPreferences("favorites1", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Set<String> favorites = prefs.getStringSet("favorites_set1", new HashSet<>());

        if (favorites.contains(buttonName)) {
            favorites.remove(buttonName);
            editor.putStringSet("favorites_set1", favorites);
            editor.apply();
            Log.d("Favorites", "Removido dos favoritos: " + buttonName);
            Log.d("Favorites", "Favoritos atuais: " + favorites.toString());

            // Se não houver mais favoritos, voltar ao layout original
            if (favorites.isEmpty()) {
                // Limpa todos os favoritos existentes
                favoritesLayout.removeAllViews();

                // Infla e adiciona a view do layout original
                View originalView = getLayoutInflater().inflate(R.layout.favorite_button_layout, null);
                favoritesLayout.addView(originalView);
            }
        }
    }

    private void redirectToActivity(String buttonName) {
        // Arrays de IDs de botões e classes de atividades correspondentes
        int[] buttonIds = {
                R.id.btn_menu, R.id.btn_diadia, R.id.btn_refeicao, R.id.btn_bebidas,
                R.id.btn_frutas, R.id.btn_doces, R.id.btn_pedidos, R.id.btn_comentarios,
                R.id.btn_saudacoes, R.id.btn_necessidades, R.id.btn_dor, R.id.btn_roupas,
                R.id.btn_familia, R.id.btn_expressoes, R.id.btn_lugares, R.id.btn_brincar,
                R.id.btn_atividade, R.id.btn_animais, R.id.btn_cores, R.id.btn_numeros,
                R.id.btn_alfabeto
        };

        Class<?>[] activityClasses = {
                MainActivity_acessomenu.class, MainActivity_favoritos.class, MainActivity_refeicao.class,
                MainActivity_bebidas.class, MainActivity_frutas.class, MainActivity_doces.class,
                MainActivity_pedidos.class, MainActivity_comentarios.class, MainActivity_saudacoes.class,
                MainActivity_necessidades.class, MainActivity_dor.class, MainActivity_roupas.class,
                MainActivity_familia.class, MainActivity_expressoes.class, MainActivity_lugares.class,
                MainActivity_brincar.class, MainActivity_atividade.class, MainActivity_animais.class,
                MainActivity_cores.class, MainActivity_numeros.class, MainActivity_alfabeto.class
        };

        // Encontrar o índice do buttonName no array buttonIds
        int index = -1;
        for (int i = 0; i < buttonIds.length; i++) {
            String resName = getResources().getResourceEntryName(buttonIds[i]);
            if (resName.equals(buttonName)) {
                index = i;
                break;
            }
        }

        // Se o índice foi encontrado, iniciar a atividade correspondente
        if (index != -1) {
            Intent intent = new Intent(MainActivity_favoritos.this, activityClasses[index]);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Atividade não encontrada", Toast.LENGTH_SHORT).show();
        }
    }

    private void showRemoveFromFavoritesDialog(final String buttonName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Remover dos Favoritos")
                .setMessage("Deseja remover este item dos favoritos?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        removeFromFavorites(buttonName); // Remove o botão dos favoritos
                        Toast.makeText(MainActivity_favoritos.this, "Removido dos favoritos", Toast.LENGTH_SHORT).show();
                        loadFavorites(); // Recarrega a lista de favoritos
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
