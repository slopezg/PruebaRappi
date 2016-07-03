package com.example.santiagolopezgarcia.pruebarappi.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public class Category implements Serializable {

    @SerializedName("attributes")
    private CategoryPropieties categoryPropieties;

    public Category() {
        categoryPropieties = new CategoryPropieties();
    }

    public CategoryPropieties getCategoryPropieties() {
        return categoryPropieties;
    }

    public void setCategoryPropieties(CategoryPropieties categoryPropieties) {
        this.categoryPropieties = categoryPropieties;
    }

}
