package br.com.miguelwolf.sistemadecontroledecarros.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.miguelwolf.sistemadecontroledecarros.model.Login;
import br.com.miguelwolf.sistemadecontroledecarros.model.Pessoa;
import br.com.miguelwolf.sistemadecontroledecarros.preferences.Preferences;

/**
 * Created by Miguel Wolf on 25/09/2017.
 */

public class PessoaDAO {

    private SQLiteDatabase bd;

    public PessoaDAO(Context context) {
        BDCore bdAux = new BDCore(context);
        bd = bdAux.getWritableDatabase();
    }

    public int inserir(Pessoa pessoa){
        ContentValues valores = new ContentValues();
        valores.put(Preferences.PESSOA_NOME, pessoa.getNome());
        valores.put(Preferences.PESSOA_SITUACAO, 1);
        valores.put(Preferences.PESSOA_FUNCAO_CODIGO, pessoa.getFuncao().getCodigo());
        valores.put(Preferences.PESSOA_EMPRESA, 0);

        return (int) bd.insert(Preferences.TB_PESSOA, null, valores);
    }

    public void atualizar(Pessoa pessoa){
        ContentValues valores = new ContentValues();
        valores.put(Preferences.PESSOA_NOME, pessoa.getNome());
        valores.put(Preferences.PESSOA_SITUACAO, 1);
        valores.put(Preferences.PESSOA_FUNCAO_CODIGO, pessoa.getFuncao().getCodigo());
        valores.put(Preferences.PESSOA_EMPRESA, 0);
        bd.update(Preferences.TB_PESSOA, valores, Preferences.PESSOA_CODIGO+" = ?", new String[]{""+pessoa.getCodigo()});
    }

    public void deletar(Login log){
        bd.delete(Preferences.TB_PESSOA, Preferences.PESSOA_CODIGO+" = "+log.getCodigo(), null);
    }

    public List<Login> buscarTodos(){
        List<Login> listLogin = new ArrayList<>();
        String[] colunas = new String[]{"_codigo integer, login, senha, pessoa_codigo"};

        Cursor cursor = bd.query("tb_login", colunas, null, null, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            do {
                Login login = new Login();

                Pessoa pessoa = new Pessoa();
                pessoa.setCodigo((int) cursor.getLong(3));

                login.setCodigo((int) cursor.getLong(0));
                login.setLogin(cursor.getString(1));
                login.setSenha(cursor.getString(2));
                login.setPessoa(pessoa);

                listLogin.add(login);

            } while(cursor.moveToNext());

        }

        return listLogin;

    }


}
