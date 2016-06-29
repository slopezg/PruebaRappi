package com.example.santiagolopezgarcia.pruebarappi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public class Category {

    @SerializedName("attributes")
    private CategoryPropieties categoryPropieties;

    public CategoryPropieties getCategoryPropieties() {
        return categoryPropieties;
    }

    public void setCategoryPropieties(CategoryPropieties categoryPropieties) {
        this.categoryPropieties = categoryPropieties;
    }
}
