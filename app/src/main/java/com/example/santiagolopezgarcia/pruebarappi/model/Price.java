package com.example.santiagolopezgarcia.pruebarappi.model;

import java.io.Serializable;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public class Price implements Serializable {

    private String action;
    private DetailPrice detailPrice;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public DetailPrice getDetailPrice() {
        return detailPrice;
    }

    public void setDetailPrice(DetailPrice detailPrice) {
        this.detailPrice = detailPrice;
    }
}
