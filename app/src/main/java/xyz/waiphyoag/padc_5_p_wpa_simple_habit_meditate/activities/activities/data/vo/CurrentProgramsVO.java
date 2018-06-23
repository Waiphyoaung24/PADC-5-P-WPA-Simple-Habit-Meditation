package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.components.SharedParent;

/**
 * Created by WaiPhyoAg on 5/25/18.
 */

@Entity(tableName = "CurrentProgram")
public class CurrentProgramsVO implements SharedParent{

    @PrimaryKey
    @NonNull
    @SerializedName("program-id")
    private String programID;

    private String title;

    @SerializedName("current-period")
    private String currentPeriod;

    private String background;

    @Ignore
    @SerializedName("average-lengths")
    private List<Integer>length;

    private String description;

    private List<SessionsVO>sessions;

    public String getProgramID() {
        return programID;
    }

    public String getTitle() {
        return title;
    }

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public String getBackground() {
        return background;
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

    public void setProgramID(@NonNull String programID) {
        this.programID = programID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCurrentPeriod(String currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setLength(List<Integer> length) {
        this.length = length;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSessions(List<SessionsVO> sessions) {
        this.sessions = sessions;
    }
}
