package br.com.miguelwolf.sistemadecontroledecarros.model;

/**
 * Created by Miguel Wolf on 03/09/2017.
 */

public class Manutencao {

    private int codigo;
    private String proxRevisao;
    private String proxKM;
    private Veiculo veiculo;
    private TipoManutencao tipoManutencao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getProxRevisao() {
        return proxRevisao;
    }

    public void setProxRevisao(String proxRevisao) {
        this.proxRevisao = proxRevisao;
    }

    public String getProxKM() {
        return proxKM;
    }

    public void setProxKM(String proxKM) {
        this.proxKM = proxKM;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public TipoManutencao getTipoManutencao() {
        return tipoManutencao;
    }

    public void setTipoManutencao(TipoManutencao tipoManutencao) {
        this.tipoManutencao = tipoManutencao;
    }
}
