package br.com.miguelwolf.sistemadecontroledecarros.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.miguelwolf.sistemadecontroledecarros.model.Login;
import br.com.miguelwolf.sistemadecontroledecarros.model.Pessoa;
import br.com.miguelwolf.sistemadecontroledecarros.model.Usuario;
import br.com.miguelwolf.sistemadecontroledecarros.preferences.Preferences;

/**
 * Created by Miguel Wolf on 25/09/2017.
 */

public class LoginDAO {

    private SQLiteDatabase bd;

    public LoginDAO(Context context) {
        BDCore bdAux = new BDCore(context);
        bd = bdAux.getWritableDatabase();
    }

    public void inserir(Login log){
        ContentValues valores = new ContentValues();
        valores.put("login", log.getLogin());
        valores.put("senha", log.getSenha());
        valores.put("pessoa_codigo", log.getPessoa().getCodigo());
        bd.insert("tb_login", null, valores);
    }

    public void atualizar(Login log){
        ContentValues valores = new ContentValues();
        valores.put("login", log.getLogin());
        valores.put("senha", log.getSenha());
        valores.put("pessoa_codigo", log.getPessoa().getCodigo());
        bd.update("tb_login", valores, "_codigo = ?", new String[]{""+log.getCodigo()});
    }

    public void deletar(Login log){
        bd.delete("tb_login", "_codigo = "+log.getCodigo(), null);
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

    public boolean verificarSenha(Login log){
        List<Login> listLogin = new ArrayList<>();
        String[] colunas = new String[]{Preferences.LOGIN_CODIGO+", "+Preferences.LOGIN_USUARIO+", "+Preferences.LOGIN_SENHA+", "+Preferences.LOGIN_PESSOA};

        Cursor cursor = bd.query("tb_login", colunas, Preferences.LOGIN_USUARIO+"=? AND "+Preferences.LOGIN_SENHA+"=?", new String[]{log.getLogin(), log.getSenha()}, null, null, null);

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

                Sessao sessao = new Sessao();
                sessao.setUsuario(cursor.getString(1));

                PESQUISAR PELA PERMISSAO NA PESSOA.
                sessao.setPermissao(cursor.);


            } while(cursor.moveToNext());

            return true;
        }

        return false;

    }

}
