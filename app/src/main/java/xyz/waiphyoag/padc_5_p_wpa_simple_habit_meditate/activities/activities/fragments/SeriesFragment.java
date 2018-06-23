package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.activities.SessionDetailActivity;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.components.SharedParent;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters.SeriesAdapter;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.delegates.SessionsItemDelegate;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.mvp.presenters.SeriesSessionPresenter;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.mvp.views.HomeScreenView;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.mvp.views.SeriesSessionView;

/**
 * Created by WaiPhyoAg on 5/24/18.
 */

public class SeriesFragment extends Fragment implements SeriesSessionView {
    @BindView(R.id.rv_series_list)
    RecyclerView rvSeriesList;

    private SeriesAdapter mSeriesAdapter;
    private SessionsItemDelegate mDelegate;

    private SeriesSessionPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series, container, false);
        ButterKnife.bind(this, view);
        mPresenter = new SeriesSessionPresenter(this);
        mPresenter.onCreate();
        mDelegate = mPresenter;
        mSeriesAdapter = new SeriesAdapter(view.getContext(), mDelegate);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        rvSeriesList.setLayoutManager(linearLayoutManager);
        rvSeriesList.setAdapter(mSeriesAdapter);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.onPause();
    }


//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        mDelegate = (SessionsItemDelegate) context;
//
//    }

    @Override
    public void displaySessionList(List<SharedParent> mData) {
        mSeriesAdapter.setNewData(mData);
    }

    @Override
    public void displayErrorList(String errorMsg) {
        Snackbar.make(rvSeriesList, errorMsg, Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    public void lauchSessionList(String programId, String categoryId) {
        Intent intent = SessionDetailActivity.newIntentForCategories(getContext(), categoryId, programId);
        startActivity(intent);
    }

    @Override
    public void lauchCurrentProgram(String programId) {
        Intent intent = SessionDetailActivity.newIntentForCurrentProgram(getContext());
        startActivity(intent);
    }
}

