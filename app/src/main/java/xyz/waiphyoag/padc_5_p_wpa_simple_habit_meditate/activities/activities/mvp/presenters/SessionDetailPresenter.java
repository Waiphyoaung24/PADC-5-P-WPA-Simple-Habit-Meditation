package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.mvp.presenters;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.model.UserModel;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CurrentProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.ProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.mvp.views.SessionDetailView;

/**
 * Created by WaiPhyoAg on 6/22/18.
 */

public class SessionDetailPresenter extends BasePresenter<SessionDetailView> {
    public SessionDetailPresenter(SessionDetailView mView) {
        super(mView);
    }

    public void onFinishLoadingCurrentProgramDetail(String programId, CurrentProgramsVO currentProgramsVO) {
        currentProgramsVO = UserModel.getInstance().getCurrentProgram();
        mView.onFinishLauchingCurrentProgram(programId, currentProgramsVO);
    }

    public void onFinishLoadingProgram(String categoryId, String programId, ProgramsVO programsVO) {
        programsVO = UserModel.getInstance().getProgramByProgramID(categoryId, programId);
        mView.onFinishLauchingPrograms(categoryId, programId, programsVO);

    }
}
