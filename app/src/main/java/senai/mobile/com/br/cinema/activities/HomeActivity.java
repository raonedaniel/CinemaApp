package senai.mobile.com.br.cinema.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import senai.mobile.com.br.cinema.R;
import senai.mobile.com.br.cinema.model.Filme;
import senai.mobile.com.br.cinema.retrofit.RetrofitConfig;


public class HomeActivity extends AppCompatActivity {

    private ImageView imageView;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        autenticacao = FirebaseAuth.getInstance();

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
        }

        return super.onOptionsItemSelected(item);

    }

    private void abrirTelaDeSessao() {
        Intent intent = new Intent(HomeActivity.this, SessaoActivity.class);
        startActivity(intent);
    }

    private void deslogarUsuario() {

        autenticacao.signOut();

        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();

    }

    public void listarFilmes() {

        Call<List<Filme>> call = new RetrofitConfig().getFilmeService().list();
        call.enqueue(new Callback<List<Filme>>() {

            @Override
            public void onResponse(Call<List<Filme>> call, Response<List<Filme>> response) {
                List<Filme> filmes = response.body();

                for (Filme filme : filmes) {
                    System.out.println("Obj Filme [" + filme.toString() + "]");
                }

            }

            @Override
            public void onFailure(Call<List<Filme>> call, Throwable t) {
                Log.e("FilmeService   ", "Erro ao buscar o Filme:" + t.getMessage());
            }

        });

    }



//    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
//
//    public void add(View view) {
//        String[] from={"id", "nome"};
//        int[] to={R.id.txt_id, R.id.nomeFilme};
//        simpleListView=(ListView)findViewById(R.id.simpleListView);
//
//        HashMap m = new HashMap();
//
//        txtId = findViewById(R.id.txt_id);
//        txtCliente = findViewById(R.id.txt_cliente);
//
//        m.put("id", txtId.getText().toString());
//        m.put("cliente", txtCliente.getText().toString());
//        arrayList.add(m);
//        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.activity_item_pedido, from, to);
//        simpleListView.setAdapter(simpleAdapter);
//    }


}
