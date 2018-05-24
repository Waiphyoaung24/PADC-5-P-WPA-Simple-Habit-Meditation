package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters.MeditationTipsAdapter;

/**
 * Created by WaiPhyoAg on 5/24/18.
 */

public class ItemMorningMeditationViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.rv_morning_meditation)
    RecyclerView rvMeditationTips;
    private MeditationTipsAdapter meditationTipsAdapter;
    public ItemMorningMeditationViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this,itemView);
        meditationTipsAdapter=new MeditationTipsAdapter();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvMeditationTips.setLayoutManager(linearLayoutManager);
        rvMeditationTips.setAdapter(meditationTipsAdapter);




    }
}
