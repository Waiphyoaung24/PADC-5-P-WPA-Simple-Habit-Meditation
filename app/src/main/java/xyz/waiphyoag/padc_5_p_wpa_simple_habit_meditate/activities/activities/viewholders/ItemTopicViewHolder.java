package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.TopicsVO;

/**
 * Created by WaiPhyoAg on 5/18/18.
 */

public class ItemTopicViewHolder extends BaseViewHolder<TopicsVO> {

    @BindView(R.id.tv_topic_name)
    TextView tvTopicName;
    @BindView(R.id.tv_topic_desc)
    TextView tvTopicDesc;

    public ItemTopicViewHolder(View itemView) {
        super(itemView);


    }



    @Override
    public void setData(TopicsVO data) {
        tvTopicName.setText(data.getTopicName());
        tvTopicDesc.setText(data.getTopicDesc());
    }

    @Override
    public void onClick(View v) {

    }

}
