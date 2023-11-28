package com.example.redsocial.utils;

import android.net.ConnectivityManager;
import android.content.Context;
import android.net.NetworkInfo;

public class Herramienta {

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }
}