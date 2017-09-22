package br.com.miguelwolf.sistemadecontroledecarros.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.miguelwolf.sistemadecontroledecarros.R;
import br.com.miguelwolf.sistemadecontroledecarros.adapter.CarrosAdapter;
import br.com.miguelwolf.sistemadecontroledecarros.model.ListVeiculos;

public class ActivityListaVeiculos extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<ListVeiculos> itens;
    private ListView listView;

    private static final int COROLLA = 0;
    private static final int JETTA = 1;
    private static final int UNO = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_veiculos);

        listView = (ListView) findViewById(R.id.lista_carros_lv_lista);
        listView.setOnItemClickListener(this);

        criarLista();

    }

    private void criarLista() {
        //Criamos nossa lista que preenchera o ListView
        itens = new ArrayList<ListVeiculos>();

//        COROLLA = 0
        itens.add(new ListVeiculos(R.drawable.corolla, "Toyota Corolla", "PJX-5637"));
//        JETTA = 1
        itens.add(new ListVeiculos(R.drawable.carro_wallpaper, "Volkswagen Jetta", "MWB-4532"));
//        UNO = 2
        itens.add(new ListVeiculos(R.drawable.uno, "Fiat Uno", "STJ-2425"));

        //Cria o adapter
        CarrosAdapter carrosAdapter = new CarrosAdapter(this, itens);

        //Define o Adapter
        listView.setAdapter(carrosAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (i == COROLLA) {
            Intent intent = new Intent(ActivityListaVeiculos.this, ActivityCadastrarVeiculos.class);
            intent.putExtra(ActivityCadastrarVeiculos.CADASTRAR, false);
            startActivity(intent);

        } else if (i == JETTA) {
            Intent intent = new Intent(ActivityListaVeiculos.this, ActivityHistoricoVeiculoCadastrar.class);
            intent.putExtra(ActivityHistoricoVeiculoCadastrar.CADASTRAR, false);
            startActivity(intent);

        } else if (i == UNO) {

            Intent intent = new Intent(ActivityListaVeiculos.this, ActivityRegistrar.class);
            intent.putExtra(ActivityRegistrar.CADASTRAR, false);
            startActivity(intent);

//            Intent intent = new Intent(ActivityListaVeiculos.this, ActivityReservasDetalhe.class);
//            intent.putExtra(ActivityReservasDetalhe.CADASTRAR, false);
//            startActivity(intent);

        }
    }
}
