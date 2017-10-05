package br.com.miguelwolf.sistemadecontroledecarros.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.miguelwolf.sistemadecontroledecarros.R;
import br.com.miguelwolf.sistemadecontroledecarros.adapter.MainAdapter;
import br.com.miguelwolf.sistemadecontroledecarros.dao.Sessao;
import br.com.miguelwolf.sistemadecontroledecarros.model.ListMain;

public class ActivityMain extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ArrayList<ListMain> itens;
    private ListView listView;

    private static final int AGENDA = 0;
    private static final int FUNCIONARIO = 1;
    private static final int VEICULO = 2;
    private static final int HISTORICO = 3;
    private static final int RESERVA = 4;
    private static final int REGISTRAR = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.main_lv_lista_menu);
        listView.setOnItemClickListener(this);

        criarLista();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_configuracoes) {
            return true;

        }  else if (id == R.id.action_criar_empresa) {
            startActivity(new Intent(ActivityMain.this, ActivityEmpresaCadastrar.class));
            return true;

        }  else if (id == R.id.action_deslogar) {
            startActivity(new Intent(ActivityMain.this, ActivityLogin.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void criarLista(){
        //Criamos nossa lista que preenchera o ListView
        itens = new ArrayList<ListMain>();

        if (Sessao.getPermissao() == 1) {
//        AGENDA = 0
            itens.add(new ListMain(R.drawable.agenda_wallpaper, R.drawable.ic_event_white_36dp, "Agenda"));
//        FUNCIONARIO = 1
            itens.add(new ListMain(R.drawable.funcionario_wallpaper, R.drawable.ic_account_circle_white_36dp, "Funcionário"));
//        VEICULO = 2
            itens.add(new ListMain(R.drawable.carro_wallpaper, R.drawable.ic_directions_car_white_36dp, "Veículo"));
//        RELATÓRIOS = 5
            itens.add(new ListMain(R.drawable.registrar_wallpaper, R.drawable.ic_playlist_add_check_white_36dp, "Relatórios"));
        }
//        RESERVA = 4
        itens.add(new ListMain(R.drawable.reserva_wallpaper, R.drawable.ic_event_note_white_36dp, "Reserva"));
//        HISTORICO = 3
        itens.add(new ListMain(R.drawable.historico_wallpaper, R.drawable.ic_timeline_white_36dp, "Histórico"));

        //Cria o adapter
        MainAdapter mainAdapter = new MainAdapter(this, itens);

        //Define o Adapter
        listView.setAdapter(mainAdapter);

        //Cor quando a lista é selecionada para ralagem.
//        listView.setCacheColorHint(Color.TRANSPARENT);
    }

    @Override
    public void onClick(View view) {
        int acao = view.getId();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        if (i == AGENDA)
            startActivity(new Intent(ActivityMain.this, ActivityAgendar.class));

        else if (i == FUNCIONARIO) {
            Intent it = new Intent(ActivityMain.this, ActivityCadasUsuario.class);
            it.putExtra("cadastrar", true);
            startActivity(it);

        }else if (i == VEICULO)
            startActivity(new Intent(ActivityMain.this, ActivityListaVeiculos.class));

        else if (i == HISTORICO)
            startActivity(new Intent(ActivityMain.this, ActivityListaVeiculos.class));

        else if (i == RESERVA)
            startActivity(new Intent(ActivityMain.this, ActivityReservasLista.class));

        else if (i == REGISTRAR)
            startActivity(new Intent(ActivityMain.this, ActivityListaVeiculos.class));

    }
}
