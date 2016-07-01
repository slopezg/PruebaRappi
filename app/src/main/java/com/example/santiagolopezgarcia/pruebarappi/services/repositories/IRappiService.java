package com.example.santiagolopezgarcia.pruebarappi.services.repositories;

import com.example.santiagolopezgarcia.pruebarappi.services.ResponseService;

import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public interface IRappiService {
    @POST("limit=20/json")
    Observable<ResponseService> cargar();
}
