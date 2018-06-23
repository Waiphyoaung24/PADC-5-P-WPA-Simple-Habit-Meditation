package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.components.SharedParent;

/**
 * Created by WaiPhyoAg on 5/25/18.
 */

@Entity(tableName = "Session")
public class SessionsVO {
    @PrimaryKey
    @NonNull
    @SerializedName("session-id")
    private String sessionId;

    private String title;
    @SerializedName("length-in-seconds")
    private int lengthInSecond;
    @SerializedName("file-path")
    private String filepath;

    public String getSessionID() {
        return sessionId;
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
