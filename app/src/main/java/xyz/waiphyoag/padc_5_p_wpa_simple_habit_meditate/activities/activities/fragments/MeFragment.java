package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;

/**
 * Created by WaiPhyoAg on 5/27/18.
 */

public class MeFragment extends Fragment {


    public static MeFragment newInstance() {
        MeFragment meFragment = new MeFragment();
        return meFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.viewpod_me, container, false);
        ButterKnife.bind(this, view);


        return view;
    }
}
