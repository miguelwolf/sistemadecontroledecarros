package br.com.miguelwolf.sistemadecontroledecarros.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.miguelwolf.sistemadecontroledecarros.R;
import br.com.miguelwolf.sistemadecontroledecarros.adapter.CarrosAdapter;
import br.com.miguelwolf.sistemadecontroledecarros.adapter.ReservasAdapter;
import br.com.miguelwolf.sistemadecontroledecarros.model.ListReservas;
import br.com.miguelwolf.sistemadecontroledecarros.model.ListVeiculos;

public class ActivityReservasLista extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<ListReservas> itens;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_reservar);

        listView = (ListView) findViewById(R.id.lista_reservar_lv_lista);
        listView.setOnItemClickListener(this);

        criarLista();

    }

    private void criarLista() {
        //Criamos nossa lista que preenchera o ListView
        itens = new ArrayList<ListReservas>();

//        COROLLA = 0
        itens.add(new ListReservas(R.drawable.usuario, "Fiat uno", "STJ-2425", "08/12/2016 - 07:00~14:00"));

        //Cria o adapter
        ReservasAdapter reservasAdapter = new ReservasAdapter(this, itens);

        //Define o Adapter
        listView.setAdapter(reservasAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (i == 0) {
            startActivity(new Intent(ActivityReservasLista.this, ActivityReservasDetalhe.class));

        }
    }
}
