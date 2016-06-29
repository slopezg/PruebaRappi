package com.example.santiagolopezgarcia.pruebarappi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public class Rights {

    @SerializedName("label")
    private String rightsDescription;

    public String getRightsDescription() {
        return rightsDescription;
    }

    public void setRightsDescription(String rightsDescription) {
        this.rightsDescription = rightsDescription;
    }
}
