package com.example.santiagolopezgarcia.pruebarappi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public class Attributes {

    @SerializedName("height")
    private String height;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
