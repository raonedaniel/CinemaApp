package senai.mobile.com.br.cinema.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import senai.mobile.com.br.cinema.R;

public class PagamentoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        Button btnEfetuarPagamentoInteira = findViewById(R.id.btnEfetuarPagamentoInteira);
        Button btnEfetuarPagamentoMeia = findViewById(R.id.btnEfetuarPagamentoMeia);

        btnEfetuarPagamentoInteira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnEfetuarPagamentoInteira:
                        Toast.makeText(PagamentoActivity.this, "Pagamento Efetuado com Sucesso!", Toast.LENGTH_LONG).show();
                        break;
                }

            }
        });

        btnEfetuarPagamentoMeia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnEfetuarPagamentoMeia:
                        Toast.makeText(PagamentoActivity.this, "Pagamento Efetuado com Sucesso!", Toast.LENGTH_LONG).show();
                        break;
                }

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

}
