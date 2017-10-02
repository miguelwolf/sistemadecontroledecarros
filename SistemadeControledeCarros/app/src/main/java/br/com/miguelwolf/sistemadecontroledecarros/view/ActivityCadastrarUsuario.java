package br.com.miguelwolf.sistemadecontroledecarros.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import java.util.List;

import br.com.miguelwolf.sistemadecontroledecarros.R;
import br.com.miguelwolf.sistemadecontroledecarros.dao.FuncaoDAO;
import br.com.miguelwolf.sistemadecontroledecarros.dao.LoginDAO;
import br.com.miguelwolf.sistemadecontroledecarros.model.Funcao;
import br.com.miguelwolf.sistemadecontroledecarros.model.Login;
import br.com.miguelwolf.sistemadecontroledecarros.model.Pessoa;

public class ActivityCadastrarUsuario extends AppCompatActivity{

    private AutoCompleteTextView txtNome;
    private AutoCompleteTextView txtLogin;
    private AutoCompleteTextView txtSenhaAntiga;
    private AutoCompleteTextView txtSenhaNova;
    private AutoCompleteTextView txtSenhaNovaNovamente;

    private ArrayAdapter<Funcao> adpFuncoes;

    private Spinner spFuncao;

    private Funcao funcao;
    private Login login;
    private Pessoa pessoa;

    private FuncaoDAO funcaoDAO;
    private LoginDAO loginDAO;

    private List<Funcao> listFuncao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spFuncao = (Spinner) findViewById(R.id.cadas_usuario_sp_funcao);

        txtNome = (AutoCompleteTextView) findViewById(R.id.cadastrar_empresa_tv_nome);
        txtSenhaAntiga = (AutoCompleteTextView) findViewById(R.id.cadas_usuario_tv_senha_antiga);
        txtSenhaNova = (AutoCompleteTextView) findViewById(R.id.cadas_usuario_tv_senha_nova);
        txtSenhaNovaNovamente = (AutoCompleteTextView) findViewById(R.id.cadas_usuario_tv_senha_nova_novamente);

        adpFuncoes = new ArrayAdapter<Funcao>(this, android.R.layout.simple_spinner_item);
        adpFuncoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFuncao.setAdapter(adpFuncoes);

        adpFuncoes.addAll(listFuncao);

        listFuncao = funcaoDAO.buscarTodos();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                funcao = new Funcao();
                funcao = (Funcao) spFuncao.getSelectedItem();

                pessoa = new Pessoa();
                pessoa.setNome(txtNome.getText().toString());
                pessoa.setFuncao(funcao);

                login = new Login();
                login.setPessoa(pessoa);
                login.setLogin(txtLogin.getText().toString());
                login.setSenha(txtSenhaNova.getText().toString());

                if (txtSenhaNova.getText().toString().equals(txtSenhaNovaNovamente.getText().toString())) {
                    loginDAO = new LoginDAO(ActivityCadastrarUsuario.this);
                    loginDAO.inserir(login);
                } else {
                    Snackbar.make(view, "Senhas diferentes", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
    }
}
