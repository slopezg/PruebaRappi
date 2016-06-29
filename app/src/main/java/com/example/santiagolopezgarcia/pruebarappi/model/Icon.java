package com.example.santiagolopezgarcia.pruebarappi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public class Icon {

    @SerializedName("label")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
