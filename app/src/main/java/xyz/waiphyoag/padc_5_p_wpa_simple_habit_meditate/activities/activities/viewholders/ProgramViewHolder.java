package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CategoriesVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.ProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.delegates.SessionsItemDelegate;

/**
 * Created by WaiPhyoAg on 5/24/18.
 */

public class ProgramViewHolder extends BaseViewHolder<ProgramsVO> {

    @BindView(R.id.tv_tip_name)
    TextView tvTipName;

    @BindView(R.id.tips_length)
    TextView tvTipLength;

    private SessionsItemDelegate mDelegate;
    private CategoriesVO mRootCategory;
    private ProgramsVO programsVO;

    public ProgramViewHolder(View itemView, SessionsItemDelegate sessionsItemDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mDelegate = sessionsItemDelegate;


    }

    @Override
    public void setData(ProgramsVO data) {
        programsVO = data;
        tvTipName.setText(data.getTitle());

    }


    @Override
    public void onClick(View v) {

        mDelegate.onTapSessionItem(programsVO.getProgramID(), mRootCategory.getCategoryID());
    }

    public void setRootCategory(CategoriesVO category) {
        mRootCategory = category;
    }
}
