package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.network.DataAgents;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.Events.RestApiEvent;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.network.SimpleHabitApi;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.network.responses.GetTopicResponse;

/**
 * Created by WaiPhyoAg on 5/25/18.
 */

public class RetrofitDataAgent implements SimpleHabitDataAgent {


    private static RetrofitDataAgent objInstance;
    private SimpleHabitApi simpleHabitApi;

    private RetrofitDataAgent() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/simple-habits/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();

        simpleHabitApi = retrofit.create(SimpleHabitApi.class);
    }

    public static RetrofitDataAgent getInstance() {
        if (objInstance == null) {
            objInstance = new RetrofitDataAgent();
        }
        return objInstance;
    }


    @Override
    public void loadData(int pageNo, String accessToken) {

        Call<GetTopicResponse> loadTopicData = simpleHabitApi.loadData(accessToken, pageNo);
            loadTopicData.enqueue(new Callback<GetTopicResponse>() {
                @Override
                public void onResponse(Call<GetTopicResponse> call, Response<GetTopicResponse> response) {
                    GetTopicResponse getTopicResponse = response.body();
                    if (getTopicResponse != null
                            && getTopicResponse.getTopicsVO().size() > 0) {
                        RestApiEvent.LoadedTopicList loadedTopicList = new RestApiEvent.LoadedTopicList(getTopicResponse.getPageNo(), getTopicResponse.getTopicsVO());
                        EventBus.getDefault().post(loadedTopicList);
                    } else {
                        RestApiEvent.ErrorInvokingAPIEvent errorEvent = new RestApiEvent.ErrorInvokingAPIEvent("No data could be loaded for now, Please try again");
                        EventBus.getDefault().post(errorEvent);
                    }

                }


                @Override
                public void onFailure(Call<GetTopicResponse> call, Throwable t) {
                    RestApiEvent.ErrorInvokingAPIEvent errorEvent = new RestApiEvent.ErrorInvokingAPIEvent(t.getMessage());
                    EventBus.getDefault().post(errorEvent);
                }
            });

        }
    }



