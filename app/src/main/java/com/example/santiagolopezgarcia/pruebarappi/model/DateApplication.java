package com.example.santiagolopezgarcia.pruebarappi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public class DateApplication {

    @SerializedName("label")
    private String date;
    @SerializedName("attributes")
    private DateDescription dateDescription;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DateDescription getDateDescription() {
        return dateDescription;
    }

    public void setDateDescription(DateDescription dateDescription) {
        this.dateDescription = dateDescription;
    }
}
