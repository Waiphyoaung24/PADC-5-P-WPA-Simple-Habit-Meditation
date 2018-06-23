package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.delegates;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CategoriesVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CurrentProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.ProgramsVO;

/**
 * Created by WaiPhyoAg on 6/1/18.
 */

public interface SessionsItemDelegate {
    void onTapSessionItem(ProgramsVO programsVO, CategoriesVO categoriesVO);
    void onTapStartHere(CurrentProgramsVO currentProgramsVO);
    void onTapTopicItem();
}
