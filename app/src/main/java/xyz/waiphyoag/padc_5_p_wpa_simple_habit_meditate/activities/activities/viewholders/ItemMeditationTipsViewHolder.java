package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.activities.SessionDetailActivity;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CategoriesVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.ProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.delegates.SessionsItemDelegate;

/**
 * Created by WaiPhyoAg on 5/24/18.
 */

public class ItemMeditationTipsViewHolder extends BaseViewHolder<ProgramsVO> {

    @BindView(R.id.tv_tip_name)
    TextView tvTipName;

    @BindView(R.id.tips_length)
    TextView tvTipLength;

    private SessionsItemDelegate mDelegate;

    private ProgramsVO programsVO;

    public ItemMeditationTipsViewHolder(View itemView, SessionsItemDelegate sessionsItemDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mDelegate = sessionsItemDelegate;


    }

    @Override
    public void setData(ProgramsVO data) {
        tvTipName.setText(data.getTitle());

    }

    @OnClick(R.id.cv_small_content_2)
    public void onTapProgramTips(View view) {

    }


    @Override
    public void onClick(View v) {

    }
}
