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

/**
 * Created by Miguel Wolf on 20/11/2016.
 */

public class MainAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<ListMain> itens;

    public MainAdapter(Context context, List<ListMain> itens) {
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
        ViewHolder itemHolder;
        //se a view estiver nula (nunca criada), inflamos o layout nela.
        if (view == null) {
            //infla o layout para podermos pegar as views
            view = mInflater.inflate(R.layout.adapter_main, null);

            //cria um item de suporte para não precisarmos sempre
            //inflar as mesmas informacoes
            itemHolder = new ViewHolder();
            itemHolder.imgBackground = ((ImageView) view.findViewById(R.id.adapter_main_iv_backgorund));
            itemHolder.imgIcon = ((ImageView) view.findViewById(R.id.adapter_main_iv_surface_image));
            itemHolder.tvLegenda = (TextView) view.findViewById(R.id.adapter_main_tv_legenda);

            //define os itens na view;
            view.setTag(itemHolder);

        } else {
            //se a view já existe pega os itens.
            itemHolder = (ViewHolder) view.getTag();
        }

        //pega os dados da lista
        //e define os valores nos itens.
        ListMain listMain = itens.get(position);
        itemHolder.imgBackground.setImageResource(listMain.getBackground());
        itemHolder.imgIcon.setImageResource(listMain.getIcon());
        itemHolder.tvLegenda.setText(listMain.getLegenda());

        //retorna a view com as informações
        return view;
    }

    /**
     * Classe de suporte para os itens do layout.
     */
    private class ViewHolder {
        ImageView imgIcon;
        ImageView imgBackground;
        TextView tvLegenda;
    }
}
