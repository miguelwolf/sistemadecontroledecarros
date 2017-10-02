package br.com.miguelwolf.sistemadecontroledecarros.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.miguelwolf.sistemadecontroledecarros.model.Empresa;
import br.com.miguelwolf.sistemadecontroledecarros.preferences.Preferences;

/**
 * Created by Miguel Wolf on 25/09/2017.
 */

public class EmpresaDAO {

    private SQLiteDatabase bd;

    public EmpresaDAO(Context context) {
        BDCore bdAux = new BDCore(context);
        bd = bdAux.getWritableDatabase();
    }

    public void inserir(Empresa emp){
        ContentValues valores = new ContentValues();
        valores.put(Preferences.EMPRESA_NOME, emp.getNome());
        valores.put(Preferences.EMPRESA_EMAIL, emp.getEmail());
        valores.put(Preferences.EMPRESA_SITUACAO, 1);

        bd.insert(Preferences.TB_EMPRESA, null, valores);
    }

    public void atualizar(Empresa emp){
        ContentValues valores = new ContentValues();
        valores.put(Preferences.EMPRESA_CODIGO, emp.getCodigo());
        valores.put(Preferences.EMPRESA_NOME, emp.getNome());
        valores.put(Preferences.EMPRESA_EMAIL, emp.getEmail());
        valores.put(Preferences.EMPRESA_SITUACAO, 1);
        bd.update(Preferences.TB_EMPRESA, valores, Preferences.EMPRESA_CODIGO+" = ?", new String[]{""+emp.getCodigo()});
    }

    public void deletarTodos(){
        bd.delete(Preferences.TB_EMPRESA, null, null);
    }

    public void deletar(Empresa emp){
        ContentValues valores = new ContentValues();
        valores.put(Preferences.EMPRESA_CODIGO, emp.getCodigo());
        valores.put(Preferences.EMPRESA_NOME, emp.getNome());
        valores.put(Preferences.EMPRESA_EMAIL, emp.getEmail());
        valores.put(Preferences.EMPRESA_SITUACAO, 0);
        bd.update(Preferences.TB_EMPRESA, valores, Preferences.EMPRESA_CODIGO+" = ?", new String[]{""+emp.getCodigo()});
    }

    public List<Empresa> buscarTodos(){
        List<Empresa> list = new ArrayList<>();
        String[] colunas = new String[]{Preferences.EMPRESA_CODIGO +","+ Preferences.EMPRESA_NOME+","+ Preferences.EMPRESA_EMAIL};

        bd.query(Preferences.TB_EMPRESA, colunas, Preferences.EMPRESA_SITUACAO + "=?", new String[]{"1"}, null, null, Preferences.EMPRESA_SITUACAO);
        Cursor cursor = bd.query(Preferences.TB_EMPRESA, colunas, null, null, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            do {
                Empresa empresa = new Empresa();
                empresa.setCodigo((int) cursor.getLong(0));
                empresa.setNome(cursor.getString(1));
                empresa.setEmail(cursor.getString(2));

                list.add(empresa);

            } while(cursor.moveToNext());
        }

        return list;

    }

}
