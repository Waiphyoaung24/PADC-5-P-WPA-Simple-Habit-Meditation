package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.mvp.presenters;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.model.UserModel;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CategoriesVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CurrentProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.ProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.delegates.SessionsItemDelegate;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.events.RestApiEvent;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.mvp.views.SeriesSessionView;

/**
 * Created by WaiPhyoAg on 6/22/18.
 */

public class SeriesSessionPresenter extends BasePresenter<SeriesSessionView> implements SessionsItemDelegate {
    public SeriesSessionPresenter(SeriesSessionView mView) {
        super(mView);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        UserModel.getInstance().StartloadingSimpleHabit();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSessionDataLoaded(RestApiEvent.SuccessEvent event) {
        if (event.getSuccessData() == null) {
            mView.displayErrorList("Empty Data");
        } else {
            mView.displaySessionList(event.getSuccessData());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorAPIInvoking(RestApiEvent.ErrorInvokingAPIEvent errorInvokingAPIEvent) {
        mView.displayErrorList(errorInvokingAPIEvent.getErrorMsg());
    }

    @Override
    public void onTapSessionItem(ProgramsVO programsVO, CategoriesVO categoriesVO) {
        mView.lauchSessionList(programsVO.getProgramID(),categoriesVO.getCategoryID());
    }

    @Override
    public void onTapStartHere(CurrentProgramsVO currentProgramsVO) {
        mView.lauchCurrentProgram(currentProgramsVO.getProgramID());
    }

    @Override
    public void onTapTopicItem() {

    }
}
