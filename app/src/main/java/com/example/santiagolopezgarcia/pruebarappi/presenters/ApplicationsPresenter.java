package com.example.santiagolopezgarcia.pruebarappi.presenters;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;

import com.example.santiagolopezgarcia.pruebarappi.R;
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
import java.util.HashSet;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ronaldgallegoduque on 30/06/16.
 */
public class ApplicationsPresenter {

    private Context context;
    private IApplicationsView iApplicationsView;
    private DataPreferences dataPreferences;
    private NetworkHelper networkHelper;
    private Feed feed;
    private HashSet<String> categoryList;
    private ProgressDialog progressDialog;

    public ApplicationsPresenter(Context context) {
        this.context = context;
        dataPreferences = new DataPreferences(context);
        networkHelper = new NetworkHelper(context);
        if (context instanceof IApplicationsView) {
            iApplicationsView = (IApplicationsView) context;
        }
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public HashSet<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(HashSet<String> categoryList) {
        this.categoryList = categoryList;
    }

    private void startDialog() {

        progressDialog = ProgressDialog.show(context, context.getString(R.string.data), context.getString(R.string.load_data));

        new Thread(new Runnable() {
            @Override
            public void run() {
                loadFeedService();
                handler.sendEmptyMessage(0);
            }
        }).start();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            progressDialog.dismiss();
        }
    };

    public void init() {
        if (isOnline()) {
            startDialog();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(R.string.not_internet)
                    .setPositiveButton(R.string.accept, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            feed = getPreferences();
                            viewData();
                            dialog.dismiss();
                        }
                    });
            builder.create();
            builder.show();
        }
    }

    private void viewData() {
        feed.generateCategories();
        categoryList = feed.getCategoryList();
        List<String> categories = new ArrayList<String>(categoryList);
        if (categories.size() > 0)
            iApplicationsView.loadApplications(loadApplicationsXCategory(categories.get(0)));
        else
            iApplicationsView.loadApplications(feed.getApplicationList());
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
                viewData();
            }

            @Override
            public void onFailure(Call<ObjectResponse> call, Throwable t) {

            }
        });
    }

    public List<Application> loadApplicationsXCategory(String nameCategory) {
        List<Application> applicationList = new ArrayList<>();
        for (Application application : feed.getApplicationList()) {
            if (application.getCategory().getCategoryPropieties().getNameCategory()
                    .equals(nameCategory)) {
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

    public boolean isOnline() {
        return networkHelper.isOnline();
    }
}
