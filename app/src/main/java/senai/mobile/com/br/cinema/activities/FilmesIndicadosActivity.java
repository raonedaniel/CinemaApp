package senai.mobile.com.br.cinema.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import senai.mobile.com.br.cinema.R;
import senai.mobile.com.br.cinema.adapters.AdapterListaFilmesIndicados;
import senai.mobile.com.br.cinema.model.Filme;
import senai.mobile.com.br.cinema.retrofit.RetrofitConfig;

public class FilmesIndicadosActivity extends AppCompatActivity {

    private ListView listViewFilmesIndicados;
    private List<Filme> listFilmesIndicados;
    private AdapterListaFilmesIndicados adapterListaFilmesIndicados;
    private Button btnVoltarTelaHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmes_indicados);

        listViewFilmesIndicados = findViewById(R.id.listViewFilmesIndicados);
        btnVoltarTelaHome = findViewById(R.id.btnVoltarTelaHome);

        btnVoltarTelaHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FilmesIndicadosActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        listarFilmesIndicados();

    }


    private void listarFilmesIndicados() {

        Call<List<Filme>> call = new RetrofitConfig().getFilmeService().listIndicados();
        call.enqueue(new Callback<List<Filme>>() {

            @Override
            public void onResponse(Call<List<Filme>> call, Response<List<Filme>> response) {

                listFilmesIndicados = response.body();

                adapterListaFilmesIndicados = new AdapterListaFilmesIndicados(FilmesIndicadosActivity.this, listFilmesIndicados);

                listViewFilmesIndicados.setAdapter(adapterListaFilmesIndicados);

            }

            @Override
            public void onFailure(Call<List<Filme>> call, Throwable t) {
                Log.e("FilmeService   ", "Erro ao buscar o Filme:" + t.getMessage());
            }

        });
    }


}
