package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.components.SharedParent;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CategoriesVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CurrentProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.TopicsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.delegates.SessionsItemDelegate;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders.BaseViewHolder;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders.FirstTipsViewHolder;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders.CategoryViewHolder;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders.ItemTopicViewHolder;

/**
 * Created by WaiPhyoAg on 5/20/18.
 */

public class SeriesAdapter extends BaseRecyclerAdapter<BaseViewHolder, SharedParent> {

    private static final int VT_MAIN_CONTENT = 0;
    private static final int VT_MEDITATION = 1;
    private static final int VT_HEALTHY = 2;
    private static final int VT_NEW = 3;
    private static final int VT_CATEGORY = 4;

    private SessionsItemDelegate mDelegate;
    public SeriesAdapter(Context context,SessionsItemDelegate sessionsItemDelegate) {
        super(context);
        mDelegate=sessionsItemDelegate;


    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BaseViewHolder viewHolder = null;
        switch (viewType) {
            case VT_MAIN_CONTENT:
                viewHolder = new FirstTipsViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_main_content, parent, false),mDelegate);
                break;
            case VT_MEDITATION:
                viewHolder = new CategoryViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_morning_meditation, parent, false),mDelegate);
                break;

            case VT_CATEGORY:
                viewHolder = new ItemTopicViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.view_holder_program, parent, false));
                break;

        }
        return viewHolder;

    }


    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) instanceof CurrentProgramsVO) {
            return VT_MAIN_CONTENT;
        } else if (mData.get(position) instanceof CategoriesVO) {
            return VT_MEDITATION;
        } else if (mData.get(position) instanceof TopicsVO) {
            return VT_CATEGORY;


        }
        return position;
    }

    @Override
    public int getItemCount() {
        return mData.size();


    }



}
