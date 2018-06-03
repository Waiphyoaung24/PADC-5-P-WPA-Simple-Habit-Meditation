package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.delegates;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CurrentProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.ProgramsVO;

/**
 * Created by WaiPhyoAg on 6/1/18.
 */

public interface SessionsItemDelegate {
    void onTapSessionItem(String programID,String categoryId);
    void onTapStartHere(String programID);
    void onTapTopicItem();
}
