package br.com.miguelwolf.sistemadecontroledecarros.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.miguelwolf.sistemadecontroledecarros.preferences.Preferences;

/**
 * Created by Miguel Wolf on 24/09/2017.
 */

public class BDCore extends SQLiteOpenHelper{

    private static final String NOME_BD = "sis_control_carros";
    private static final int VERSAO_BD = 1;

    public BDCore(Context context) {
        super(context, NOME_BD, null, VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("create table "+Preferences.TB_ATRIBUICAO_PERMISSAO+"(_codigo integer primary key autoincrement, pessoa_codigo integer, permissao_codigo integer)");
        bd.execSQL("create table "+Preferences.TB_EMPRESA+"("+Preferences.EMPRESA_CODIGO+" integer primary key autoincrement, "+Preferences.EMPRESA_NOME+" varchar(200), "+Preferences.EMPRESA_EMAIL+" varchar(200), "+Preferences.EMPRESA_SITUACAO+" boolean)");
        bd.execSQL("create table "+Preferences.TB_FUNCAO +"("+Preferences.FUNCAO_CODIGO+" integer primary key autoincrement, "+Preferences.FUNCAO_NOME+" varchar(150))");
        bd.execSQL("create table "+Preferences.TB_LOGIN+"(_codigo integer primary key autoincrement, login varchar(25), senha varchar(20), pessoa_codigo integer)");
        bd.execSQL("create table "+Preferences.TB_MANUTENCAO+"(_codigo integer primary key autoincrement, prox_revisao datetime, prox_quilometragem integer, veiculo_codigo integer, tipo_manutencao integer )");
        bd.execSQL("create table "+Preferences.TB_MANUTENCAO_TIPO+"(_codigo integer primary key autoincrement, descricao varchar(150), ativo boolean)");
        bd.execSQL("create table "+Preferences.TB_PERMISSAO+"(_codigo integer primary key autoincrement, funcao varchar(100), habilitada boolean, situacao_permissao boolean)");
        bd.execSQL("create table "+Preferences.TB_PESSOA+"(_codigo integer primary key autoincrement, nome varchar(150), situacao boolean, empresa_codigo integer, funcao_codigo integer)");
        bd.execSQL("create table "+Preferences.TB_RESERVA+"(_codigo integer primary key autoincrement, data_inicial datetime, data_final datetime, destino varchar(200), veiculo_codigo, integer, pessoa_codigo integer)");
        bd.execSQL("create table "+Preferences.TB_VEICULOS+"(_codigo integer primary key autoincrement, modelo varchar(100), placa varchar(10), url_foto varchar(250), cor varchar(30), ano integer, km_atual integer, data_atual datetime, km_revisao integer, situacao boolean, veiculos_marca_codigo)");
        bd.execSQL("create table "+Preferences.TB_VEICULOS_MARCA+"(_codigo integer primary key autoincrement, nome varchar(150))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
        bd.execSQL("drop table "+ Preferences.TB_ATRIBUICAO_PERMISSAO);
        bd.execSQL("drop table "+ Preferences.TB_EMPRESA);
        bd.execSQL("drop table "+ Preferences.TB_FUNCAO);
        bd.execSQL("drop table "+ Preferences.TB_LOGIN);
        bd.execSQL("drop table "+ Preferences.TB_MANUTENCAO);
        bd.execSQL("drop table "+ Preferences.TB_MANUTENCAO_TIPO);
        bd.execSQL("drop table "+ Preferences.TB_PERMISSAO);
        bd.execSQL("drop table "+ Preferences.TB_PESSOA);
        bd.execSQL("drop table "+ Preferences.TB_RESERVA);
        bd.execSQL("drop table "+ Preferences.TB_VEICULOS);
        bd.execSQL("drop table "+ Preferences.TB_VEICULOS_MARCA);
        onCreate(bd);
    }
}
