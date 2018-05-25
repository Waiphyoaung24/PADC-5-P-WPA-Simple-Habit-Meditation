package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by WaiPhyoAg on 5/25/18.
 */

public class SessionsVO {
    @SerializedName("session-id")
    private String sessionID;

    private String title;
    @SerializedName("length-in-seconds")
    private int lengthInSecond;
    @SerializedName("file-path")
    private String filepath;

    public String getSessionID() {
        return sessionID;
    }

    public String getTitle() {
        return title;
    }

    public int getLengthInSecond() {
        return lengthInSecond;
    }

    public String getFilepath() {
        return filepath;
    }
}
