package com.example.santiagolopezgarcia.pruebarappi.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public class Uri implements Serializable {

    @SerializedName("label")
    private String url;

    public String getLabel() {
        return url;
    }

    public void setLabel(String url) {
        this.url = url;
    }
}
