package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CurrentProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.ProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.SessionsVO;

/**
 * Created by WaiPhyoAg on 6/1/18.
 */

public class ItemSessionListViewHolder extends BaseViewHolder<SessionsVO> {
    @BindView(R.id.tv_session_list_title)
    TextView tvSessionListTitle;
    @BindView(R.id.tv_session_order)
    TextView tvSessionOrder;
    @BindView(R.id.tv_session_length)
    TextView tvSessionLength;

    public ItemSessionListViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(SessionsVO data) {
        tvSessionListTitle.setText(data.getTitle());
        tvSessionOrder.setText(data.getSessionID());

         String avgLength = data.getLengthInSecond()/60+":"+data.getLengthInSecond()%60;
         tvSessionLength.setText(avgLength);

    }


    @Override
    public void onClick(View v) {

    }
}
