package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.components.SharedParent;

/**
 * Created by WaiPhyoAg on 5/25/18.
 */

public class ProgramsVO implements SharedParent {
    @SerializedName("program-id")
    private String programID ;

    private String title;
    private String image;

    @SerializedName("average-lengths")
    private List<Integer>length;

    private String description;
    private List<SessionsVO> sessions;

    public String getProgramID() {
        return programID;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public List<Integer> getLength() {
        return length;
    }

    public String getDescription() {
        return description;
    }

    public List<SessionsVO> getSessionsVO() {
        return sessions;
    }
}
