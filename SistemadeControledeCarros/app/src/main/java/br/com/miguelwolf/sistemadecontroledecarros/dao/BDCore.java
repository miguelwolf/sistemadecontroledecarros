package br.com.miguelwolf.sistemadecontroledecarros.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        bd.execSQL("create table tb_atribuicao_permissao(_codigo integer primary key autoincrment, pessoa_codigo integer, permissao_codigo integer)");
        bd.execSQL("create table tb_empresa(_codigo integer primary key autoincrment, nome varchar(200), email varchar(200), situacao boolean)");
        bd.execSQL("create table tb_funcao(_codigo integer primary key autoincrment, nome varchar(150))");
        bd.execSQL("create table tb_login(_codigo integer primary key autoincrment, login varchar(25), senha varchar(20), pessoa_codigo integer)");
        bd.execSQL("create table tb_manutencao(_codigo integer primary key autoincrment, prox_revisao datetime, prox_quilometragem integer, veiculo_codigo integer, tipo_manutencao integer )");
        bd.execSQL("create table tb_manutencao_tipo(_codigo integer primary key autoincrment, descricao varchar(150), ativo boolean)");
        bd.execSQL("create table tb_permissao(_codigo integer primary key autoincrment, funcao varchar(100), habilitada boolean, situacao_permissao boolean)");
        bd.execSQL("create table tb_pessoa(_codigo integer primary key autoincrment, nome varchar(150), situacao boolean, empresa_codigo integer, funcao_codigo integer)");
        bd.execSQL("create table tb_reserva(_codigo integer primary key autoincrment, data_inicial datetime, data_final datetime, destino varchar(200), veiculo_codigo, integer, pessoa_codigo integer)");
        bd.execSQL("create table tb_veiculos(_codigo integer primary key autoincrment, modelo varchar(100), placa varchar(10), url_foto varchar(250), cor varchar(30), ano integer, km_atual integer, data_atual datetime, km_revisao integer, situacao boolean, veiculos_marca_codigo)");
        bd.execSQL("create table tb_veiculos_marca(_codigo integer primary key autoincrment, nome varchar(150))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
        bd.execSQL("drop table tb_atribuicao_permissao");
        bd.execSQL("drop table tb_empresa");
        bd.execSQL("drop table tb_funcao");
        bd.execSQL("drop table tb_login");
        bd.execSQL("drop table tb_manutencao");
        bd.execSQL("drop table tb_manutencao_tipo");
        bd.execSQL("drop table tb_permissao");
        bd.execSQL("drop table tb_pessoa");
        bd.execSQL("drop table tb_reserva");
        bd.execSQL("drop table tb_veiculos");
        bd.execSQL("drop table tb_veiculos_marca");
        onCreate(bd);
    }
}
