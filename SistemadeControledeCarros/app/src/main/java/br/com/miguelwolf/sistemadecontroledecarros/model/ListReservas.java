package br.com.miguelwolf.sistemadecontroledecarros.model;

/**
 * Created by Miguel Wolf on 21/11/2016.
 */

public class ListReservas {

    private int foto;
    private String modelo;
    private String placa;
    private String data;

    public ListReservas(int foto, String modelo, String placa, String data) {
        this.foto = foto;
        this.modelo = modelo;
        this.placa = placa;
        this.data = data;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
