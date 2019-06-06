package senai.mobile.com.br.cinema.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import senai.mobile.com.br.cinema.R;
import senai.mobile.com.br.cinema.activities.SinopseActivity;
import senai.mobile.com.br.cinema.model.Filme;

public class AdapterListaFilmes extends BaseAdapter {

    private Context context;
    private List<Filme> listFilmes;
    private LayoutInflater inflater;
    private  SinopseActivity sinopseActivity = new SinopseActivity();

    public AdapterListaFilmes(final Context context, final List<Filme> listFilmes) {
        this.context = context;
        this.listFilmes = listFilmes;
    }

    @Override
    public int getCount() {
        return this.listFilmes.size();
        //return this.listFilmes != null ? this.listFilmes.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return this.listFilmes.get(position);
    }

    private Filme parseItem(int i){
        return this.listFilmes.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(context).
                    inflate(R.layout.activity_listar_filmes,
                            viewGroup, false);
        }

        final Filme filme = parseItem(position);

        TextView tvNomeFilme = view.findViewById(R.id.tvNomeFilme);
        Button btnTelaSinopse = view.findViewById(R.id.btnTelaSinopse);

        tvNomeFilme.setText(filme.getNome());
        btnTelaSinopse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                AdapterSinopse adapterSinopse = new AdapterSinopse(filme);

                TextView tvSinopse, tvGenero, tvDuracao;

                tvSinopse = v.findViewById(R.id.tvSinopseFilme);
                tvGenero = v.findViewById(R.id.tvGeneroFilme);
                tvDuracao = v.findViewById(R.id.tvDuracaoFilme);

                tvSinopse.setText(filme.getSinopse());
                tvGenero.setText(filme.getGenero());
                tvDuracao.setText(filme.getDuracao());

                Intent intent = new Intent(context, SinopseActivity.class);
                context.startActivity(intent);

            }
        });

        return view;

    }

}
