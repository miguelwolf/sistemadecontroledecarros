package br.com.miguelwolf.sistemadecontroledecarros.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.miguelwolf.sistemadecontroledecarros.R;
import br.com.miguelwolf.sistemadecontroledecarros.model.ListMain;
import br.com.miguelwolf.sistemadecontroledecarros.model.ListReservas;

/**
 * Created by Miguel Wolf on 18/11/2016.
 */

public class ReservasAdapter extends BaseAdapter{

    private LayoutInflater mInflater;
    private List<ListReservas> itens;

    public ReservasAdapter(Context context, List<ListReservas> itens) {
        //Itens do listview
        this.itens = itens;
        //Objeto responsável por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int i) {
        return itens.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ReservasAdapter.ViewHolder itemHolder;
        //se a view estiver nula (nunca criada), inflamos o layout nela.
        if (view == null) {
            //infla o layout para podermos pegar as views
            view = mInflater.inflate(R.layout.adapter_reservas, null);

            //cria um item de suporte para não precisarmos sempre
            //inflar as mesmas informacoes
            itemHolder = new ReservasAdapter.ViewHolder();

            itemHolder.imgIcon = ((ImageView) view.findViewById(R.id.adapter_reservas_iv_usuario));
            itemHolder.tvModelo = ((TextView) view.findViewById(R.id.adapter_reservas_tv_modelo));
            itemHolder.tvPlaca = ((TextView) view.findViewById(R.id.adapter_reservas_tv_placa));
            itemHolder.tvData = ((TextView) view.findViewById(R.id.adapter_reservas_tv_data));

            //define os itens na view;
            view.setTag(itemHolder);

        } else {
            //se a view já existe pega os itens.
            itemHolder = (ReservasAdapter.ViewHolder) view.getTag();
        }

        //pega os dados da lista
        //e define os valores nos itens.
        ListReservas listReservas = itens.get(position);
        itemHolder.imgIcon.setImageResource(listReservas.getFoto());
        itemHolder.tvModelo.setText(listReservas.getModelo());
        itemHolder.tvPlaca.setText(listReservas.getPlaca());
        itemHolder.tvData.setText(listReservas.getData());

        //retorna a view com as informações
        return view;
    }

    /**
     * Classe de suporte para os itens do layout.
     */
    private class ViewHolder {
        ImageView imgIcon;
        TextView tvModelo;
        TextView tvPlaca;
        TextView tvData;
    }

}
