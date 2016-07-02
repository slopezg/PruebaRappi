package com.example.santiagolopezgarcia.pruebarappi.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public class Image implements Serializable {

    @SerializedName("label")
    private String url;
    @SerializedName("attributes")
    private Attributes attributes;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
}
