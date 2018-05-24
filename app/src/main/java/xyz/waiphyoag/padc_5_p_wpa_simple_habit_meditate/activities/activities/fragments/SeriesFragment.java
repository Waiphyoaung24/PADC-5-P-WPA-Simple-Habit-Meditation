package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters.SeriesAdapter;

/**
 * Created by WaiPhyoAg on 5/24/18.
 */

public class SeriesFragment extends Fragment {
    @BindView(R.id.rv_series_list)
    RecyclerView rvSeriesList;

    private SeriesAdapter mSeriesAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_series,container,false);
        ButterKnife.bind(this,view);
        mSeriesAdapter=new SeriesAdapter();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);
        rvSeriesList.setLayoutManager(linearLayoutManager);
        rvSeriesList.setAdapter(mSeriesAdapter);

        return view;
    }
}
