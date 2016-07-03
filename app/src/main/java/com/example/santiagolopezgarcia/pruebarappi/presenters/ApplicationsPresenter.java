package com.example.santiagolopezgarcia.pruebarappi.presenters;

import android.content.Context;

import com.example.santiagolopezgarcia.pruebarappi.helpers.util.NetworkHelper;
import com.example.santiagolopezgarcia.pruebarappi.model.Application;
import com.example.santiagolopezgarcia.pruebarappi.model.Category;
import com.example.santiagolopezgarcia.pruebarappi.model.Feed;
import com.example.santiagolopezgarcia.pruebarappi.model.ObjectResponse;
import com.example.santiagolopezgarcia.pruebarappi.helpers.preferences.DataPreferences;
import com.example.santiagolopezgarcia.pruebarappi.services.repositories.IRappiService;
import com.example.santiagolopezgarcia.pruebarappi.view.IApplicationsView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ronaldgallegoduque on 30/06/16.
 */
public class ApplicationsPresenter  {

    private Context context;
    private IApplicationsView iApplicationsView;
    private DataPreferences dataPreferences;
    private NetworkHelper networkHelper;
    private Feed feed;
    private List<Category> categoryList;

    public ApplicationsPresenter(Context context) {
        this.context = context;
        dataPreferences = new DataPreferences(context);
        networkHelper = new NetworkHelper(context);
        if(context instanceof IApplicationsView){
            iApplicationsView = (IApplicationsView) context;
        }
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public void init() {
        if(isOnline()) {
            loadFeedService();
        }else {
            feed = getPreferences();
            feed.generateCategories();
            categoryList = feed.getCategoryList();
            iApplicationsView.loadApplications(loadApplicationsXCategory("6010"));
        }
    }

    private void loadFeedService() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://itunes.apple.com/us/rss/topfreeapplications/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        IRappiService iRappiService = retrofit.create(IRappiService.class);

        Call<ObjectResponse> call = iRappiService.load();

        call.enqueue(new Callback<ObjectResponse>() {
            @Override
            public void onResponse(Call<ObjectResponse> call, Response<ObjectResponse> response) {
                savePreferences(response.body().getFeed());
                feed = response.body().getFeed();
                feed.generateCategories();
                categoryList = feed.getCategoryList();
                iApplicationsView.loadApplications(loadApplicationsXCategory("6010"));
            }

            @Override
            public void onFailure(Call<ObjectResponse> call, Throwable t) {

            }
        });
    }

    private List<Application> loadApplicationsXCategory(String idCategory){
        List<Application> applicationList = new ArrayList<>();
        for (Application application: feed.getApplicationList()){
            if(application.getCategory().getCategoryPropieties().getIdCategory()
                    .equals(idCategory)){
                applicationList.add(application);
            }
        }
        return applicationList;
    }


    private void savePreferences(Feed feed) {
        dataPreferences.saveFeedPreferences(feed, "feed.dat");
    }

    private Feed getPreferences() {
        return dataPreferences.readDataPreferences("feed.dat");
    }

    public boolean isOnline(){
        return networkHelper.isOnline();
    }
}
