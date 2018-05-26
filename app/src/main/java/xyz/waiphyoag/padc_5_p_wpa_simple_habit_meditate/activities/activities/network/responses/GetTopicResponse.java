package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.TopicsVO;

/**
 * Created by WaiPhyoAg on 5/25/18.
 */

public class GetTopicResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private String pageNo;

    @SerializedName("topics")
    private List<TopicsVO>topicsVO;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPageNo() {
        return pageNo;
    }

    public List<TopicsVO> getTopicsVO() {
        return topicsVO;
    }
}
