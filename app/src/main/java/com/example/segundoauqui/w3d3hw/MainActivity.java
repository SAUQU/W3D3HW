package com.example.segundoauqui.w3d3hw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivityTag";
    public static final String BASE_URL_TWO = "http://samples.openweathermap.org/data/2.5/forecast?zip=94040&appid=b1b15e88fa797225412429c1c50c122a1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void makingRestCalls(View view) {

        final OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(BASE_URL_TWO)
                .build();

        switch(view.getId()){
            case R.id.btnHttp:

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        Log.d(TAG, "onResponse: " + response.body().string());
//                        resultResponce = response.body().string();
//                        Gson gson = new Gson();
//                        weatherData = gson.fromJson(resultResponce, Weather.class);
//                        Log.d(TAG, "onResponse: " + weatherData.getCity().getName());

                    }
                });
                break;
        }

    }
}
