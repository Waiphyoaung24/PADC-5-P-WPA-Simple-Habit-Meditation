package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.mvp.presenters;

import java.util.List;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CategoriesVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CurrentProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.ProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.delegates.SessionsItemDelegate;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.mvp.views.HomeScreenView;

/**
 * Created by WaiPhyoAg on 6/22/18.
 */

public class HomeScreenPresenter extends BasePresenter<HomeScreenView> {
    public HomeScreenPresenter(HomeScreenView mView) {
        super(mView);
    }


}
