package br.com.miguelwolf.sistemadecontroledecarros.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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

    public boolean inserir(Empresa emp){
        ContentValues valores = new ContentValues();
        valores.put(Preferences.EMPRESA_NOME, emp.getNome());
        valores.put(Preferences.EMPRESA_EMAIL, emp.getEmail());
        valores.put(Preferences.EMPRESA_SITUACAO, 1);

        if (verificarUnanimidade(emp.getEmail())) {
            bd.insert(Preferences.TB_EMPRESA, null, valores);
            atualizarEmpresaUsuario(buscarCodigoEmpresa(emp.getEmail()));

            return true;
        } else {
            return false;
        }
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

    public boolean atualizarEmpresaUsuario(int codigo) {
        ContentValues valores = new ContentValues();

        valores.put(Preferences.PESSOA_EMPRESA, codigo);
        int codigo_usu = Sessao.getCod_usuario();
        bd.update(Preferences.TB_PESSOA, valores, Preferences.PESSOA_CODIGO+" = ?", new String[]{""+codigo_usu});

        return true;

    }

    /**
     * Método para verificar se a empresa cadastrada é unica, pelo email.
     * @param email
     * @return TRUE caso seja unanime, ou seja, não exista mais nenhuma igual. FALASE caso tenha alguma já cadastrada com este email.
     */
    public boolean verificarUnanimidade(String email) {
        List<Empresa> list = new ArrayList<>();
        String[] colunas = new String[]{Preferences.EMPRESA_CODIGO};

        Cursor cursor = bd.query(Preferences.TB_EMPRESA, colunas, Preferences.EMPRESA_SITUACAO + "=? AND " + Preferences.EMPRESA_EMAIL + " like ?", new String[]{"1", email}, null, null, null);

        if (cursor.getCount() > 0) {
            return false;
        } else {
            return true;
        }
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

    public int buscarCodigoEmpresa(String email){
        List<Empresa> list = new ArrayList<>();
        String[] colunas = new String[]{Preferences.EMPRESA_CODIGO};

        bd.query(Preferences.TB_EMPRESA, colunas, Preferences.EMPRESA_SITUACAO + "=? AND "+Preferences.EMPRESA_EMAIL + " like ? ", new String[]{"1", email}, null, null, null);
        Cursor cursor = bd.query(Preferences.TB_EMPRESA, colunas, null, null, null, null, null);

        int empresa = 0;

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            do {

                empresa = ((int) cursor.getLong(0));

            } while(cursor.moveToNext());
        }

        return empresa;

    }

}
