package com.example.santiagolopezgarcia.pruebarappi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public class Application {

    @SerializedName("im:name")
    private Name name;
    @SerializedName("im:image")
    private List<Image> listImages;
    @SerializedName("summary")
    private Summary summary;
    @SerializedName("im:price")
    private Price price;
    @SerializedName("im:contentType")
    private ContentType contentType;
    @SerializedName("rights")
    private Rights rights;
    @SerializedName("title")
    private TitleApp titleApp;
    @SerializedName("link")
    private Link link;
    @SerializedName("id")
    private IdApplication idApplication;
    @SerializedName("im:artist")
    private Artist artist;
    @SerializedName("category")
    private Category category;
    @SerializedName("im:releaseDate")
    private DateApplication dateApplication;
}
