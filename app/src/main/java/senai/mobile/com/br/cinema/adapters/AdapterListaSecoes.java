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
import senai.mobile.com.br.cinema.activities.PagamentoActivity;
import senai.mobile.com.br.cinema.model.Secao;

public class AdapterListaSecoes extends BaseAdapter {

    private Context context;
    private List<Secao> listSecoes;
    private LayoutInflater inflater;

    public AdapterListaSecoes(final Context context, final List<Secao> listSecoes) {
        this.context = context;
        this.listSecoes = listSecoes;
    }

    @Override
    public int getCount() {
        return this.listSecoes.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listSecoes.get(position);
    }

    private Secao parseItem(int i){
        return this.listSecoes.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(context).
                    inflate(R.layout.activity_list_view_secoes,
                            viewGroup, false);
        }

        Secao secao = parseItem(position);

        TextView tvFilmeSecao = view.findViewById(R.id.tvFilmeSecao);
        TextView tvDataSecao = view.findViewById(R.id.tvDataSecao);
        TextView tvSalaSecao = view.findViewById(R.id.tvSalaSecao);
        Button btnComprarIngresso = view.findViewById(R.id.btnComprarIngresso);

        tvFilmeSecao.setText(secao.getNomeDoFilme());
        tvDataSecao.setText(secao.getData());
        tvSalaSecao.setText(secao.getNumeroDaSala());

        btnComprarIngresso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, PagamentoActivity.class);
                context.startActivity(intent);

            }
        });

        return view;
    }
}
