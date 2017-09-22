package br.com.miguelwolf.sistemadecontroledecarros.model;

/**
 * Created by Miguel Wolf on 21/11/2016.
 */

public class ListVeiculos {

    private int foto;
    private String modelo;
    private String placa;

    public ListVeiculos(int foto, String modelo, String placa) {
        this.foto = foto;
        this.modelo = modelo;
        this.placa = placa;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
