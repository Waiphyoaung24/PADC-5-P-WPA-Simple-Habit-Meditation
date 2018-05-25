package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by WaiPhyoAg on 5/25/18.
 */

public class CategoriesVO {
    @SerializedName("category-id")
    private String categoryID;

    private String title;
    private List<ProgramsVO> programsVO;

    public String getCategoryID() {
        return categoryID;
    }

    public String getTitle() {
        return title;
    }

    public List<ProgramsVO> getProgramsVO() {
        return programsVO;
    }
}
