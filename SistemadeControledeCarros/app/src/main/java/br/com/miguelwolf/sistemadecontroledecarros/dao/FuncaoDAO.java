package br.com.miguelwolf.sistemadecontroledecarros.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.miguelwolf.sistemadecontroledecarros.model.Funcao;
import br.com.miguelwolf.sistemadecontroledecarros.preferences.Preferences;

/**
 * Created by Miguel Wolf on 25/09/2017.
 */

public class FuncaoDAO {

    private SQLiteDatabase bd;

    public FuncaoDAO(Context context) {
        BDCore bdAux = new BDCore(context);
        bd = bdAux.getWritableDatabase();
    }

    public void inserir(Funcao func){
        ContentValues valores = new ContentValues();
        valores.put(Preferences.FUNCAO_NOME, func.getNome());

        bd.insert(Preferences.TB_EMPRESA, null, valores);
    }

    public void atualizar(Funcao func){
        ContentValues valores = new ContentValues();
        valores.put(Preferences.FUNCAO_CODIGO, func.getCodigo());
        valores.put(Preferences.FUNCAO_NOME, func.getNome());
        bd.update(Preferences.TB_EMPRESA, valores, Preferences.FUNCAO_CODIGO+" = ?", new String[]{""+func.getCodigo()});
    }

    public void deletarTodos(){
        bd.delete(Preferences.TB_EMPRESA, null, null);
    }

    public void deletar(Funcao func){
        bd.delete(Preferences.TB_EMPRESA, Preferences.FUNCAO_CODIGO+" = "+func.getCodigo(), null);
    }

    public List<Funcao> buscarTodos(){
        List<Funcao> list = new ArrayList<>();
        String[] colunas = new String[]{Preferences.FUNCAO_CODIGO +","+ Preferences.FUNCAO_NOME};

        Cursor cursor = bd.query(Preferences.TB_EMPRESA, colunas, null, null, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            do {
                Funcao funcao = new Funcao();
                funcao.setCodigo((int) cursor.getLong(0));
                funcao.setNome(cursor.getString(1));

                list.add(funcao);

            } while(cursor.moveToNext());
        }

        return list;

    }

}
