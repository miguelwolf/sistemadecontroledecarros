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
import br.com.miguelwolf.sistemadecontroledecarros.model.ListVeiculos;

/**
 * Created by Miguel Wolf on 18/11/2016.
 */

public class CarrosAdapter extends BaseAdapter{

    private LayoutInflater mInflater;
    private List<ListVeiculos> itens;

    public CarrosAdapter(Context context, List<ListVeiculos> itens) {
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
        CarrosAdapter.ViewHolder itemHolder;
        //se a view estiver nula (nunca criada), inflamos o layout nela.
        if (view == null) {
            //infla o layout para podermos pegar as views
            view = mInflater.inflate(R.layout.adapter_carros, null);

            //cria um item de suporte para não precisarmos sempre
            //inflar as mesmas informacoes
            itemHolder = new CarrosAdapter.ViewHolder();
            itemHolder.imgFoto = ((ImageView) view.findViewById(R.id.adapter_carros_iv));
            itemHolder.tvModelo = ((TextView) view.findViewById(R.id.adapter_carros_tv_titulo));
            itemHolder.tvPlaca = ((TextView) view.findViewById(R.id.adapter_carros_tv_placa));


            //define os itens na view;
            view.setTag(itemHolder);

        } else {
            //se a view já existe pega os itens.
            itemHolder = (CarrosAdapter.ViewHolder) view.getTag();
        }

        //pega os dados da lista
        //e define os valores nos itens.
        ListVeiculos listVeiculos = itens.get(position);
        itemHolder.imgFoto.setImageResource(listVeiculos.getFoto());
        itemHolder.tvModelo.setText(listVeiculos.getModelo());
        itemHolder.tvPlaca.setText(listVeiculos.getPlaca());

        //retorna a view com as informações
        return view;
    }

    /**
     * Classe de suporte para os itens do layout.
     */
    private class ViewHolder {
        ImageView imgFoto;
        TextView tvModelo;
        TextView tvPlaca;
    }

}
