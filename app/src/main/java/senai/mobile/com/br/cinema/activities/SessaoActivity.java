package senai.mobile.com.br.cinema.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import senai.mobile.com.br.cinema.R;

public class SessaoActivity extends AppCompatActivity {

    Spinner sistemas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessao);
        sistemas = (Spinner) findViewById(R.id.Lançamento);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Tela_de_seções, android.R.layout.simple_spinner_item);
        sistemas.setAdapter(adapter);
    }
}
