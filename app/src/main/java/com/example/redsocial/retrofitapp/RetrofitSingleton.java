package com.example.redsocial.retrofitapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static Retrofit instance;

    private RetrofitSingleton() {
        // Constructor privado para evitar que se creen instancias de esta clase
    }

    public static Retrofit getInstance() {
        if (instance == null) {
            synchronized (RetrofitSingleton.class) {
                if (instance == null) {
                    instance = new Retrofit.Builder()
                            .baseUrl("https://5283-179-6-55-223.ngrok-free.app/")  // Reemplaza con tu URL base
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return instance;
    }
}
