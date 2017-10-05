package br.com.miguelwolf.sistemadecontroledecarros.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AutoCompleteTextView;

import br.com.miguelwolf.sistemadecontroledecarros.R;
import br.com.miguelwolf.sistemadecontroledecarros.dao.EmpresaDAO;
import br.com.miguelwolf.sistemadecontroledecarros.model.Empresa;

public class ActivityEmpresaCadastrar extends AppCompatActivity implements View.OnClickListener{

    private Empresa empresa;
    private EmpresaDAO empresaDAO;

    private AutoCompleteTextView txtNome;
    private AutoCompleteTextView txtEmail;

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_cadastrar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtNome = (AutoCompleteTextView) findViewById(R.id.cadastrar_empresa_tv_nome);
        txtEmail = (AutoCompleteTextView) findViewById(R.id.cadastrar_empresa_tv_email);

        fab = (FloatingActionButton) findViewById(R.id.empresa_cadastrar_fab);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == fab) {

            empresaDAO = new EmpresaDAO(this);
            empresa = new Empresa();

            empresa.setNome(txtNome.getText().toString());
            empresa.setEmail(txtEmail.getText().toString());

            if (empresaDAO.inserir(empresa)) {

                Snackbar.make(view, "Operação realizada", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                startActivity(new Intent(this, ActivityMain.class));
            } else {
                txtEmail.setError(getString(R.string.error_empresa_cadastrada));
                txtEmail.requestFocus();
            }

        }
    }
}
