package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.mvp.views;

import java.util.List;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.components.SharedParent;

/**
 * Created by WaiPhyoAg on 6/22/18.
 */

public interface SeriesSessionView extends BaseView {

    void displaySessionList (List<SharedParent> mData);
    void displayErrorList(String errorMsg);
    void lauchSessionList(String programId, String categoryId);

    void lauchCurrentProgram(String programId);
}
