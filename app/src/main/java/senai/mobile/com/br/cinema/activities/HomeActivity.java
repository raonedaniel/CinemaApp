package senai.mobile.com.br.cinema.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import senai.mobile.com.br.cinema.R;
import senai.mobile.com.br.cinema.adapters.AdapterListaFilmes;
import senai.mobile.com.br.cinema.model.Filme;
import senai.mobile.com.br.cinema.retrofit.RetrofitConfig;

public class HomeActivity extends AppCompatActivity {

    private ListView listViewFilmes;
    private Button btnTelaSinopse;
    private List<Filme> listFilmes;
    private AdapterListaFilmes adapterListaFilmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listViewFilmes = findViewById(R.id.listViewFilmes);
        btnTelaSinopse = findViewById(R.id.btnTelaSinopse);

        listarFilmes();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_app, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_sessao) {
            abrirTelaDeSessao();
        } else if (id == R.id.action_sair) {
            deslogarUsuario();
        } else if (id == R.id.action_filmes_indicados) {
            filmesIndicados();
        }

        return super.onOptionsItemSelected(item);

    }

    private void abrirTelaDeSessao() {
        Intent intent = new Intent(HomeActivity.this, SessaoActivity.class);
        startActivity(intent);
    }

    private void deslogarUsuario() {

        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        startActivity(intent);

    }

    private void filmesIndicados() {

        Intent intent = new Intent(HomeActivity.this, FilmesIndicadosActivity.class);
        startActivity(intent);

    }

    private void listarFilmes() {

        Call<List<Filme>> call = new RetrofitConfig().getFilmeService().list();
        call.enqueue(new Callback<List<Filme>>() {

            @Override
            public void onResponse(Call<List<Filme>> call, Response<List<Filme>> response) {

                listFilmes = response.body();

                adapterListaFilmes = new AdapterListaFilmes(HomeActivity.this, listFilmes);

                listViewFilmes.setAdapter(adapterListaFilmes);

            }

            @Override
            public void onFailure(Call<List<Filme>> call, Throwable t) {
                Log.e("FilmeService   ", "Erro ao buscar o Filme:" + t.getMessage());
            }

        });
    }

}
