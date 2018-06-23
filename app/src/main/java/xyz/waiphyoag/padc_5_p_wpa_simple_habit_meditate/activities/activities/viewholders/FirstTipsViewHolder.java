package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.components.SharedParent;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CurrentProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.TopicsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.delegates.SessionsItemDelegate;

/**
 * Created by WaiPhyoAg on 5/17/18.
 */

public class FirstTipsViewHolder extends BaseViewHolder<CurrentProgramsVO> {

    @BindView(R.id.tv_content_tips_1)
    TextView tvTipsName;
    @BindView(R.id.iv_content_1)
    ImageView ivCurrentProgram;
    @BindView(R.id.tv_length)
    TextView tvLength;

    private SessionsItemDelegate mDelegate;
    private CurrentProgramsVO mcurrentProgramsVO;

    public FirstTipsViewHolder(View itemView, SessionsItemDelegate sessionsItemDelegate) {
        super(itemView);
        mDelegate = sessionsItemDelegate;


    }

    @Override
    public void setData(CurrentProgramsVO data) {

        mcurrentProgramsVO=data;
        String avgLength = "";

        for (int length : data.getLength()) {
            avgLength = avgLength + length;

        }
        tvLength.setText(avgLength + "mins");


    }


    @Override
    public void onClick(View v) {
        mDelegate.onTapStartHere(mcurrentProgramsVO);


    }
}
