package br.com.miguelwolf.sistemadecontroledecarros.model;

/**
 * Created by Miguel Wolf on 03/09/2017.
 */

public class TipoManutencao {

    private int codigo;
    private String descricao;
    private boolean ativo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
