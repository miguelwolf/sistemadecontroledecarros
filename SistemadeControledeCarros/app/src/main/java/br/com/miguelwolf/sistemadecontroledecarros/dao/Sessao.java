package br.com.miguelwolf.sistemadecontroledecarros.dao;

/**
 * Created by Miguel Wolf on 04/10/2017.
 */

public class Sessao {

    private static String usuario = "";
    private static int permissao = 0;
    private static int cod_usuario = 0;

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

    public static int getCod_usuario() {
        return cod_usuario;
    }

    public static void setCod_usuario(int cod_usuario) {
        Sessao.cod_usuario = cod_usuario;
    }
}
