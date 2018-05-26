package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.Events.RestApiEvent;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters.ItemTopicAdapter;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters.SeriesAdapter;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.model.UserModel;

/**
 * Created by WaiPhyoAg on 5/24/18.
 */

public class SeriesFragment extends Fragment {
    @BindView(R.id.rv_series_list)
    RecyclerView rvSeriesList;
    private UserModel model;
    private ItemTopicAdapter mTopicAdapter;

    private SeriesAdapter mSeriesAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_series,container,false);
        ButterKnife.bind(this,view);
        mSeriesAdapter=new SeriesAdapter(view.getContext());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);
        rvSeriesList.setLayoutManager(linearLayoutManager);
        rvSeriesList.setAdapter(mSeriesAdapter);
        UserModel.getInstance().StartloadingSimpleHabit();




        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onTopicLoaded(RestApiEvent.LoadedTopicList event)
    {
        mTopicAdapter=new ItemTopicAdapter(getContext());
        if (event.getLoadTopicsList() != null && event.getLoadTopicsList().size() > 0) {
            mTopicAdapter.appendNewData(event.getLoadTopicsList());
        }

    }
}
