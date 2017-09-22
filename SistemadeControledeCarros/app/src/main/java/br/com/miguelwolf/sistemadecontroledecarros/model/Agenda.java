package br.com.miguelwolf.sistemadecontroledecarros.model;

/**
 * Created by Miguel Wolf on 09/10/2016.
 */

public class Agenda {

    private String id;
    private String data_inicial;
    private String data_final;
    private Usuario usuario;
    private Carro carro;

    @Override
    public String toString() {
        return "agenda_wallpaper{" +
                "id='" + id + '\'' +
                ", data_inicial='" + data_inicial + '\'' +
                ", data_final='" + data_final + '\'' +
                ", usuario=" + usuario +
                ", carro=" + carro +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(String data_inicial) {
        this.data_inicial = data_inicial;
    }

    public String getData_final() {
        return data_final;
    }

    public void setData_final(String data_final) {
        this.data_final = data_final;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
