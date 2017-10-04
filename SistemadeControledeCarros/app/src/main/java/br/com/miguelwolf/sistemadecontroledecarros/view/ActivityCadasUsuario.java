package br.com.miguelwolf.sistemadecontroledecarros.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import br.com.miguelwolf.sistemadecontroledecarros.R;
import br.com.miguelwolf.sistemadecontroledecarros.dao.FuncaoDAO;
import br.com.miguelwolf.sistemadecontroledecarros.dao.LoginDAO;
import br.com.miguelwolf.sistemadecontroledecarros.model.Funcao;
import br.com.miguelwolf.sistemadecontroledecarros.model.Login;
import br.com.miguelwolf.sistemadecontroledecarros.model.Pessoa;

public class ActivityCadasUsuario extends AppCompatActivity implements View.OnClickListener{

    private AutoCompleteTextView txtNome;
    private AutoCompleteTextView txtLogin;
    private AutoCompleteTextView txtSenhaAntiga;
    private AutoCompleteTextView txtSenhaNova;
    private AutoCompleteTextView txtSenhaNovaNovamente;

    private ArrayAdapter<String> adpFuncoes;

    private Spinner spFuncao;

    private FloatingActionButton fab;
    private Funcao funcao;
    private Login login;
    private Pessoa pessoa;

    private FuncaoDAO funcaoDAO;
    private LoginDAO loginDAO;

    private List<Funcao> listFuncao;

    private Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadas_usuario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spFuncao = (Spinner) findViewById(R.id.cadas_usuario_sp_funcao);

        txtNome = (AutoCompleteTextView) findViewById(R.id.cadas_usuario_tv_nome);
        txtLogin = (AutoCompleteTextView) findViewById(R.id.cadas_usuario_tv_login);
        txtSenhaAntiga = (AutoCompleteTextView) findViewById(R.id.cadas_usuario_tv_senha_antiga);
        txtSenhaNova = (AutoCompleteTextView) findViewById(R.id.cadas_usuario_tv_senha_nova);
        txtSenhaNovaNovamente = (AutoCompleteTextView) findViewById(R.id.cadas_usuario_tv_senha_nova_novamente);

        b = getIntent().getExtras();

        if (b.getBoolean("cadastrar")) {
            txtSenhaAntiga.setVisibility(View.GONE);
        }

        adpFuncoes = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpFuncoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFuncao.setAdapter(adpFuncoes);

        funcaoDAO = new FuncaoDAO(this);

//        funcaoDAO.deletarTodos();
//
//        funcaoDAO.inserir(new Funcao("Analista de Sistemas"));
//        funcaoDAO.inserir(new Funcao("Gerente"));
//        funcaoDAO.inserir(new Funcao("Designer"));
//        funcaoDAO.inserir(new Funcao("Programador"));
//        funcaoDAO.inserir(new Funcao("Estagiário"));
//        funcaoDAO.inserir(new Funcao("Supervisor"));
//        funcaoDAO.inserir(new Funcao("Coordenador"));

        listFuncao = funcaoDAO.buscarTodos();

        for (int i = 0; i < listFuncao.size(); i++) {
            adpFuncoes.add(listFuncao.get(i).getNome());
        }

        fab = (FloatingActionButton) findViewById(R.id.cadas_usuario_fab_salvar);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == fab) {

            loginDAO = new LoginDAO(ActivityCadasUsuario.this);

            funcao = new Funcao();

            funcao.setCodigo(listFuncao.get(spFuncao.getSelectedItemPosition()).getCodigo());

            pessoa = new Pessoa();
            pessoa.setNome(txtNome.getText().toString());
            pessoa.setFuncao(funcao);

            login = new Login();
            login.setPessoa(pessoa);
            login.setLogin(txtLogin.getText().toString());
            login.setSenha(txtSenhaNova.getText().toString());

            boolean prosseguir = false;

            if (!b.getBoolean("cadastrar")) {

                if (loginDAO.verificarSenha(new Login(txtLogin.getText().toString(), txtSenhaAntiga.getText().toString()))) {
                    prosseguir = true;

                } else {
                    Snackbar.make(view, "Senha antiga incorreta", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                    prosseguir = false;
                }
            } else {
                prosseguir = true;
            }


            if (prosseguir) {
                if (txtSenhaNova.getText().toString().equals(txtSenhaNovaNovamente.getText().toString())) {
                    loginDAO.inserir(login);

                    Snackbar.make(view, "Operação realizada", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                    finish();

                } else {
                    Snackbar.make(view, "Senhas diferentes", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }

        }
    }
}
