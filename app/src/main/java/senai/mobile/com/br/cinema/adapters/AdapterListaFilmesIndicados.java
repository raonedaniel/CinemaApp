package senai.mobile.com.br.cinema.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

public class AdapterListaFilmesIndicados extends BaseAdapter {

    private Context context;
    private List<Filme> listFilmes;
    private LayoutInflater inflater;

    public AdapterListaFilmesIndicados(final Context context, final List<Filme> listFilmes) {
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
                    inflate(R.layout.activity_listar_filmes_indicados,
                            viewGroup, false);
        }

        final Filme filme = parseItem(position);

        TextView tvNomeFilme = view.findViewById(R.id.tvNomeFilmeIndicado);

        tvNomeFilme.setText(filme.getNome());

        return view;

    }

}
