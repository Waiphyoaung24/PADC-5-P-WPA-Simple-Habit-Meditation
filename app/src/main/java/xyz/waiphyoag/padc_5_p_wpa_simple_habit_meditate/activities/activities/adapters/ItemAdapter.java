package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WaiPhyoAg on 5/24/18.
 */

public class ItemAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragmentList;
    private List<String> tabTitleList;

    public ItemAdapter(FragmentManager fm) {
        super(fm);
        mFragmentList = new ArrayList<>();
        tabTitleList = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addTab(String tabLabel, Fragment fragment) {
        tabTitleList.add(tabLabel);
        mFragmentList.add(fragment);
        notifyDataSetChanged();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitleList.get(position);
    }
}

