package com.example.santiagolopezgarcia.pruebarappi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.santiagolopezgarcia.pruebarappi.services.Suscriptor;
import com.example.santiagolopezgarcia.pruebarappi.services.repositories.RappiService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        }, this, "https://itunes.apple.com/us/rss/topfreeapplications/").solicitudCarga();
    }
}
