package com.example.santiagolopezgarcia.pruebarappi.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public class Feed implements Serializable {
    @SerializedName("author")
    private Author author;
    @SerializedName("entry")
    private List<Application> applicationList;
    @SerializedName("updated")
    private DateUpdate dateUpdate;
    @SerializedName("rights")
    private Rights rights;
    @SerializedName("title")
    private TitleApp titleApp;
    @SerializedName("icon")
    private Icon icon;
    @SerializedName("link")
    private List<Link> linkList;
    @SerializedName("id")
    private Uri uri;
    private HashSet<String> categoryList;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Application> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(List<Application> applicationList) {
        this.applicationList = applicationList;
    }

    public DateUpdate getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(DateUpdate dateUpdate) {
        this.dateUpdate = dateUpdate;
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

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public List<Link> getLinkList() {
        return linkList;
    }

    public void setLinkList(List<Link> linkList) {
        this.linkList = linkList;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public HashSet<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(HashSet<String> categoryList) {
        this.categoryList = categoryList;
    }

    public void generateCategories() {
        List<Category> categoryLisComplete = new ArrayList<>();
        List<String> categoriesName = new ArrayList<>();
        categoryList = new HashSet<>();
        for (Application application : applicationList) {
            categoryLisComplete.add(application.getCategory());
            categoriesName.add(application.getCategory().getCategoryPropieties().getNameCategory());
        }
        categoryList  = new HashSet<>(categoriesName);
    }

}
