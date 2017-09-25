package br.com.miguelwolf.sistemadecontroledecarros.model;

/**
 * Created by Miguel Wolf on 03/09/2017.
 */

public class Empresa {

    private int codigo;
    private String nome;
    private String email;
    private boolean situacao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
}
