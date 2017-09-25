package br.com.miguelwolf.sistemadecontroledecarros.model;

/**
 * Created by Miguel Wolf on 03/09/2017.
 */

public class Permissao {

    private int codigo;
    private boolean habilitada;//Caso uma pessoa possa ter tal permissao o campo deverá ser true, caso não tenha permissão, deverá ser false.
    private boolean situacaoPermissao;//Se a situacao está ativa ou inativa;
    private Pessoa pessoa;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isHabilitada() {
        return habilitada;
    }

    public void setHabilitada(boolean habilitada) {
        this.habilitada = habilitada;
    }

    public boolean isSituacaoPermissao() {
        return situacaoPermissao;
    }

    public void setSituacaoPermissao(boolean situacaoPermissao) {
        this.situacaoPermissao = situacaoPermissao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
