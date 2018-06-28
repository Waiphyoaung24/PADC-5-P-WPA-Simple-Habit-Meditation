package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.model;

import android.content.Context;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.network.SimpleHabitApi;

/**
 * Created by WaiPhyoAg on 6/28/18.
 */

public class BaseModel {
    private SimpleHabitApi theApi;

    protected BaseModel(Context context) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/simple-habits/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        theApi = retrofit.create(SimpleHabitApi.class);
    }
}
