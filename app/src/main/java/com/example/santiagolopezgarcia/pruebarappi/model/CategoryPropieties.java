package com.example.santiagolopezgarcia.pruebarappi.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public class CategoryPropieties implements Serializable {

    @SerializedName("im:id")
    private String idCategory;
    @SerializedName("term")
    private String nameCategory;
    @SerializedName("scheme")
    private String url;
    @SerializedName("label")
    private String descripitionCategory;

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripitionCategory() {
        return descripitionCategory;
    }

    public void setDescripitionCategory(String descripitionCategory) {
        this.descripitionCategory = descripitionCategory;
    }
}
