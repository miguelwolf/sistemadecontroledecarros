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

        bd.insert(Preferences.TB_FUNCAO, null, valores);
    }

    public void inserirFuncoesPadrão(){
        ContentValues valores = new ContentValues();

        valores.put(Preferences.FUNCAO_NOME, "Gerente Superior");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Analista de Sistemas");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Programador");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Auxiliar Programador");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Estagiário");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Gerente Administrativo");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Técnico Administrativo");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Auxiliar Administrativo");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Gerente de Vendas");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Técnico de Vendas");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Auxiliar de Vendas");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Técnico de Informática");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Gerente Designer");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Designer");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Auxiliar Designer");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Gerente de Marketing");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Técnico Marketing");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Auxiliar Marketing");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Gerente de Estoque");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Ténico de Estoque");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Auxiliar de Estoque");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Supervisor");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Técnico em Limpeza");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Gerente de Limpeza");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Auxiliar de Limpeza");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Recepcionista");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

        valores.put(Preferences.FUNCAO_NOME, "Secretário");
        bd.insert(Preferences.TB_FUNCAO, null, valores);

    }

    public void atualizar(Funcao func){
        ContentValues valores = new ContentValues();
        valores.put(Preferences.FUNCAO_CODIGO, func.getCodigo());
        valores.put(Preferences.FUNCAO_NOME, func.getNome());
        bd.update(Preferences.TB_FUNCAO, valores, Preferences.FUNCAO_CODIGO+" = ?", new String[]{""+func.getCodigo()});
    }

    public void deletarTodos(){
        bd.delete(Preferences.TB_FUNCAO, null, null);
    }

    public void deletar(Funcao func){
        bd.delete(Preferences.TB_FUNCAO, Preferences.FUNCAO_CODIGO+" = "+func.getCodigo(), null);
    }

    public boolean verificarFuncoes(){
        String[] colunas = new String[]{Preferences.FUNCAO_CODIGO};

        Cursor cursor = bd.query(Preferences.TB_FUNCAO, colunas, null, null, null, null, null);

        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<Funcao> buscarTodos(){
        List<Funcao> list = new ArrayList<>();
        String[] colunas = new String[]{Preferences.FUNCAO_CODIGO +","+ Preferences.FUNCAO_NOME};

        Cursor cursor = bd.query(Preferences.TB_FUNCAO, colunas, null, null, null, null, null);

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
