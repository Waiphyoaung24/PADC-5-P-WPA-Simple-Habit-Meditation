package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.mvp.views;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CurrentProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.ProgramsVO;

/**
 * Created by WaiPhyoAg on 6/22/18.
 */

public interface SessionDetailView extends BaseView {

    void onFinishLauchingCurrentProgram (String programId, CurrentProgramsVO currentProgramsVO);
    void onFinishLauchingPrograms (String categoryId, String programId, ProgramsVO programsVO);
}
