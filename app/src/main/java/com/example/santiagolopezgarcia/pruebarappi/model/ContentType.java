package com.example.santiagolopezgarcia.pruebarappi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public class ContentType {

    @SerializedName("attributes")
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
