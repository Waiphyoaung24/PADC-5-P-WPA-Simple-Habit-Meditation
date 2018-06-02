package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.activities.SessionDetailActivity;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters.MeditationTipsAdapter;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.components.SharedParent;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CategoriesVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CurrentProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.ProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.delegates.SessionsItemDelegate;

/**
 * Created by WaiPhyoAg on 5/24/18.
 */

public class ItemMorningMeditationViewHolder extends BaseViewHolder<CategoriesVO> implements SessionsItemDelegate {
    @BindView(R.id.rv_morning_meditation)
    RecyclerView rvMeditationTips;

    private SessionsItemDelegate mDelegate;

    private MeditationTipsAdapter meditationTipsAdapter;
    private ProgramsVO programsVO;

    public ItemMorningMeditationViewHolder(View itemView, SessionsItemDelegate sessionsItemDelegate) {
        super(itemView);
        mDelegate = sessionsItemDelegate;


        ButterKnife.bind(this, itemView);
        meditationTipsAdapter = new MeditationTipsAdapter(itemView.getContext(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvMeditationTips.setLayoutManager(linearLayoutManager);
        rvMeditationTips.setAdapter(meditationTipsAdapter);


    }

    @Override
    public void setData(CategoriesVO data) {

        meditationTipsAdapter.setNewData(data.getPrograms());


    }

    @Override
    public void onClick(View v) {

        mDelegate.onTapSessionItem(programsVO);
    }


    @Override
    public void onTapSessionItem(ProgramsVO programsVO) {

        Intent intent = SessionDetailActivity.newIntent(itemView.getContext(),programsVO.getProgramID());
        itemView.getContext().startActivity(intent);
    }

    @Override
    public void onTapStartHere(CurrentProgramsVO currentProgramsVO) {

    }

    @Override
    public void onTapTopicItem() {

    }
}
