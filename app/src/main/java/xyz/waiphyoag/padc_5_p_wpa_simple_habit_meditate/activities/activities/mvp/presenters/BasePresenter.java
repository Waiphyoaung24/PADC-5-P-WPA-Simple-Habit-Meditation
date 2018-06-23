package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.mvp.presenters;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.mvp.views.BaseView;

/**
 * Created by WaiPhyoAg on 6/22/18.
 */

public abstract class BasePresenter<T extends BaseView> {
    protected T mView;

    public BasePresenter(T mView) {
        this.mView = mView;
    }

    public void onCreate() {


    }

    public void onStart() {


    }

    public void onResume() {

    }

    public void onPause() {

    }

    public void onStop() {


    }

    public void onDestroy() {

    }
}
