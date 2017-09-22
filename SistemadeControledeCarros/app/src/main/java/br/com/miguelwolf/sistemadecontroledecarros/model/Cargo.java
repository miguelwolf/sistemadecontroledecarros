package br.com.miguelwolf.sistemadecontroledecarros.model;

/**
 * Created by Miguel Wolf on 09/10/2016.
 */

public class Cargo {

    private String id;
    private String nome;
    private Usuario usuario;

    @Override
    public String toString() {
        return "cargo{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", usuario=" + usuario +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
