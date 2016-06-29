package com.example.santiagolopezgarcia.pruebarappi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public class Link {

    @SerializedName("attributes")
    private AttributesLink attributesLink;

    public AttributesLink getAttributesLink() {
        return attributesLink;
    }

    public void setAttributesLink(AttributesLink attributesLink) {
        this.attributesLink = attributesLink;
    }
}
