package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters.ItemTopicAdapter;

/**
 * Created by WaiPhyoAg on 5/24/18.
 */

public class CategoryTipsViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.rv_category_tips)
    RecyclerView rvCategoryTips;
    private ItemTopicAdapter mItemTopicAdapter;
    public CategoryTipsViewHolder(View itemView) {
        super(itemView);


        ButterKnife.bind(this,itemView);
        mItemTopicAdapter =new ItemTopicAdapter();
        LinearLayoutManager linearLayoutManagerforCategoryTips=new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.VERTICAL,false);
        rvCategoryTips.setAdapter(mItemTopicAdapter);
        rvCategoryTips.setLayoutManager(linearLayoutManagerforCategoryTips);
    }
}
