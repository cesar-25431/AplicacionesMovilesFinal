package com.example.redsocial.repositories;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.example.redsocial.adapters.PublicationAdapter;
import com.example.redsocial.models.ApiResponse;
import com.example.redsocial.models.ListPublicationResponse;
import com.example.redsocial.models.Publicacion;
import com.example.redsocial.models.Publication;
import com.example.redsocial.services.PublicacionSerivce;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PublicacionesRepository {
    SharedPreferences sharedPreferences;
    Retrofit retrofit;
    public PublicacionesRepository(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        retrofit = new  Retrofit.Builder()
                .baseUrl("https://5283-179-6-55-223.ngrok-free.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public interface MyCallback {
        void callback();
    }

    public void listarPublicaciones(RecyclerView recyclerView) {

        Log.i("Listando","publicaciones");
        PublicacionSerivce services = retrofit.create(PublicacionSerivce.class);
        Call<ApiResponse<Publicacion>> call=services.getListPublicacion();

        call.enqueue(new Callback<ApiResponse<Publicacion>>() {
            @Override
            public void onResponse(Call<ApiResponse<Publicacion>> call, Response<ApiResponse<Publicacion>> response) {
                if (response.isSuccessful()) {
                    Log.i("respuesta",response.body().items.toString());
                    PublicationAdapter publicationAdapter = new PublicationAdapter(response.body().items);
                    recyclerView.setAdapter(publicationAdapter);
                }else{

                    PublicationAdapter publicationAdapter = new PublicationAdapter(new ArrayList<Publicacion>());
                    recyclerView.setAdapter(publicationAdapter);
                    Log.e("Error","publicaciones" + response.toString());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<Publicacion>> call, Throwable t) {
                PublicationAdapter publicationAdapter = new PublicationAdapter(new ArrayList<Publicacion>());
                recyclerView.setAdapter(publicationAdapter);
                Log.e("Error","publicaciones" + t.toString());
            }
        });
    }


}
