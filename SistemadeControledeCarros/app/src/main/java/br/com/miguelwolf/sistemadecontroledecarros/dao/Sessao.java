package br.com.miguelwolf.sistemadecontroledecarros.dao;

/**
 * Created by Miguel Wolf on 04/10/2017.
 */

public class Sessao {

    public static String usuario = "";
    public static int permissao = 0;

    public Sessao() {
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        Sessao.usuario = usuario;
    }

    public static int getPermissao() {
        return permissao;
    }

    public static void setPermissao(int permissao) {
        Sessao.permissao = permissao;
    }
}
