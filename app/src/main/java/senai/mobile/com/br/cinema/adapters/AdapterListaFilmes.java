package senai.mobile.com.br.cinema.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import senai.mobile.com.br.cinema.R;
import senai.mobile.com.br.cinema.model.Filme;

public class AdapterListaFilmes extends BaseAdapter {

    private Context context;
    private List<Filme> filmes;

    public AdapterListaFilmes(Context context, List<Filme> filmes) {
        this.context = context;
        this.filmes = filmes;
    }

    @Override
    public int getCount() {
        return this.filmes.size();
    }

    @Override
    public Object getItem(int position) {
        return this.filmes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = View.inflate(this.context, R.layout.activity_listar_filmes, null);

        TextView tvNomeFilme = (TextView) view.findViewById(R.id.tvNomeFilme);

        return view;

    }
}
