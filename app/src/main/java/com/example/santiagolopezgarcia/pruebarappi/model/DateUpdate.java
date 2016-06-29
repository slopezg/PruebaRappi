package com.example.santiagolopezgarcia.pruebarappi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public class DateUpdate {

    @SerializedName("label")
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
