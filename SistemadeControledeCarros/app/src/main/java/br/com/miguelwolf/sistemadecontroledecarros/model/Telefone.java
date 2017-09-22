package br.com.miguelwolf.sistemadecontroledecarros.model;

/**
 * Created by Miguel Wolf on 09/10/2016.
 */

public class Telefone {

    private String id;
    private String numero;
    private Usuario usuario;

    @Override
    public String toString() {
        return "telefone{" +
                "id='" + id + '\'' +
                ", numero='" + numero + '\'' +
                ", usuario=" + usuario +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
