package com.example.santiagolopezgarcia.pruebarappi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public class Artist {

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
