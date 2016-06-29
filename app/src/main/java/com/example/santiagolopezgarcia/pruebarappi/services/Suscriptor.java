package com.example.santiagolopezgarcia.pruebarappi.services;

/**
 * Created by santiagolopezgarcia on 29/06/16.
 */
public interface Suscriptor {
    void onError(Throwable e);

    void onCompletetado();

    <T> void  onResultado(T datos);
}
