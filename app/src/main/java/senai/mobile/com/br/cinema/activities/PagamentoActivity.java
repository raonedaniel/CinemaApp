package senai.mobile.com.br.cinema.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import senai.mobile.com.br.cinema.R;
import senai.mobile.com.br.cinema.dto.UsuarioDTO;
import senai.mobile.com.br.cinema.model.Ingresso;
import senai.mobile.com.br.cinema.model.Session;
import senai.mobile.com.br.cinema.retrofit.RetrofitConfig;

public class PagamentoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Session session;
    private Ingresso ingresso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        session = new Session(PagamentoActivity.this);

        Button btnEfetuarPagamentoInteira = findViewById(R.id.btnEfetuarPagamentoInteira);
        Button btnEfetuarPagamentoMeia = findViewById(R.id.btnEfetuarPagamentoMeia);

        btnEfetuarPagamentoInteira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                switch (v.getId()){
//                    case R.id.btnEfetuarPagamentoInteira:
//                        Toast.makeText(PagamentoActivity.this, "Pagamento Efetuado com Sucesso!", Toast.LENGTH_LONG).show();
//                        break;
//                }

                ingresso.setIdUsuario(session.getUsuario());
                ingresso.setIdSecao(session.getSecao());
                ingresso.setTipoIngresso("Meia");

            }
        });

        btnEfetuarPagamentoMeia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                switch (v.getId()){
//                    case R.id.btnEfetuarPagamentoMeia:
//                        Toast.makeText(PagamentoActivity.this, "Pagamento Efetuado com Sucesso!", Toast.LENGTH_LONG).show();
//                        break;
//                }

                ingresso.setIdUsuario(session.getUsuario());
                ingresso.setIdSecao(session.getSecao());
                ingresso.setTipoIngresso("Inteira");

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
                }

            }

            @Override
            public void onFailure(Call<Ingresso> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Erro na compra de ingressos", Toast.LENGTH_LONG).show();
            }

        });
    }

}
