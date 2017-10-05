package br.com.miguelwolf.sistemadecontroledecarros.preferences;

/**
 * Created by Miguel Wolf on 09/10/2016.
 */

public class Preferences {

    public static String BD_URL = "";
    public static String BD_LOGIN = "";
    public static String BD_SENHA = "";

    public static String TB_ATRIBUICAO_PERMISSAO="tb_atribuicao_permissao";
    public static String TB_EMPRESA="tb_empresa";
    public static String TB_FUNCAO ="tb_funcao";
    public static String TB_LOGIN="tb_login";
    public static String TB_MANUTENCAO="tb_manutencao";
    public static String TB_MANUTENCAO_TIPO="tb_manutencao_tipo";
    public static String TB_PERMISSAO="tb_permissao";
    public static String TB_PESSOA="tb_pessoa";
    public static String TB_RESERVA="tb_reserva";
    public static String TB_VEICULOS="tb_veiculos";
    public static String TB_VEICULOS_MARCA="tb_veiculos_marca";

    public static String LOGIN_CODIGO="_codigo";
    public static String LOGIN_USUARIO="login";
    public static String LOGIN_SENHA="senha";
    public static String LOGIN_PESSOA="pessoa_codigo";

    public static String FUNCAO_CODIGO="_codigo";
    public static String FUNCAO_NOME="nome";

    public static String EMPRESA_CODIGO="_codigo";
    public static String EMPRESA_NOME="nome";
    public static String EMPRESA_EMAIL="email";
    public static String EMPRESA_SITUACAO="situacao";

    public static String PESSOA_CODIGO = "_codigo";
    public static String PESSOA_NOME = "nome";
    public static String PESSOA_SITUACAO = "situacao";
    public static String PESSOA_EMPRESA = "empresa_codigo";
    public static String PESSOA_FUNCAO_CODIGO = "funcao_codigo";

    public static int PERMISSAO_FUNCIONARIO=0;
    public static int PERMISSAO_ADMINISTRADOR=1;

}
