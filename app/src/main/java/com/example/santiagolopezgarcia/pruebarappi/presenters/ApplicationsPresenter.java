package com.example.santiagolopezgarcia.pruebarappi.presenters;

import android.content.Context;

import com.example.santiagolopezgarcia.pruebarappi.model.Application;
import com.example.santiagolopezgarcia.pruebarappi.model.Feed;
import com.example.santiagolopezgarcia.pruebarappi.services.Suscriptor;
import com.example.santiagolopezgarcia.pruebarappi.services.repositories.RappiService;
import com.example.santiagolopezgarcia.pruebarappi.view.IApplicationsView;

/**
 * Created by ronaldgallegoduque on 30/06/16.
 */
public class ApplicationsPresenter  {

    private Context context;
    private IApplicationsView iApplicationsView;
    public ApplicationsPresenter(Context context) {
        this.context = context;
        if(context instanceof IApplicationsView){
            iApplicationsView = (IApplicationsView) context;
        }
    }

    public void init() {
        new RappiService(new Suscriptor() {
            @Override
            public void onError(Throwable e) {
                e.getMessage();
            }

            @Override
            public void onCompletetado() {

            }

            @Override
            public <T> void onResultado(T datos) {
                iApplicationsView.loadApplications(((Feed) datos).getApplicationList());
            }
        }, context, "https://itunes.apple.com/us/rss/topfreeapplications/").solicitudCarga();
    }
}
