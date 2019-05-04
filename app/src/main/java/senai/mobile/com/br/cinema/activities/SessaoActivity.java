package senai.mobile.com.br.cinema.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import senai.mobile.com.br.cinema.R;

public class SessaoActivity extends AppCompatActivity {


    Spinner sistemas;
    LinearLayout mainLayout;
    LinearLayout segundoLayout;
    LinearLayout terceiroLayout;
    LinearLayout quartoLayout;


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
        terceiroLayout = findViewById(R.id.terceiro_layout);
        quartoLayout = findViewById(R.id.quarto_layout);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // landscape
            mainLayout.setOrientation(LinearLayout.HORIZONTAL);
        }
        else {
            // portrait
            mainLayout.setOrientation(LinearLayout.VERTICAL);
        }
    }
}
