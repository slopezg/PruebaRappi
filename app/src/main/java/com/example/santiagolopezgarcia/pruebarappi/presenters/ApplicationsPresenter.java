package com.example.santiagolopezgarcia.pruebarappi.presenters;

import android.content.Context;

import com.example.santiagolopezgarcia.pruebarappi.services.Suscriptor;
import com.example.santiagolopezgarcia.pruebarappi.services.repositories.RappiService;

/**
 * Created by ronaldgallegoduque on 30/06/16.
 */
public class ApplicationsPresenter  {

    private Context context;
    public ApplicationsPresenter(Context context) {
        this.context = context;
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
                datos.toString();
            }
        }, context, "https://itunes.apple.com/us/rss/topfreeapplications/").solicitudCarga();
    }
}
