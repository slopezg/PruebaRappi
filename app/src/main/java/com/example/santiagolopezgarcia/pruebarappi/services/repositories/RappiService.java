package com.example.santiagolopezgarcia.pruebarappi.services.repositories;

import android.content.Context;
import android.util.Log;

import com.example.santiagolopezgarcia.pruebarappi.services.ResponseService;
import com.example.santiagolopezgarcia.pruebarappi.services.Suscriptor;
import com.example.santiagolopezgarcia.pruebarappi.services.FabricaServicios;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public class RappiService {
    private Suscriptor suscriptor;
    private IRappiService iRappiService;
    private FabricaServicios<IRappiService> fabricaServicios;
    private Context context;

    public RappiService(Suscriptor suscriptor, Context context, String url) {
        this.context = context;
        fabricaServicios = new FabricaServicios<>();
        try {
            if (url != null && !url.isEmpty()) {
                iRappiService = fabricaServicios.getInstancia(IRappiService.class, context, url);
            } else {
                throw new IllegalArgumentException("La url para acceder al servicio no puede estar vacia");
            }
        } catch (NoSuchAlgorithmException e) {
            Log.d(e.getMessage(), "Error contruyendo servicio de comunicaicon");
        } catch (KeyStoreException e) {
            Log.d(e.getMessage(), "Error contruyendo servicio de comunicaicon");
        } catch (UnrecoverableKeyException e) {
            Log.d(e.getMessage(), "Error contruyendo servicio de comunicaicon");
        } catch (KeyManagementException e) {
            Log.d(e.getMessage(), "Error contruyendo servicio de comunicaicon");
        }
        this.suscriptor = suscriptor;
    }

    public void solicitudCarga() {
        if (suscriptor != null) {
            Observable<ResponseService> respuesta = iRappiService.cargar();
            respuesta
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<ResponseService>() {
                        @Override
                        public void onCompleted() {
                            suscriptor.onCompletetado();
                        }

                        @Override
                        public void onError(Throwable e) {
                            suscriptor.onError(e);
                        }

                        @Override
                        public void onNext(ResponseService respuesta) {
                            suscriptor.onResultado(respuesta);
                        }
                    });
        }
    }
}

