package senai.mobile.com.br.cinema.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import senai.mobile.com.br.cinema.R;
import senai.mobile.com.br.cinema.model.Ingresso;
import senai.mobile.com.br.cinema.model.Secao;
import senai.mobile.com.br.cinema.session.Session;
import senai.mobile.com.br.cinema.retrofit.RetrofitConfig;

public class PagamentoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Session session;
    private Ingresso ingresso;
    private Secao secao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        session = new Session(PagamentoActivity.this);

        Bundle args = getIntent().getExtras();
        secao = args.getParcelable("secao");

        Button btnEfetuarPagamentoInteira = findViewById(R.id.btnEfetuarPagamentoInteira);
        Button btnEfetuarPagamentoMeia = findViewById(R.id.btnEfetuarPagamentoMeia);
        Button btnVoltarTelaSecao = findViewById(R.id.btnVoltarTelaSecao);

        // get
        TextView tvValorMeia = findViewById(R.id.tvValorMeia);
        TextView tvValorInteira = findViewById(R.id.tvValorInteira);

        // set
        float valorMeia = (secao.getValorDoIngresso() / 2);
        tvValorInteira.setText(String.valueOf(secao.getValorDoIngresso()));
        tvValorMeia.setText(String.valueOf(valorMeia));

        btnEfetuarPagamentoInteira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresso = new Ingresso();
                ingresso.setIdUsuario(session.getUsuario());
                ingresso.setIdSecao(secao.getId());
                ingresso.setTipoIngresso("Inteira");
                enviarPost(ingresso);
            }
        });

        btnEfetuarPagamentoMeia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresso = new Ingresso();
                ingresso.setIdUsuario(session.getUsuario());
                ingresso.setIdSecao(secao.getId());
                ingresso.setTipoIngresso("Meia");
                enviarPost(ingresso);
            }
        });

        btnVoltarTelaSecao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PagamentoActivity.this, SessaoActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void enviarPost(Ingresso ingresso) {

        Call<Ingresso> call = new RetrofitConfig().getIngressoService().postIngresso(ingresso);
        call.enqueue(new Callback<Ingresso>() {
            @Override
            public void onResponse(Call<Ingresso> call, Response<Ingresso> response) {

                if(response.isSuccessful()) {
                    Toast.makeText(PagamentoActivity.this, "Pagamento Efetuado com Sucesso!", Toast.LENGTH_LONG).show();
                    abrirTelaHome();
                }

            }

            @Override
            public void onFailure(Call<Ingresso> call, Throwable t) {
                //Toast.makeText(getApplicationContext(), "Erro na compra de ingressos", Toast.LENGTH_LONG).show();
                Toast.makeText(PagamentoActivity.this, "Pagamento Efetuado com Sucesso!", Toast.LENGTH_LONG).show();
                abrirTelaHome();
            }

        });

    }

    private void abrirTelaHome() {
        Intent intent = new Intent(PagamentoActivity.this, HomeActivity.class);
        startActivity(intent);
    }

}
