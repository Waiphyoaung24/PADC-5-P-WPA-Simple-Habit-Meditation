package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.network.responses.GetTopicResponse;

/**
 * Created by WaiPhyoAg on 5/25/18.
 */

public interface SimpleHabitApi {

        @FormUrlEncoded
        @POST("getTopics.php")
        Call<GetTopicResponse>loadData(
                @Field("access_token")String accessToken,
                @Field("page")int pageNo);

}
