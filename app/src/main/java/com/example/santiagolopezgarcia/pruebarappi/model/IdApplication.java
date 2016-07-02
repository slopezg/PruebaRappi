package com.example.santiagolopezgarcia.pruebarappi.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public class IdApplication implements Serializable {

    @SerializedName("label")
    private String url;
    @SerializedName("attributes")
    private AttributesApplicationId attributesApplicationId;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AttributesApplicationId getAttributesApplicationId() {
        return attributesApplicationId;
    }

    public void setAttributesApplicationId(AttributesApplicationId attributesApplicationId) {
        this.attributesApplicationId = attributesApplicationId;
    }
}
