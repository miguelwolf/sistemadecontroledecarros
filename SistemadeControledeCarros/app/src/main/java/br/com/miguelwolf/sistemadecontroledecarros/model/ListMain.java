package br.com.miguelwolf.sistemadecontroledecarros.model;

/**
 * Created by Miguel Wolf on 20/11/2016.
 */

public class ListMain {

    private Integer background;
    private Integer icon;
    private String legenda;

    public ListMain(Integer background, Integer icon, String legenda) {
        this.background = background;
        this.icon = icon;
        this.legenda = legenda;
    }

    public Integer getBackground() {
        return background;
    }

    public void setBackground(Integer background) {
        this.background = background;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }
}
