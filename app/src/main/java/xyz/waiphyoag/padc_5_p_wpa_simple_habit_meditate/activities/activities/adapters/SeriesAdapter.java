package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders.CategoryTipsViewHolder;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders.ItemHealthyTipsViewHolder;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders.FirstTipsViewHolder;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders.ItemMorningMeditationViewHolder;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders.ItemNewTipsViewHolder;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders.ItemTopicViewHolder;

/**
 * Created by WaiPhyoAg on 5/20/18.
 */

public class SeriesAdapter extends BaseRecyclerAdapter {

    private static final int VT_MAIN_CONTENT = 0;
    private static final int VT_MEDITATION = 1;
    private static final int VT_HEALTHY = 2;
    private static final int VT_NEW = 3;
    private static final int VT_CATEGORY = 4;

    public SeriesAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case VT_MAIN_CONTENT:
                viewHolder = new FirstTipsViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_main_content, parent, false));
                break;
            case VT_MEDITATION:
                viewHolder = new ItemMorningMeditationViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_morning_meditation, parent, false));
                break;
            case VT_HEALTHY:
                viewHolder = new ItemHealthyTipsViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_healthy_tips, parent, false));
                break;
            case VT_NEW:
                viewHolder = new ItemNewTipsViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_new_tips, parent, false));
                break;
            case VT_CATEGORY:
                viewHolder = new CategoryTipsViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_category_tips, parent, false));
                break;

        }
        return viewHolder;

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        int i = 0;
        switch (position) {
            case 0:
                i = VT_MAIN_CONTENT;
                break;
            case 1:
                i = VT_MEDITATION;
                break;
            case 2:
                i = VT_HEALTHY;
                break;
            case 3:
                i = VT_NEW;
                break;
            case 4:
                i = VT_CATEGORY;
                break;
        }

        return i;
    }


    @Override
    public int getItemCount() {
        return 5;


    }
}
