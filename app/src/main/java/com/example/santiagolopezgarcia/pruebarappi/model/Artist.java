package com.example.santiagolopezgarcia.pruebarappi.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public class Artist implements Serializable {

    @SerializedName("label")
    private String nameArtist;
    @SerializedName("attributes")
    private AttributesArtist attributesArtist;

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public AttributesArtist getAttributesArtist() {
        return attributesArtist;
    }

    public void setAttributesArtist(AttributesArtist attributesArtist) {
        this.attributesArtist = attributesArtist;
    }
}
