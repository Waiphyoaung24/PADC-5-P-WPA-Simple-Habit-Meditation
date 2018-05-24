package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters.MeditationTipsAdapter;

/**
 * Created by WaiPhyoAg on 5/17/18.
 */

public class ItemNewTipsViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.rv_new_tips)
    RecyclerView rvNewTips;
    private MeditationTipsAdapter meditationTipsAdapter;
    public ItemNewTipsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        meditationTipsAdapter=new MeditationTipsAdapter();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvNewTips.setAdapter(meditationTipsAdapter);
        rvNewTips.setLayoutManager(linearLayoutManager);
}
}
