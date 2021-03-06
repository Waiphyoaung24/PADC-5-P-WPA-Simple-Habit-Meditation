package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.network.responses;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CategoriesVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CurrentProgramsVO;

/**
 * Created by WaiPhyoAg on 5/26/18.
 */

public class GetCategoryResponse {


    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private String pageNo;

    @SerializedName("categoriesPrograms")
    private List<CategoriesVO>categoriesPrograms;


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

    public List<CategoriesVO> getCategoriesPrograms() {
        return categoriesPrograms;
    }
}
