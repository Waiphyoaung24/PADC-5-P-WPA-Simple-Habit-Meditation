package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CategoriesVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.ProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.delegates.SessionsItemDelegate;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders.ProgramViewHolder;

/**
 * Created by WaiPhyoAg on 5/17/18.
 */

public class ProgramAdapter extends BaseRecyclerAdapter<ProgramViewHolder, ProgramsVO> {

    private SessionsItemDelegate mDelegate;
    private CategoriesVO mRootCategory;


    public ProgramAdapter(Context context, SessionsItemDelegate sessionsItemDelegate) {
        super(context);
        mDelegate = sessionsItemDelegate;


    }

    @NonNull
    @Override
    public ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_meditation_tips, parent, false);
        ProgramViewHolder programViewHolder = new ProgramViewHolder(view, mDelegate);
        return programViewHolder;
    }

    @Override
    public void onBindViewHolder(ProgramViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.setData(mData.get(position));
        holder.setRootCategory(mRootCategory);

    }

    public void setRootCategory(CategoriesVO category) {
        mRootCategory = category;
    }


}
