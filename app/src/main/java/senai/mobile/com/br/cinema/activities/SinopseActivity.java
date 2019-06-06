package senai.mobile.com.br.cinema.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import senai.mobile.com.br.cinema.R;

public class SinopseActivity extends AppCompatActivity {

    private ListView listViewDetalhesDoFilme;
    private List<HashMap<String, String>> listFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinopse);

        //listViewDetalhesDoFilme = findViewById(R.id.listViewDetalhesDoFilme);

    }

}
