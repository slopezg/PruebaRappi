package com.example.santiagolopezgarcia.pruebarappi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ronaldgallegoduque on 1/07/16.
 */
public class ObjectResponse {

    @SerializedName("feed")
    private Feed feed;

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }
}
