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

@Entity(tableName = "Category")
public class CategoriesVO implements SharedParent {

    @PrimaryKey
    @NonNull
    @SerializedName("category-id")
    private String categoryID;

    private String title;
    @Ignore
    private List<ProgramsVO> programs;

    public String getCategoryID() {
        return categoryID;
    }

    public String getTitle() {
        return title;
    }


    public List<ProgramsVO> getPrograms() {
        return programs;
    }

    public void setCategoryID(@NonNull String categoryID) {
        this.categoryID = categoryID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrograms(List<ProgramsVO> programs) {
        this.programs = programs;
    }
}
