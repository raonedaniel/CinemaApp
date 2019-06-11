package senai.mobile.com.br.cinema.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import senai.mobile.com.br.cinema.R;
import senai.mobile.com.br.cinema.model.Filme;

public class SinopseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinopse);

        /**
         * https://github.com/livroandroid/5ed/blob/master/capitulos/cap04-activity/HelloActivity/app/src/main/java/br/com/livroandroid/cap04_activity/MainActivity.java
         */

        TextView tvSinopse = findViewById(R.id.tvSinopseFilme);
        TextView tvGenero = findViewById(R.id.tvGeneroFilme);
        TextView tvDuracao = findViewById(R.id.tvDuracaoFilme);

        Bundle args = getIntent().getExtras();
        Filme filme = args.getParcelable("filme");

        tvSinopse.setText(filme.getSinopse());
        tvGenero.setText(filme.getGenero());
        tvDuracao.setText(filme.getDuracao());

        //TODO
        //https://stackoverflow.com/questions/20678669/how-to-maintain-session-in-android

    }

}
