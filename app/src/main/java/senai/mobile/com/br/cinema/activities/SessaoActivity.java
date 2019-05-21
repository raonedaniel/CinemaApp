package senai.mobile.com.br.cinema.activities;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import senai.mobile.com.br.cinema.R;
import senai.mobile.com.br.cinema.model.Sessao;
import senai.mobile.com.br.cinema.retrofit.RetrofitConfig;

public class SessaoActivity extends AppCompatActivity {

    Spinner sistemas;
    LinearLayout mainLayout;
    LinearLayout segundoLayout;
    //LinearLayout terceiroLayout;
    //LinearLayout quartoLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessao);

        sistemas = (Spinner) findViewById(R.id.Lançamento);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Tela_de_seções, android.R.layout.simple_spinner_item);
        sistemas.setAdapter(adapter);

        sistemas = (Spinner) findViewById(R.id.Lançamentos);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.Tela_de_seções, android.R.layout.simple_spinner_item);
        sistemas.setAdapter(adapter);

        sistemas = (Spinner) findViewById(R.id.Aventura);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.Tela_de_seções, android.R.layout.simple_spinner_item);
        sistemas.setAdapter(adapter);


        mainLayout = findViewById(R.id.main_layout);
        segundoLayout = findViewById(R.id.segundo_layout);
        //terceiroLayout = findViewById(R.id.terceiro_layout);
        //quartoLayout = findViewById(R.id.quarto_layout);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // landscape
            mainLayout.setOrientation(LinearLayout.HORIZONTAL);
        }
        else {
            // portrait
            mainLayout.setOrientation(LinearLayout.VERTICAL);
        }

        //listarSessoes();


    }

    public void listarSessoes() {

        Call<List<Sessao>> call = new RetrofitConfig().getSessaoService().list();
        call.enqueue(new Callback<List<Sessao>>() {

            @Override
            public void onResponse(Call<List<Sessao>> call, Response<List<Sessao>> response) {
                List<Sessao> sessoes = response.body();

                for (Sessao sessao : sessoes) {
                    System.out.println("Obj Sessao [" + sessao.toString() + "]");
                }

            }

            @Override
            public void onFailure(Call<List<Sessao>> call, Throwable t) {
                Log.e("FilmeService   ", "Erro ao buscar a Sessao:" + t.getMessage());
            }

        });

    }




}
