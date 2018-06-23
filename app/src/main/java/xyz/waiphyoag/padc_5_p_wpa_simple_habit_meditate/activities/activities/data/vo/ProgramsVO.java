package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.components.SharedParent;

/**
 * Created by WaiPhyoAg on 5/25/18.
 */

@Entity(tableName = "Program")
public class ProgramsVO {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "programId")
    @SerializedName("program-id")
    private String programID;

    private String title;
    private String image;

    @SerializedName("average-lengths")
    private List<Integer> length;

    public String categoryId;

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

    public void setProgramID(@NonNull String programID) {
        this.programID = programID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLength(List<Integer> length) {
        this.length = length;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSessions(List<SessionsVO> sessions) {
        this.sessions = sessions;
    }
}
