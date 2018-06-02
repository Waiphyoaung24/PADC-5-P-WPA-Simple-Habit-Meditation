package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.components.SharedParent;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.SessionsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders.BaseViewHolder;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders.ItemSessionListViewHolder;

/**
 * Created by WaiPhyoAg on 6/1/18.
 */

public class SessionListAdapter extends BaseRecyclerAdapter<ItemSessionListViewHolder,SessionsVO> {

    public SessionListAdapter(Context context) {
        super(context);
    }


    @NonNull
    @Override
    public ItemSessionListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflator.inflate(R.layout.item_session_list,parent,false);
        return new ItemSessionListViewHolder(view);
    }

}




