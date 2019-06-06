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

public class AdapterSinopse extends BaseAdapter {

    private Context context;
    private List<Filme> listFilmes;
    private Filme filme;
    private LayoutInflater inflater;

    public AdapterSinopse(final Filme filme) {
        this.filme = filme;
    }

    @Override
    public int getCount() {
        return this.listFilmes.size();
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
                    inflate(R.layout.activity_sinopse,
                            viewGroup, false);
        }

        TextView tvSinopse, tvGenero, tvDuracao;

        tvSinopse = view.findViewById(R.id.tvSinopseFilme);
        tvGenero = view.findViewById(R.id.tvGeneroFilme);
        tvDuracao = view.findViewById(R.id.tvDuracaoFilme);

        tvSinopse.setText(filme.getSinopse());
        tvGenero.setText(filme.getGenero());
        tvDuracao.setText(filme.getDuracao());

        return view;

    }

}
