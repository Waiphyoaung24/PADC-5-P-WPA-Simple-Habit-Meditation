package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.TopicsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders.BaseViewHolder;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders.ItemTopicViewHolder;

/**
 * Created by WaiPhyoAg on 5/18/18.
 */

public class ItemTopicAdapter extends BaseRecyclerAdapter<BaseViewHolder, TopicsVO> {
    public ItemTopicAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ItemTopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemTopicViewHolder = mLayoutInflator.inflate(R.layout.item_category_tips, parent, false);
        return new ItemTopicViewHolder(itemTopicViewHolder);
    }

}



