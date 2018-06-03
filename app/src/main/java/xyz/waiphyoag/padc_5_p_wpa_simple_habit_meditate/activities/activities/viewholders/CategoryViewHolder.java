package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters.ProgramAdapter;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CategoriesVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.ProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.delegates.SessionsItemDelegate;

/**
 * Created by WaiPhyoAg on 5/24/18.
 */

public class CategoryViewHolder extends BaseViewHolder<CategoriesVO> {
    @BindView(R.id.rv_morning_meditation)
    RecyclerView rvMeditationTips;

    private SessionsItemDelegate mDelegate;

    private ProgramAdapter programAdapter;
    private ProgramsVO programsVO;
    private CategoriesVO categoriesVO;

    public CategoryViewHolder(View itemView, SessionsItemDelegate sessionsItemDelegate) {
        super(itemView);
        mDelegate = sessionsItemDelegate;


        ButterKnife.bind(this, itemView);
        programAdapter = new ProgramAdapter(itemView.getContext(),mDelegate);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvMeditationTips.setLayoutManager(linearLayoutManager);
        rvMeditationTips.setAdapter(programAdapter);


    }

    @Override
    public void setData(CategoriesVO data) {
        programAdapter.setNewData(data.getPrograms());
        programAdapter.setRootCategory(data);

    }

    @Override
    public void onClick(View v) {


    }



}
