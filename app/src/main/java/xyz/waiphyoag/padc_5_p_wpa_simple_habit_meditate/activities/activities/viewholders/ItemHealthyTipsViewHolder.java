package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters.MeditationTipsAdapter;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CategoriesVO;

/**
 * Created by WaiPhyoAg on 5/17/18.
 */

public class ItemHealthyTipsViewHolder extends BaseViewHolder<CategoriesVO> {
    @BindView(R.id.rv_healthy_tips)
    RecyclerView rvHealthyTips;
    private MeditationTipsAdapter meditationTipsAdapter;

    public ItemHealthyTipsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        meditationTipsAdapter=new MeditationTipsAdapter();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvHealthyTips.setAdapter(meditationTipsAdapter);
        rvHealthyTips.setLayoutManager(linearLayoutManager);



    }

    @Override
    public void setData(CategoriesVO data) {

    }

    @Override
    public void onClick(View v) {

    }
}
