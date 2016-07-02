package com.example.santiagolopezgarcia.pruebarappi.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public class Application implements Serializable {

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

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<Image> getListImages() {
        return listImages;
    }

    public void setListImages(List<Image> listImages) {
        this.listImages = listImages;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }

    public TitleApp getTitleApp() {
        return titleApp;
    }

    public void setTitleApp(TitleApp titleApp) {
        this.titleApp = titleApp;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public IdApplication getIdApplication() {
        return idApplication;
    }

    public void setIdApplication(IdApplication idApplication) {
        this.idApplication = idApplication;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public DateApplication getDateApplication() {
        return dateApplication;
    }

    public void setDateApplication(DateApplication dateApplication) {
        this.dateApplication = dateApplication;
    }
}
