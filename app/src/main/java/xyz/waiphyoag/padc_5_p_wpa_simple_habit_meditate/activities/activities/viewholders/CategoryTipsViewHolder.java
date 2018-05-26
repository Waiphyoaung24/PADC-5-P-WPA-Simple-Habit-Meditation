package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters.ItemTopicAdapter;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.TopicsVO;

/**
 * Created by WaiPhyoAg on 5/24/18.
 */

public class CategoryTipsViewHolder extends BaseViewHolder<TopicsVO> {
    @BindView(R.id.rv_category_tips)
    RecyclerView rvCategoryTips;


    private ItemTopicAdapter mItemTopicAdapter;
    public CategoryTipsViewHolder(View itemView) {
        super(itemView);


        ButterKnife.bind(this,itemView);
        mItemTopicAdapter =new ItemTopicAdapter(itemView.getContext());
        LinearLayoutManager linearLayoutManagerforCategoryTips=new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.VERTICAL,false);
        rvCategoryTips.setAdapter(mItemTopicAdapter);
        rvCategoryTips.setLayoutManager(linearLayoutManagerforCategoryTips);




    }

    @Override
    public void setData(TopicsVO data) {



    }

    @Override
    public void onClick(View v) {

    }
}
