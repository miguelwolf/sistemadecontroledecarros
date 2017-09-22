package br.com.miguelwolf.sistemadecontroledecarros.model;

/**
 * Created by Miguel Wolf on 20/11/2016.
 */

public class ListMain {

    private Integer background;
    private Integer icon;

    public ListMain(Integer background, Integer icon) {
        this.background = background;
        this.icon = icon;
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
}
