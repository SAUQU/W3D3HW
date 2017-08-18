package com.example.segundoauqui.w3d3hw;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by segundoauqui on 8/17/17.
 */



public class HttpIntentService extends IntentService {


    private static final String TAG = "HttpIntServiceTag";
    public static final String BASE_URL = "https://api.github.com/users/octocat";
    URLConnection urlConnection = null;

    public HttpIntentService() {
        super("HttpIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {


        try {
            URL url = new URL(BASE_URL);
            urlConnection = url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Scanner scanner = new Scanner(in);
            while (scanner.hasNext()) {
                Log.d(TAG, "onHandleIntent: " + scanner.nextLine());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
